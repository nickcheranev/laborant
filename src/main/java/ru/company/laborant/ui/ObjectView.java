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
import ru.company.laborant.jpa.dao.ObjectRepository;
import ru.company.laborant.jpa.domain.Object;

@Route(value = "object", layout = MainLayout.class)
@PageTitle("Объект")
public class ObjectView extends VerticalLayout {

    public static final String VIEW_NAME = "object";
    public static final String VIEW_TITLE = "Объект";

    private final ObjectRepository repository;
    private final ObjectView.ObjectEditor editor;
    private final Grid<Object> grid;
    final TextField filter;
    private final Button addNew;

    public ObjectView (ObjectRepository repository, ObjectEditor editor) {
        this.repository = repository;
        this.editor = editor;

        filter = new TextField();
        addNew = new Button("Новый объект", VaadinIcon.PLUS.create());

        grid = new Grid<>(Object.class);
        grid.setColumns("id", "name");
        grid.removeColumnByKey("id");

        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editObject(e.getValue());
        });
        HorizontalLayout mainContent = new HorizontalLayout(grid, editor);
        HorizontalLayout forms = new HorizontalLayout(filter, addNew);

        mainContent.setSizeFull();
        grid.setSizeFull();
        setSizeFull();

        add(forms, mainContent);

        filter.setPlaceholder("Фильтр");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listObject(e.getValue()));

        addNew.addClickListener(e -> editor.editObject(new Object("")));

        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listObject(filter.getValue());
        });
        listObject(null);
    }
    void listObject(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(repository.findAll());
        }
        else {
            grid.setItems(repository.findAllByNameContainingIgnoreCase(filterText));
        }
    }
    @Component
    static class ObjectEditor extends VerticalLayout implements KeyNotifier {

        private Object object;
        private final ObjectRepository repository;

        TextField name = new TextField("Наименование");

        Button save = new Button("Сохранить", VaadinIcon.CHECK.create());
        Button cancel = new Button("Отмена");
        Button delete = new Button("Удалить", VaadinIcon.TRASH.create());
        HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

        Binder<Object> binder = new Binder<>(Object.class);

        //обработчик изменений
        private ChangeHandler changeHandler;

        @Autowired
        public ObjectEditor (ObjectRepository repository) {
            this.repository = repository;

            add(name, actions);

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
            cancel.addClickListener(e -> editObject(null));
            setVisible(false);
        }
        void delete() {
            repository.delete(object);
            changeHandler.onChange();
        }

        void save() {
            repository.save(object);
            changeHandler.onChange();
        }
        public interface ChangeHandler {
            void onChange();
        }
        public final void editObject(Object c) {
            if (c == null) {
                setVisible(false);
                return;
            }
            final boolean persisted = c.getId() != null;
            if (persisted) {
                object = repository.findById(c.getId()).get();
            }
            else {
                object = c;
            }
            binder.setBean(object);
            setVisible(true);
            name.focus();
        }
        public void setChangeHandler (ChangeHandler h) {changeHandler = h;}
    }
}
