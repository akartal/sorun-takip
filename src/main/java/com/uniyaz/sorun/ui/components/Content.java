package com.uniyaz.sorun.ui.components;

import com.uniyaz.sorun.ui.views.AddCategoryView;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 17.12.2019.
 */
public class Content extends VerticalLayout {

    public Content() {
        AddCategoryView addCategoryView = new AddCategoryView();
        addComponent(addCategoryView);
    }
}
