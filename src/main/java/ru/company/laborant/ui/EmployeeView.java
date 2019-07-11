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
import ru.company.laborant.jpa.dao.EmployeeRepository;
import ru.company.laborant.jpa.domain.Employee;

@Route(value = "employee", layout = MainLayout.class)
@PageTitle("Сотрудники")
public class EmployeeView extends VerticalLayout {

    public static final String VIEW_NAME = "employee";
    public static final String VIEW_TITLE = "Сотрудники";

    private final EmployeeRepository repository;
    private final EmployeeEditor editor;
    private final Grid<Employee> grid;
    final TextField filter;
    private final Button addNew;

    public EmployeeView(EmployeeRepository repository, EmployeeEditor editor) {
        this.repository = repository;
        this.editor = editor;

        filter = new TextField();
        addNew = new Button("Новый сотрудник", VaadinIcon.PLUS.create());

        grid = new Grid<>(Employee.class);
        grid.setColumns("id", "fullName", "address", "phone", "postIndex", "description");
        grid.removeColumnByKey("id");

        grid.asSingleSelect().addValueChangeListener(e -> {
            this.editor.editEmployee(e.getValue());
        });

        HorizontalLayout mainContent = new HorizontalLayout(grid, this.editor);
        HorizontalLayout forms = new HorizontalLayout(filter, addNew);

        mainContent.setSizeFull();
        grid.setSizeFull();
        setSizeFull();

        add(forms, mainContent);

        filter.setPlaceholder("Фильтр");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listEmployee(e.getValue()));

        addNew.addClickListener(e -> this.editor.editEmployee(new Employee("",
                "", "", "", "")));
        this.editor.setChangeHandler(() -> {
            this.editor.setVisible(false);
            listEmployee(filter.getValue());
        });
        listEmployee(null);
    }
    void listEmployee(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(repository.findAll());
        }
        else {
            grid.setItems(repository.findAllByFullNameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrPostIndexContainingIgnoreCaseOrDescriptionContainingIgnoreCase(filterText,
                    filterText, filterText, filterText, filterText));
        }
    }
    @Component
    static class EmployeeEditor extends VerticalLayout implements KeyNotifier {

        private Employee employee;
        private final EmployeeRepository repository;

        TextField fullName = new TextField("ФИО");
        TextField address = new TextField("Адресс");
        TextField phone = new TextField("Номер телефона");
        TextField postIndex = new TextField("Индекс");
        TextField description = new TextField("Описание");

        Button save = new Button("Сохранить", VaadinIcon.CHECK.create());
        Button cancel = new Button("Отмена");
        Button delete = new Button("Удалить", VaadinIcon.TRASH.create());
        HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

        Binder<Employee> binder = new Binder<>(Employee.class);

        //обработчик изменений
        private ChangeHandler changeHandler;

        @Autowired
        public EmployeeEditor(EmployeeRepository repository) {
            this.repository = repository;

            add(fullName, address, phone, postIndex, description, actions);

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
            cancel.addClickListener(e -> editEmployee(null));
            setVisible(false);
        }
        void delete() {
            repository.delete(employee);
            changeHandler.onChange();
        }

        void save() {
            repository.save(employee);
            changeHandler.onChange();
        }
        public interface ChangeHandler {
            void onChange();
        }
        public final void editEmployee(Employee c) {
            if (c == null) {
                setVisible(false);
                return;
            }
            final boolean persisted = c.getId() != null;
            if (persisted) {
                employee = repository.findById(c.getId()).get();
            }
            else {
                employee = c;
            }
            binder.setBean(employee);
            setVisible(true);
            fullName.focus();
        }
        public void setChangeHandler(ChangeHandler h) {
            changeHandler = h;
        }
    }
}
