package com.uniyaz.sorun.ui.components;

import com.uniyaz.sorun.ui.views.*;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 17.12.2019.
 */
public class SideBar extends VerticalLayout {

    private Content content;

    private MenuButton btnCategoryMenuButton;
    private MenuButton btnCategoryPropertyMenuButton;
    private MenuButton btnCategoryListMenuButton;
    private MenuButton btnIssueMenuButton;
    private MenuButton btnListIssueMenuButton;

    public SideBar(Content content) {

        this.content = content;

        setSpacing(true);
        setMargin(true);

        buildAddCategoryMenuButton();
        addComponent(btnCategoryMenuButton);

        buildAddCategoryPropertyMenuButton();
        addComponent(btnCategoryPropertyMenuButton);

        buildListCategoryMenuButton();
        addComponent(btnCategoryListMenuButton);

        buildAddIssueMenuButton();
        addComponent(btnIssueMenuButton);

        buildListIssueMenuButton();
        addComponent(btnListIssueMenuButton);
    }

    private void buildAddIssueMenuButton() {

        btnIssueMenuButton = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnIssueMenuButton.setCaption("Sorun Ekle");
        btnIssueMenuButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AddIssueView addIssueView = new AddIssueView();
                content.setContent(addIssueView);
            }
        });
    }

    private void buildListIssueMenuButton() {
        btnListIssueMenuButton = new MenuButton(FontAwesome.LIST);
        btnListIssueMenuButton.setCaption("Sorun Listele");
        btnListIssueMenuButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ListIssueView listIssueView = new ListIssueView();
                content.setContent(listIssueView);
            }
        });
    }

    private void buildAddCategoryMenuButton() {
        btnCategoryMenuButton = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnCategoryMenuButton.setCaption("Kategori Ekle");
        btnCategoryMenuButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AddCategoryView addCategoryView = new AddCategoryView();
                content.setContent(addCategoryView);

//                Container container = (Container) getParent();
//                Content cont = (Content) container.getComponent(1);
//                cont.setContent(addCategoryView);
            }
        });
    }

    private void buildAddCategoryPropertyMenuButton() {
        btnCategoryPropertyMenuButton = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnCategoryPropertyMenuButton.setCaption("Kategori Ekle Property");
        btnCategoryPropertyMenuButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AddCategoryPropertyView addCategoryPropertyView = new AddCategoryPropertyView();
                content.setContent(addCategoryPropertyView);

//                Container container = (Container) getParent();
//                Content cont = (Content) container.getComponent(1);
//                cont.setContent(addCategoryPropertyView);
            }
        });
    }

    private void buildListCategoryMenuButton() {
        btnCategoryListMenuButton = new MenuButton(FontAwesome.LIST);
        btnCategoryListMenuButton.setCaption("Kategori Listele");
        btnCategoryListMenuButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ListCategoryView listCategoryView = new ListCategoryView();
                content.setContent(listCategoryView);
            }
        });
    }
}