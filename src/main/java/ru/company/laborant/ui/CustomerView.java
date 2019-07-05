package ru.company.laborant.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.util.StringUtils;
import ru.company.laborant.jpa.dao.CustomerRepository;
import ru.company.laborant.jpa.domain.Customer;

/**
 * @author Cheranev N.
 * created on 21.05.2019.
 */
@Route(value = "customer", layout = MainLayout.class)
//@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Заказчики")
public class CustomerView extends VerticalLayout {

    public static final String VIEW_NAME = "customer";
    public static final String VIEW_TITLE = "Заказчики";
    private final CustomerEditor editor;
    private final CustomerRepository customerRepository;
    final Grid<Customer> grid;
    final TextField filter;
    private final Button addNew;

    public CustomerView(CustomerRepository customerRepository, CustomerEditor editor) {
        this.customerRepository = customerRepository;
        this.editor = editor;

        filter = new TextField();
        addNew = new Button("Новый заказчик", VaadinIcon.PLUS.create());

        grid = new Grid<>(Customer.class);
        grid.setColumns("id", "fullName", "address", "phone", "postIndex");
        grid.removeColumnByKey("id");

        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editCustomer(e.getValue());
        });

        HorizontalLayout mainContent = new HorizontalLayout(grid, editor);
        HorizontalLayout forms = new HorizontalLayout(filter, addNew);

        mainContent.setSizeFull();
        grid.setSizeFull();
        setSizeFull();

        add(forms, mainContent);

        filter.setPlaceholder("Фильтр");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listCustomers(e.getValue()));

        addNew.addClickListener(e -> editor.editCustomer(new Customer("",
                "", "", "")));

        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listCustomers(filter.getValue());
        });
        listCustomers(null);
    }

    void listCustomers(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(customerRepository.findAll());
        }
        else {
            grid.setItems(customerRepository.findAllByFullNameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrPostIndexContainingIgnoreCase(filterText,
                    filterText, filterText, filterText));
        }
    }
}