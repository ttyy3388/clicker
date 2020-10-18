package org.beuwi.clicker.platform.app.view.dialogs;

import javafx.application.Platform;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import org.beuwi.clicker.openapi.MouseListener;
import org.beuwi.clicker.openapi.MouseManager;
import org.beuwi.clicker.openapi.MouseObserver;
import org.beuwi.clicker.platform.app.action.ModifyMacroAction;
import org.beuwi.clicker.platform.gui.control.Button;
import org.beuwi.clicker.platform.gui.control.Macro;
import org.beuwi.clicker.platform.gui.control.TextField;
import org.beuwi.clicker.platform.gui.control.VBox;
import org.beuwi.clicker.platform.gui.dialog.DialogBoxWrap;
import org.beuwi.clicker.platform.util.ResourceUtils;

public class ModifyMacroDialog extends DialogBoxWrap
{
	private final ObservableMap<String, Object> nameSpace;
	private final FXMLLoader loader = new FXMLLoader();
	private final Button button;
	private final VBox root;

	@FXML private TextField txfMacroName;

	@FXML private TextField txfCurrentX;
	@FXML private TextField txfCurrentY;

	@FXML private TextField txfCapturedX;
	@FXML private TextField txfCapturedY;

	private final Macro target;

	// Macro : Modify Target
	public ModifyMacroDialog(Macro target)
	{
		this.target = target;

		loader.setLocation(ResourceUtils.getForm("modify-macro-dialog"));
		loader.setController(this);

		try
		{
			loader.load();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		nameSpace = loader.getNamespace();
		root = loader.getRoot();

		button = getOkButton();

		button.setText("수정");
		button.setDisable(true);
		button.setOnAction(event ->
		{
			this.action();
		});

		MouseObserver.addMouseMotionListener(new MouseListener()
		{
            @Override
            public void dragged(MouseEvent e)
            {

            }

            @Override
			public void moved(MouseEvent e)
            {
                txfCurrentX.setText(String.valueOf(e.getX()));
				txfCurrentY.setText(String.valueOf(e.getY()));
			}
		});

		txfMacroName.setText(target.getName());
		txfCapturedX.setText(target.getValueX());
		txfCapturedY.setText(target.getValueY());

		txfMacroName.getTextProperty().addListener(change ->
		{
			button.setDisable(txfMacroName.getText().isEmpty());
		});

		setUseButton(true, false);
		setOnKeyPressed(event ->
		{
			if (event.getCode().equals(KeyCode.ENTER))
			{
				if (!button.isDisable())
				{
					this.action();
				}
			}
			if (event.getCode().equals(KeyCode.F12))
			{
				txfCapturedX.setText(String.valueOf(MouseManager.getX()));
				txfCapturedY.setText(String.valueOf(MouseManager.getY()));
			}
		});

		Platform.runLater(() ->
		{
			txfMacroName.requestFocus();
		});
	}

	@Override
	public void open()
	{
		setContent(root);
		setTitle("매크로 수정");
		create();
	}

	@Override
	public void action()
	{
		Macro macro = new Macro
		(
			txfMacroName.getText(),
			txfCapturedX.getText(),
			txfCapturedY.getText()
		);

		ModifyMacroAction.execute(target, macro);
	}
}