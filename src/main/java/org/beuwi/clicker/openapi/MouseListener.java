package org.beuwi.clicker.openapi;

import javafx.scene.input.MouseEvent;

import java.util.EventListener;

public interface MouseListener extends EventListener
{
    public void dragged(MouseEvent e);

    public void moved(MouseEvent e);
}
