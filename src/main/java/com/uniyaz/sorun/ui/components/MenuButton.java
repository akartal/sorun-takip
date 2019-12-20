package com.uniyaz.sorun.ui.components;

import com.uniyaz.MyUI;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by AKARTAL on 18.12.2019.
 */
public class MenuButton extends Button {

    public MenuButton(FontAwesome fontAwesome) {
        setIcon(fontAwesome);
        setWidth(100, Unit.PERCENTAGE);
        addStyleName(ValoTheme.BUTTON_FRIENDLY);
    }

    @Override
    protected void fireClick(MouseEventDetails details) {
        super.fireClick(details);
        MyUI myUI = (MyUI) getUI().getCurrent();
        myUI.getHeader().setHeaderTitle(this.getCaption());
    }
}