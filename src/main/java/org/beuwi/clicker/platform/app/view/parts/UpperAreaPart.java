package org.beuwi.clicker.platform.app.view.parts;

import javafx.application.Platform;
import javafx.collections.ObservableMap;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import org.beuwi.clicker.openapi.FormLoader;
import org.beuwi.clicker.platform.app.impl.View;
import org.beuwi.clicker.platform.gui.control.HBox;
import org.beuwi.clicker.platform.gui.control.Label;

import java.text.DecimalFormat;

public class UpperAreaPart implements View, Runnable
{
	private static final DecimalFormat formatter = new DecimalFormat("00");

	private static ObservableMap<String, Object> nameSpace;

	private static FormLoader loader;

	private static StackPane root;

	private static HBox component;

	// Time Text Label
	private static Label label;

	// Start / Stop Action Button
	private static ToggleButton button;

	private static boolean power = false;

	private static long start = 0;

	@Override
	public void init()
	{
		loader = new FormLoader("upper-area-part");
		nameSpace = loader.getNamespace();
		root = loader.getRoot();
		component = loader.getComponent();

		Thread thread = new Thread(this);

		label = (Label) component.getItem(0);
		button = (ToggleButton) component.getItem(1);

		label.setText("00 : 00 : 00");
		button.setText("Start");

		button.setOnAction(event ->
		{
			button.setText(!button.isSelected() ? "Start" : "Stop");

			// Start
			if (button.isSelected())
			{
				start = System.currentTimeMillis();
				power = true;

				thread.start();
			}
			else
			{
				power = false;
				label.setText("00 : 00 : 00");
			}
		});
	}

	@Override
	public void run()
	{
		while (power)
		{
			long time = System.currentTimeMillis() - start;

			try
			{
				Thread.sleep(10);

				Platform.runLater(() ->
				{
					label.setText
					(
						formatter.format((time / (1000 * 60)) % 60) + " : " +
						formatter.format((time / 1000) % 60) + " : " +
						formatter.format((time % 1000) / 10)
					);
				});
			}
			catch (InterruptedException e)
			{

			}
		}
	}

	public static StackPane getRoot()
	{
		return root;
	}

	public static HBox getComponent()
	{
		return component;
	}

	public static ObservableMap<String, Object> getNameSpace()
	{
		return nameSpace;
	}
}