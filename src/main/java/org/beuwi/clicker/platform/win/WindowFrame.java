package org.beuwi.clicker.platform.win;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.beuwi.clicker.platform.app.view.MainView;
import org.beuwi.clicker.platform.gui.control.StackPane;
import org.beuwi.clicker.platform.util.ResourceUtils;

public class WindowFrame extends StackPane
{
	private final Stage stage;

	private WindowType type;
	private Region content;
	private String title;

	public WindowFrame(Stage stage)
	{
		this.stage = stage;
	}

	public WindowType getType()
	{
		return type;
	}

	public Stage getStage()
	{
		return stage;
	}

	public Region getContent()
	{
		return content;
	}

	public String getTitle()
	{
		return title;
	}

	public void setType(WindowType type)
	{
		this.type = type;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setContent(Region content)
	{
		this.content = content;
	}

	public void initWinSize()
	{
		setMinWidth(content.getMinWidth());
		setMinHeight(content.getMinHeight());
		setPrefWidth(content.getPrefHeight());
		setPrefHeight(content.getPrefHeight());
	}

	public void create()
	{
		if (type.equals(WindowType.DIALOG))
		{
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(MainView.getStage());
		}
		else
		{
			stage.addEventFilter(KeyEvent.KEY_PRESSED, event ->
			{
				if (event.getCode().equals(KeyCode.F10))
				{
					
				}
			});
		}

		this.initWinSize();

		super.setContent(content);

		stage.getIcons().add(ResourceUtils.getImage("program"));
		stage.setAlwaysOnTop(true);
		stage.setResizable(false);
		stage.setScene(new WindowScene(this));
		stage.setTitle(title);
		stage.toFront();
		stage.show();
	}

	public void display()
	{
		stage.show();
	}
}