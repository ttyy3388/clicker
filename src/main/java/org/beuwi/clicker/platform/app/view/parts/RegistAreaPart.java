package org.beuwi.clicker.platform.app.view.parts;

import javafx.collections.ObservableMap;
import org.beuwi.clicker.openapi.FormLoader;
import org.beuwi.clicker.platform.app.action.DeleteMacroAction;
import org.beuwi.clicker.platform.app.impl.View;
import org.beuwi.clicker.platform.app.view.actions.OpenDialogBoxAction;
import org.beuwi.clicker.platform.app.view.dialogs.CreateMacroDialog;
import org.beuwi.clicker.platform.app.view.dialogs.ModifyMacroDialog;
import org.beuwi.clicker.platform.gui.control.Button;
import org.beuwi.clicker.platform.gui.control.HBox;
import org.beuwi.clicker.platform.gui.control.MacroView;

public class RegistAreaPart implements View
{
	private static ObservableMap<String, Object> nameSpace;

	private static FormLoader loader;

	private static HBox root;

	private static MacroView component;

	@Override
	public void init()
	{
		loader = new FormLoader("regist-area-part");
		nameSpace = loader.getNamespace();
		root = loader.getRoot();
		component = loader.getComponent();

		((Button) nameSpace.get("btnCreate")).setOnAction(event ->
		{
			OpenDialogBoxAction.execute(new CreateMacroDialog());
		});

		((Button) nameSpace.get("btnDelete")).setOnAction(event ->
		{
			DeleteMacroAction.execute();
		});

		((Button) nameSpace.get("btnModify")).setOnAction(event ->
		{
			OpenDialogBoxAction.execute(new ModifyMacroDialog());
		});

		((Button) nameSpace.get("btnSetting")).setOnAction(event ->
		{
			// OpenDialogBoxAction.execute(new GlobalSettingDialog());
		});
	}

	public static HBox getRoot()
	{
		return root;
	}

	public static MacroView getComponent()
	{
		return component;
	}

	public static ObservableMap<String, Object> getNameSpace()
	{
		return nameSpace;
	}
}