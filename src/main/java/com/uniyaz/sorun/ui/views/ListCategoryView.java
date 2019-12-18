package com.uniyaz.sorun.ui.views;

import com.uniyaz.sorun.domain.Category;
import com.uniyaz.sorun.ui.components.SaveButton;
import com.uniyaz.sorun.utils.HibernateUtil;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by AKARTAL on 18.12.2019.
 */
public class ListCategoryView extends VerticalLayout {

    private Table table;
    private TextField idField;
    private TextField nameField;
    private SaveButton saveButton;
    private IndexedContainer indexedContainer;

    private FormLayout formLayout;

    public ListCategoryView() {

        buildTableContainer();

        buildTable();
        addComponent(table);

        buildFormLayout();
        addComponent(formLayout);

        fillTable();
    }

    private void fillTable() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sessionEx = null;
        try (Session session = sessionFactory.openSession();) {
            sessionEx = session;
            Query query = sessionEx.createQuery("Select category From Category category");
            List<Category> categoryList = query.list();
            for (Category category : categoryList) {
                Item item = indexedContainer.addItem(category);
                item.getItemProperty("id").setValue(category.getId());
                item.getItemProperty("name").setValue(category.getName());
            }

        } catch (Exception ex) {
            sessionEx.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }
    }

    private void buildTableContainer() {

        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Long.class, null);
        indexedContainer.addContainerProperty("name", String.class, null);
    }

    private void buildTable() {
        table = new Table();
        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("NO", "İSİM");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);
        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                Category category = (Category) itemClickEvent.getItemId();
                idField.setValue(category.getId().toString());
                nameField.setValue(category.getName());
            }
        });
    }

    private void buildFormLayout() {

        formLayout = new FormLayout();

        idField = new TextField("Id");
        idField.setEnabled(false);
        formLayout.addComponent(idField);

        nameField = new TextField("Name");
        formLayout.addComponent(nameField);

        saveButton = new SaveButton();
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
                    category.setId(Long.parseLong(idField.getValue()));
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
        formLayout.addComponent(saveButton);
    }
}
