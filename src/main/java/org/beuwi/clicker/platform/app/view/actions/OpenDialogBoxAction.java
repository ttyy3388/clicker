package org.beuwi.clicker.platform.app.view.actions;

import org.beuwi.clicker.platform.app.impl.Action;
import org.beuwi.clicker.platform.gui.dialog.DialogBoxWrap;

public class OpenDialogBoxAction implements Action
{
    @Override
    public void init()
    {

    }

    public static void execute(DialogBoxWrap dialog)
    {
        dialog.open();
    }

    @Override
    public String getName()
    {
        return "open.dialog.box.action";
    }
}
