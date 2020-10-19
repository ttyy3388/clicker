package org.beuwi.clicker.platform.gui.control;

import javafx.beans.DefaultProperty;

@DefaultProperty("items")
public class ComboBox<T> extends javafx.scene.control.ComboBox<T>
{
    private static final String DEFAULT_STYLE_CLASS = "combo-box";

    private static final int DEFAULT_PREF_WIDTH = 80;
    private static final int DEFAULT_PREF_HEIGHT = 30;

    public ComboBox()
    {
        setPrefWidth(DEFAULT_PREF_WIDTH);
        setPrefHeight(DEFAULT_PREF_HEIGHT);
    }

    public void addItem(T... items)
    {
        getItems().addAll(items);
    }
}
