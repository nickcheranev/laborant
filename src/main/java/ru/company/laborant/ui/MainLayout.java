package ru.company.laborant.ui;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * @author Cheranev N.
 * created on 21.05.2019.
 */
@HtmlImport("css/shared-styles.html")
@Theme(value = Lumo.class)
public class MainLayout extends FlexLayout implements RouterLayout {

    private Menu menu;

    public MainLayout() {
        setSizeFull();
        setClassName("main-layout");

        menu = new Menu();
        menu.addView(CustomerView.class, CustomerView.VIEW_NAME, VaadinIcon.ACADEMY_CAP.create());
        menu.addView(AboutView.class, AboutView.VIEW_NAME, VaadinIcon.INFO_CIRCLE.create());

        add(menu);
    }
}
