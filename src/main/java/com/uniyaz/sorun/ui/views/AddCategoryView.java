package com.uniyaz.sorun.ui.views;

import com.uniyaz.sorun.dao.CategoryDao;
import com.uniyaz.sorun.domain.Category;
import com.uniyaz.sorun.ui.components.DeleteButton;
import com.uniyaz.sorun.ui.components.SaveButton;
import com.uniyaz.sorun.ui.components.StTextField;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;

/**
 * Created by AKARTAL on 17.12.2019.
 */
public class AddCategoryView extends BaseAddView {

    private StTextField idField;
    private StTextField nameField;
    private FormLayout mainLayout;
    private BeanItem<Category> item;
    private FieldGroup binder;

    public AddCategoryView() {
        fillViewByCategory(new Category());
    }

    public void fillViewByCategory(Category category) {

        item = new BeanItem<Category>(category);
        binder = new FieldGroup(item);
        binder.bind(idField, "id");
        binder.bind(nameField, "name");

        // Artık gerek kalmadı
//        idField.setValue(category.getId().toString());
//        nameField.setValue(category.getName());
    }

    public void buildMainLayout() {
        mainLayout = new FormLayout();
        addComponent(mainLayout);

        idField = new StTextField("Id");
        idField.setEnabled(false);
        mainLayout.addComponent(idField);

        nameField = new StTextField("Name");
        mainLayout.addComponent(nameField);

        SaveButton saveButton = new SaveButton();
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                saveView();
            }
        });
        mainLayout.addComponent(saveButton);

        DeleteButton deleteButton = new DeleteButton();
        deleteButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                deleteCategory();
            }
        });
        mainLayout.addComponent(deleteButton);
    }

    private void deleteCategory() {
        Category category = item.getBean();
        if (category != null) {
            CategoryDao categoryDao = new CategoryDao();
            categoryDao.deleteCategory(category);
            Notification.show("Kayıt silindi", Notification.Type.HUMANIZED_MESSAGE);
            fillViewByCategory(new Category());
        }
    }

    public void saveView() {
        // Bunlara gerek kalmadı

//        Long idFieldValue = null;
//        if (idField.getValue() != "") {
//            idFieldValue = Long.parseLong(idField.getValue());
//        }
//        String nameFieldValue = nameField.getValue();
//
//        Category category = new Category();
//        category.setId(idFieldValue);
//        category.setName(nameFieldValue);

        try {
            binder.commit();
            Category category = item.getBean();

            CategoryDao categoryDao = new CategoryDao();
            category = categoryDao.saveCategory(category);
            idField.setValue(category.getId().toString());

        } catch (FieldGroup.CommitException e) {
            System.out.println(e.getMessage());
        }
    }
}
