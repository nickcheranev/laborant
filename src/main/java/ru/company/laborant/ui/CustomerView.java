package ru.company.laborant.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.Version;
import org.springframework.util.StringUtils;
import ru.company.laborant.jpa.dao.CustomerRepository;
import ru.company.laborant.jpa.domain.Customer;
import ru.company.laborant.jpa.domain.Folder;

/**
 * @author Cheranev N.
 * created on 21.05.2019.
 */
@Route(value = "customer", layout = MainLayout.class)
//@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Заказчик")
public class CustomerView extends VerticalLayout {

    public static final String VIEW_TITLE = "Заказчики";
    public static final String VIEW_NAME = "customer";
    private final CustomerRepository repo;
    private final CustomerEditor editor;
    final Grid<Customer> grid;
    final TextField filter;
    private final Button addNewBtn;

    public CustomerView(CustomerRepository repo, CustomerEditor editor) {

        this.repo = repo;
        this.editor = editor;

        filter = new TextField();
        addNewBtn = new Button("Новый заказчик", VaadinIcon.PLUS.create());

        grid = new Grid<>(Customer.class);
        grid.setColumns("id", "fullName", "address", "phone", "postIndex");
        grid.getColumnByKey("id");

        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editCustomer(e.getValue());
        });

        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        actions.setSizeFull();
        grid.setSizeFull();
        setSizeFull();

        add(actions, grid, editor);

        filter.setPlaceholder("Фильтр по наименованию");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listCustomers(e.getValue()));

        addNewBtn.addClickListener(e -> editor.editCustomer(new Customer("",
                "", "", "")));

        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listCustomers(filter.getValue());
        });

        listCustomers(null);
    }

    void listCustomers(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(repo.findAll());
        }
        else {
            grid.setItems(repo.findByFullNameStartsWithIgnoreCase(filterText));
        }
    }
}
