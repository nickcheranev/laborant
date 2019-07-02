package ru.company.laborant.ui;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import ru.company.laborant.jpa.dao.CustomerRepository;
import ru.company.laborant.jpa.domain.Customer;

@SpringComponent
@UIScope
public class CustomerEditor extends VerticalLayout implements KeyNotifier {

    private CustomerRepository customerRepository;
    private Customer customer;

    TextField fullName = new TextField("Наименование");
    TextField address = new TextField("Адрес");
    TextField phone = new TextField("Телефон");
    TextField postIndex = new TextField("Индекс");

    Button save = new Button("Сохранить", VaadinIcon.CHECK.create());
    Button cancel = new Button("Отмена");
    Button delete = new Button("Удалить", VaadinIcon.TRASH.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<Customer> binder = new Binder<>(Customer.class);

    //обработчик изменений
    private ChangeHandler changeHandler;

    @Autowired
    public CustomerEditor(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

        add(fullName, address, phone, postIndex, actions);

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
        cancel.addClickListener(e -> editCustomer(null));
        setVisible(false);
    }
    void delete() {
        customerRepository.delete(customer);
        changeHandler.onChange();
    }

    void save() {

        customerRepository.save(customer);
        changeHandler.onChange();
    }

    public interface ChangeHandler {
        void onChange();
    }
    public final void editCustomer(Customer c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getId() != null;
        if (persisted) {
            customer = customerRepository.findById(c.getId()).get();
        }
        else {
            customer = c;
        }
        binder.setBean(customer);
        setVisible(true);
        fullName.focus();
    }
    public void setChangeHandler(ChangeHandler h) {
        changeHandler = h;
    }
}
