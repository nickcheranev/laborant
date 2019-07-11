package ru.company.laborant.ui;

import com.vaadin.flow.component.applayout.AbstractAppRouterLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * @author Cheranev N.
 * created on 21.05.2019.
 */
@HtmlImport("css/shared-styles.html")
@Theme(value = Lumo.class)
public class MainLayout extends AbstractAppRouterLayout {

    @Override
    protected void configure(AppLayout appLayout, AppLayoutMenu menu) {
        setMenuItem(menu, new AppLayoutMenuItem(VaadinIcon.ACADEMY_CAP.create(),
                CustomerView.VIEW_TITLE, CustomerView.VIEW_NAME));
        setMenuItem(menu, new AppLayoutMenuItem(VaadinIcon.DOCTOR.create(),
                TrialTypeView.VIEW_TITLE, TrialTypeView.VIEW_NAME));
        setMenuItem(menu, new AppLayoutMenuItem(VaadinIcon.GROUP.create(),
                EmployeeView.VIEW_TITLE, EmployeeView.VIEW_NAME));
        setMenuItem(menu, new AppLayoutMenuItem(VaadinIcon.INFO_CIRCLE.create(),
                AboutView.VIEW_TITLE, AboutView.VIEW_NAME));
    }

    private void setMenuItem(AppLayoutMenu menu, AppLayoutMenuItem menuItem) {
        menuItem.getElement().setAttribute("theme", "icon-on-top");
        menu.addMenuItem(menuItem);
    }
}
