package org.beuwi.clicker.platform.app.action;

import org.beuwi.clicker.platform.app.impl.Action;
import org.beuwi.clicker.platform.app.view.parts.RegistAreaPart;
import org.beuwi.clicker.platform.gui.control.Macro;
import org.beuwi.clicker.platform.gui.control.MacroView;

public class CreateMacroAction implements Action
{
	private static MacroView control;

	@Override
	public void init()
	{
		control = RegistAreaPart.getComponent();
	}

	public static void execute(Macro macro)
	{
		control.addMacro(macro);
	}

	@Override
	public String getName()
	{
		return "add.macro.action";
	}
}