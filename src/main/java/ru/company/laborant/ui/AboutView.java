package ru.company.laborant.ui;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.Version;
import ru.company.laborant.LaborantApplication;

/**
 * @author Cheranev N.
 * created on 21.05.2019.
 */
@Route(value = "about", layout = MainLayout.class)
@PageTitle("About")
public class AboutView extends HorizontalLayout {

    public static final String VIEW_NAME = "about";
    public static final String VIEW_TITLE = "О Программе";

    public AboutView() {
        add(VaadinIcon.INFO_CIRCLE.create());
        add(new Span(" Лабораторная исследовательская система \"Лаборант\"" + getVersion()));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
    }

    private String getVersion() {
        return LaborantApplication.class.getPackage().getImplementationVersion();
    }
}
