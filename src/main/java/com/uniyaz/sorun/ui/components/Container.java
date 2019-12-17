package com.uniyaz.sorun.ui.components;

import com.vaadin.ui.HorizontalLayout;

/**
 * Created by AKARTAL on 17.12.2019.
 */
public class Container extends HorizontalLayout {

    public Container() {
        setWidth(100, Unit.PERCENTAGE);

        SideBar sideBar = new SideBar();
        addComponent(sideBar);

        Content content = new Content();
        addComponent(content);

        setExpandRatio(sideBar, 3f);
        setExpandRatio(content, 7f);
    }
}
