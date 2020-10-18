package org.beuwi.clicker.platform.app.view;

import javafx.geometry.Insets;

import javafx.stage.Stage;
import org.beuwi.clicker.platform.app.view.parts.RegistAreaPart;
import org.beuwi.clicker.platform.app.view.parts.UpperAreaPart;
import org.beuwi.clicker.platform.gui.control.VBox;
import org.beuwi.clicker.platform.util.SharedValues;
import org.beuwi.clicker.platform.win.WindowType;
import org.beuwi.clicker.platform.win.WindowWrap;

public class MainView extends VBox
{
	private static Stage stage;

	public MainView(Stage stage)
	{
		this.stage = stage;

		setMinWidth(500);
		setMinHeight(300);
		setPrefWidth(500);
		setPrefHeight(300);

		// setTop(UpperAreaPart.getRoot());
		// setCenter(RegistAreaPart.getRoot());

		addItem
		(
			UpperAreaPart.getRoot(),
			RegistAreaPart.getRoot()
		);

		setSpacing(10);
		setPadding(new Insets(10));
	}

	public static Stage getStage()
	{
		return stage;
	}

	public static class MainWindow extends WindowWrap
	{
		public MainWindow(Stage stage)
		{
			super(stage);

			setContent(new MainView(stage));
			setTitle(SharedValues.PROGRAM_WINDOW_TITLE);
			setType(WindowType.WINDOW);
		}
	}
}