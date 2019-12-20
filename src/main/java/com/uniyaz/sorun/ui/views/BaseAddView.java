package com.uniyaz.sorun.ui.views;

import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 20.12.2019.
 */
public abstract class BaseAddView extends VerticalLayout {

    public BaseAddView() {
        buildMainLayout();
    }

    public abstract void buildMainLayout();

    public abstract void saveView();
}