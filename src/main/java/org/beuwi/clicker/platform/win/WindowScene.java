package org.beuwi.clicker.platform.win;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

import org.beuwi.clicker.platform.util.ResourceUtils;

public class WindowScene extends Scene
{
	public WindowScene(Region root)
	{
		super(root);

		setFill(Color.TRANSPARENT);

		getStylesheets().add(ResourceUtils.getTheme("base"));
		getStylesheets().add(ResourceUtils.getTheme("dark"));
	}
}