package com.uniyaz.sorun.ui.components;

import com.uniyaz.MyUI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 17.12.2019.
 */
public class General extends VerticalLayout {

    public General() {
        Header header = new Header();
        addComponent(header);
        MyUI myUI = (MyUI) getUI().getCurrent();
        myUI.setHeader(header);

        Container container = new Container();
        addComponent(container);
    }
}