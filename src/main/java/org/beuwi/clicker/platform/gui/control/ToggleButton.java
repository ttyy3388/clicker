package org.beuwi.clicker.platform.gui.control;

import javafx.beans.property.ReadOnlyBooleanProperty;

public class ToggleButton extends javafx.scene.control.ToggleButton
{
    public ReadOnlyBooleanProperty getSelectedProperty()
    {
        return selectedProperty();
    }
}
