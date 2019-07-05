package ru.company.laborant.ui;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.company.laborant.jpa.dao.TrialTypeRepository;
import ru.company.laborant.jpa.domain.TrialType;

@Route(value = "trial_type", layout = MainLayout.class)
@PageTitle("Тип испытания")
public class TrialTypeView extends VerticalLayout {

    public static final String VIEW_NAME = "trial_type";
    public static final String VIEW_TITLE = "Тип испытания";

    private final Grid<TrialType> grid;
    final TextField filter;
    private final Button addNew;
    private final TrialTypeRepository trialTypeRepository;
    private final TrialTypeEditor trialTypeEditor;

    public TrialTypeView(TrialTypeRepository trialTypeRepository, TrialTypeEditor trialTypeEditor) {

        this.trialTypeRepository = trialTypeRepository;
        this.trialTypeEditor = trialTypeEditor;

        filter = new TextField();
        addNew = new Button("Новый тип", VaadinIcon.PLUS.create());

        grid = new Grid<>(TrialType.class);
        grid.setColumns("id", "name", "description");
        grid.removeColumnByKey("id");

        grid.asSingleSelect().addValueChangeListener(e -> {
            this.trialTypeEditor.editTrialType(e.getValue());
        });

        HorizontalLayout mainContent = new HorizontalLayout(grid, this.trialTypeEditor);
        HorizontalLayout forms = new HorizontalLayout(filter, addNew);

        mainContent.setSizeFull();
        grid.setSizeFull();
        setSizeFull();

        add(forms, mainContent);

        filter.setPlaceholder("Фильтр");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listTrialType(e.getValue()));

        addNew.addClickListener(e -> this.trialTypeEditor.editTrialType(new TrialType("", "")));

        this.trialTypeEditor.setChangeHandler(() -> {
            this.trialTypeEditor.setVisible(false);
            listTrialType(filter.getValue());
        });
        listTrialType(null);
    }
    void listTrialType(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(trialTypeRepository.findAll());
        }
        else {
            grid.setItems(trialTypeRepository.findAllByNameContainingIgnoreCase(filterText));
        }

    }
    @Component
    static class TrialTypeEditor extends VerticalLayout implements KeyNotifier{

        private TrialType trialType;
        private final TrialTypeRepository repository;

        TextField name = new TextField("Тип испытания");
        TextField description = new TextField("Описание");

        Button save = new Button("Сохранить", VaadinIcon.CHECK.create());
        Button cancel = new Button("Отмена");
        Button delete = new Button("Удалить", VaadinIcon.TRASH.create());
        HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

        Binder<TrialType> binder = new Binder<>(TrialType.class);

        //обработчик изменений
        private ChangeHandler changeHandler;

        @Autowired
        public TrialTypeEditor(TrialTypeRepository repository) {
            this.repository = repository;

            add(name, description, actions);

            // bind using naming convention
            binder.bindInstanceFields(this);

            // Configure and style components
            setSpacing(true);

            save.getElement().getThemeList().add("primary");
            delete.getElement().getThemeList().add("error");
            cancel.getElement().getThemeList().add("primary");

            addKeyPressListener(Key.ENTER, e -> save());

            save.addClickListener(e -> save());
            delete.addClickListener(e -> delete());
            cancel.addClickListener(e -> editTrialType(null));
            setVisible(false);
        }
        void delete() {
            repository.delete(trialType);
            changeHandler.onChange();
        }

        void save() {
            repository.save(trialType);
            changeHandler.onChange();
        }
        public interface ChangeHandler {
            void onChange();
        }
        public final void editTrialType(TrialType c) {
            if (c == null) {
                setVisible(false);
                return;
            }
            final boolean persisted = c.getId() != null;
            if (persisted) {
                trialType = repository.findById(c.getId()).get();
            }
            else {
                trialType = c;
            }
            binder.setBean(trialType);
            setVisible(true);
            name.focus();
        }
        public void setChangeHandler(ChangeHandler h) {
            changeHandler = h;
        }
    }
}
