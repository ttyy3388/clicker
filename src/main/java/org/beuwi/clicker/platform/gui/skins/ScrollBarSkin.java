package org.beuwi.clicker.platform.gui.skins;

import javafx.scene.control.ScrollBar;
import javafx.scene.input.ScrollEvent;

public class ScrollBarSkin extends javafx.scene.control.skin.ScrollBarSkin
{
	private static final double DEFAULT_SCROLL_SPEED = 0.005;

	private final ScrollBar control;

	public ScrollBarSkin(ScrollBar control)
	{
		super(control);

		this.control = control;

		control.addEventFilter(ScrollEvent.SCROLL, event ->
		{
			control.setValue(control.getValue() - (event.getDeltaY() * DEFAULT_SCROLL_SPEED));
		});

		control.setPrefWidth(10.0);
	}
}