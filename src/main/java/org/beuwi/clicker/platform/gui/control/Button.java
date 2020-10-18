package org.beuwi.clicker.platform.gui.control;

public class Button extends javafx.scene.control.Button
{
	private static final String DEFAULT_STYLE_CLASS = "button";

	private static final int DEFAULT_PREF_WIDTH = 80;
	private static final int DEFAULT_PREF_HEIGHT = 30;

	public Button()
	{
		setPrefWidth(DEFAULT_PREF_WIDTH);
		setPrefHeight(DEFAULT_PREF_HEIGHT);
	}

	public void setMenu(ContextMenu menu)
	{
		menu.setNode(this);
	}
}
