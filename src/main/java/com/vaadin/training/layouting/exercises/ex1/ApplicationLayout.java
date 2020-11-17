package com.vaadin.training.layouting.exercises.ex1;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.layouting.exercises.MainLayout;
import jdk.internal.jimage.ImageStrings;

@Route(value = ApplicationLayout.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class ApplicationLayout extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "ex1";
    public static final String TITLE = "Exercise 1";
    public static  final HorizontalLayout layout = new HorizontalLayout();

    public ApplicationLayout() {

        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

        final Div header = new Div();
        header.setText("This is the header. My height is 150 pixels");
        header.setClassName("header");
        header.getStyle().set("flexShrink", "0");
        header.setHeight("150px");

        layout.setSpacing(false);
        layout.setSizeFull();

        final Div content = new Div();
        content.setClassName("content");
        createTextLayout();

        final Div footer = new Div();
        footer.setText("This is the footer area. My height is 100 pixels");
        footer.setClassName("footer");
        footer.getStyle().set("flexShrink", "0");
        footer.setHeight("100px");

        add(header, layout, footer);
    }

    private void createTextLayout() {

        final Div navigation = new Div();
        navigation.setClassName("navigation");
        navigation.setWidth("25%");
        navigation.getStyle().set("flexShrink", "0");
        navigation.setText("This is the navigation area. My width is 25% of the application Layout");

        final Div content = new Div();
        content.setText("This is the Content Area");
        content.setSizeFull();
        content.getStyle().set("display", "flex");
        content.setClassName("content");
        content.getStyle().set("alignContent", "start");

        layout.add(navigation, content);
        layout.expand(content);
        layout.setDefaultVerticalComponentAlignment(Alignment.STRETCH);
    }

    /**
     * Ignore this method for now.
     *
     * @return
     */
    private Div createBlock() {
        final Div button = new Div();
        button.setText("Block");
        button.getStyle().set("background", "white");
        button.setHeight("100px");
        button.setWidth("100px");
        button.getStyle().set("margin", "2px");
        return button;
    }

}