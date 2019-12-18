package com.uniyaz.sorun.ui.views;

import com.uniyaz.sorun.domain.Category;
import com.uniyaz.sorun.ui.components.SaveButton;
import com.uniyaz.sorun.utils.HibernateUtil;
import com.vaadin.ui.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by AKARTAL on 17.12.2019.
 */
public class AddCategoryView extends VerticalLayout {

    private FormLayout mainLayout;

    public AddCategoryView() {
        mainLayout = new FormLayout();
        addComponent(mainLayout);

        TextField idField = new TextField("Id");
        idField.setEnabled(false);
        mainLayout.addComponent(idField);

        TextField nameField = new TextField("Name");
        mainLayout.addComponent(nameField);

        SaveButton saveButton = new SaveButton();
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session sessionEx = null;
                try (Session session = sessionFactory.openSession();) {
                    sessionEx = session;
                    session.getTransaction().begin();
                    String nameFieldValue = nameField.getValue();
                    Category category = new Category();
                    category.setName(nameFieldValue);
                    category = (Category) session.merge(category);
                    idField.setValue(category.getId().toString());
                    session.getTransaction().commit();
                    Notification.show("İşlem Başarılı");
                } catch (Exception ex) {
                    sessionEx.getTransaction().rollback();
                    System.out.println(ex.getMessage());
                    Notification.show(ex.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        mainLayout.addComponent(saveButton);
    }
}
