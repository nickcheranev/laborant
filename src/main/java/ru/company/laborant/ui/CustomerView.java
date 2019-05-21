package ru.company.laborant.ui;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.Version;

/**
 * @author Cheranev N.
 * created on 21.05.2019.
 */
@Route(value = "customer", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Customer")
public class CustomerView extends HorizontalLayout {

    public static final String VIEW_NAME = "Заказчики";

    public CustomerView() {
        add(VaadinIcon.INFO_CIRCLE.create());
        add(new Span(" This is Customer Page"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
    }
}
