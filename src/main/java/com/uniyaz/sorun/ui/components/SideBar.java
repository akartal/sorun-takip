package com.uniyaz.sorun.ui.components;

import com.uniyaz.sorun.ui.views.AddCategoryView;
import com.uniyaz.sorun.ui.views.ListCategoryView;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 17.12.2019.
 */
public class SideBar extends VerticalLayout {

    private Header header;
    private Content content;

    private MenuButton btnCategoryMenuButton;
    private MenuButton btnCategoryListMenuButton;

    public SideBar(Header header, Content content) {

        this.header = header;
        this.content = content;

        setSpacing(true);
        setMargin(true);

        btnCategoryMenuButton = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnCategoryMenuButton.setCaption("Kategori Ekle");
        btnCategoryMenuButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AddCategoryView addCategoryView = new AddCategoryView();
                content.setContent(addCategoryView);
            }
        });
        addComponent(btnCategoryMenuButton);

        btnCategoryListMenuButton = new MenuButton(FontAwesome.LIST);
        btnCategoryListMenuButton.setCaption("Kategori Listele");
        btnCategoryListMenuButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ListCategoryView listCategoryView = new ListCategoryView();
                content.setContent(listCategoryView);
            }
        });
        addComponent(btnCategoryListMenuButton);
    }
}