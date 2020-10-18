package org.beuwi.clicker.platform.app.action;

import org.beuwi.clicker.platform.app.impl.Action;
import org.beuwi.clicker.platform.gui.control.Macro;

public class ModifyMacroAction implements Action
{
	@Override
	public void init()
	{
	}

	public static void execute(Macro target, Macro macro)
	{
		target.setName(macro.getName());
		target.setValue(macro.getValue());
	}

	@Override
	public String getName()
	{
		return "add.macro.action";
	}
}
