package org.beuwi.clicker.platform.gui.control;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public class StackPane extends javafx.scene.layout.StackPane
{
    private ObservableList<Node> getItems()
    {
        return getChildren();
    }

    public void setContent(Node content)
	{
		getItems().add(content);
	}

	public Node getContent()
    {
        return getItems().get(0);
    }
}
