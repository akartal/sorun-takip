package com.uniyaz.sorun.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;

/**
 * Created by AKARTAL on 18.12.2019.
 */
public class DeleteButton extends Button {

    public DeleteButton() {
        setIcon(FontAwesome.MINUS);
        setCaption("Sil");
    }
}
