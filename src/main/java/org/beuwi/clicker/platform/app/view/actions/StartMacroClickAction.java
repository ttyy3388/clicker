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
	private static MacroView control;

	@Override
	public void init()
	{
		control = RegistAreaPart.getComponent();
	}

	public static void execute()
	{
		try
		{
            for (Macro item : control.getItems())
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
	}

	@Override
	public String getName()
	{
		return "set.mouse.point.action";
	}
}
