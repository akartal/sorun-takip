package com.uniyaz.sorun.ui.components;

import com.uniyaz.sorun.ui.views.AddCategoryView;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 17.12.2019.
 */
public class SideBar extends VerticalLayout {

    public SideBar() {
        Button btn = new Button();
        btn.setCaption("Kategori Ekle");
        btn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                // Doldurulacak

//                AddCategoryView addCategoryView = new AddCategoryView();

            }
        });
        addComponent(btn);
    }
}
