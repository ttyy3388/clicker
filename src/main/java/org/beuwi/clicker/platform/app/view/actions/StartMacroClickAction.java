package org.beuwi.clicker.platform.app.view.actions;

import org.beuwi.clicker.platform.app.impl.Action;
import org.beuwi.clicker.platform.app.view.parts.RegistAreaPart;
import org.beuwi.clicker.platform.gui.control.Macro;
import org.beuwi.clicker.platform.gui.control.MacroView;

import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class StartMacroClickAction implements Action
{
	private static MacroView component;

	@Override
	public void init()
	{
		component = RegistAreaPart.getComponent();
	}

	public static void execute()
	{
		execute(false);
	}

	public static void execute(boolean isManual)
	{
		try
		{
			for (Macro item : component.getItems())
			{
				Point point = item.getValue();

				if (point != null)
				{
					Robot robot = new Robot();

					robot.mouseMove((int) point.getX(), (int) point.getY());
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		if (!isManual)
		{
			RunMacroTimerAction.execute();
		}
	}

	@Override
	public String getName()
	{
		return "start.macro.click.action";
	}
}
