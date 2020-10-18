package org.beuwi.clicker.platform.app.view.actions;

import javafx.scene.control.ToggleButton;
import org.beuwi.clicker.platform.app.impl.Action;
import org.beuwi.clicker.platform.app.view.parts.UpperAreaPart;
import org.beuwi.clicker.platform.gui.control.HBox;
import org.beuwi.clicker.platform.gui.control.Label;

public class RunMacroTimerAction implements Action
{
	private static HBox component;

	private static Label label;
	private static ToggleButton button;

	@Override
	public void init()
	{
		component = UpperAreaPart.getComponent();

		label = (Label) component.getItem(0);
		button = (ToggleButton) component.getItem(1);
	}

	public static void execute()
	{
		button.setSelected(!button.isSelected());
	}

	@Override
	public String getName()
	{
		return "run.macro.timer.action";
	}
}
