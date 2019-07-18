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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.company.laborant.jpa.dao.TraitRepository;
import ru.company.laborant.jpa.domain.Trait;

@Route(value = "trait", layout = MainLayout.class)
@PageTitle("Характеристика")
public class TraitView extends VerticalLayout {

    public static final String VIEW_NAME = "trait";
    public static final String VIEW_TITLE = "Характеристика";

    private final TraitRepository repository;
    private final TraitView.TraitEditor editor;
    private final Grid<Trait> grid;
    final TextField filter;
    private final Button addNew;

    public TraitView (TraitRepository repository, TraitEditor editor) {
        this.repository = repository;
        this.editor = editor;

        filter = new TextField();
        addNew = new Button("Новая характеристика", VaadinIcon.PLUS.create());

        grid = new Grid<>(Trait.class);
        grid.setColumns("id", "name", "description");
        grid.removeColumnByKey("id");

        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editTrait(e.getValue());
        });
        HorizontalLayout mainContent = new HorizontalLayout(grid, editor);
        HorizontalLayout forms = new HorizontalLayout(filter, addNew);

        mainContent.setSizeFull();
        grid.setSizeFull();
        setSizeFull();

        add(forms, mainContent);

        filter.setPlaceholder("Фильтр");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listTrait(e.getValue()));

        addNew.addClickListener(e -> editor.editTrait(new Trait("","")));

        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listTrait(filter.getValue());
        });
        listTrait(null);
    }
    void listTrait(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(repository.findAll());
        }
        else {
            grid.setItems(repository.findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(filterText,
                    filterText));
        }
    }
    @Component
    static class TraitEditor extends VerticalLayout implements KeyNotifier {

        private Trait trait;
        private final TraitRepository repository;

        TextField name = new TextField("Наименование");
        TextField description = new TextField("Описание");

        Button save = new Button("Сохранить", VaadinIcon.CHECK.create());
        Button cancel = new Button("Отмена");
        Button delete = new Button("Удалить", VaadinIcon.TRASH.create());
        HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

        Binder<Trait> binder = new Binder<>(Trait.class);

        //обработчик изменений
        private ChangeHandler changeHandler;

        @Autowired
        public TraitEditor (TraitRepository repository) {
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
            cancel.addClickListener(e -> editTrait(null));
            setVisible(false);
        }
        void delete() {
            repository.delete(trait);
            changeHandler.onChange();
        }

        void save() {
            repository.save(trait);
            changeHandler.onChange();
        }
        public interface ChangeHandler {
            void onChange();
        }
        public final void editTrait(Trait c) {
            if (c == null) {
                setVisible(false);
                return;
            }
            final boolean persisted = c.getId() != null;
            if (persisted) {
                trait = repository.findById(c.getId()).get();
            }
            else {
                trait = c;
            }
            binder.setBean(trait);
            setVisible(true);
            name.focus();
        }
        public void setChangeHandler (ChangeHandler h) {changeHandler = h;}
    }
}
