package com.vaadin.training.layouting.exercises.ex2;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.training.layouting.exercises.MainLayout;

import java.text.Normalizer;

@Route(value = UseFormLayout.ROUTE, layout = MainLayout.class)
public class UseFormLayout extends VerticalLayout {
    public static final String ROUTE = "ex2";
    public static final String TITLE = "Exercise 2";

    public UseFormLayout() {
        setSizeFull();

        FormLayout formLayout = new FormLayout();
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("50em", 2));

        TextField firstName = new TextField();
        firstName.setWidthFull();
        formLayout.addFormItem(firstName, "First Name");

        TextField lastName = new TextField();
        lastName.setWidthFull();
        formLayout.addFormItem(lastName, "Last Name");

        TextField email = new TextField();
        email.setWidthFull();
        formLayout.addFormItem(email, "Email").getElement().setAttribute("colspan", "2");

        FlexLayout phoneLayout = new FlexLayout();
        TextField phone = new TextField();
        formLayout.addFormItem(phoneLayout, "Phone").getElement().setAttribute("colspan", "2");

        phoneLayout.add(phone, new Checkbox("Do not Call"));
        phoneLayout.expand(phone);
        phoneLayout.setAlignItems(Alignment.CENTER);
        phoneLayout.setWidthFull();

        PasswordField password = new PasswordField();
        password.setWidthFull();
        formLayout.addFormItem(password, "Password");

        // Line Break to place Password and repeat password onto different lines
        formLayout.getElement().appendChild(ElementFactory.createBr());

        PasswordField repeatPwd = new PasswordField();
        repeatPwd.setWidthFull();
        formLayout.addFormItem(repeatPwd, "Repeat Password");

        // LineBreak
        formLayout.add(new Html("<br />"));

        Button submitBtn = new Button("Submit",
                e -> {
                    Notification.show("Data has been successfully submitted");
                });
        submitBtn.setWidth("5px");
        submitBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        formLayout.add(submitBtn);

        add(formLayout);
    }
}
