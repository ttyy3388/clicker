package org.beuwi.clicker.platform.gui.control;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;

import java.awt.Point;

public class Macro extends Label
{
    public static final String DEFAULT_STYLE_CLASS = "macro";
    public static final Insets DEFAULT_PADDING_INSETS = new Insets(5);
    public static final int DEFAULT_PREF_HEIGHT = 25;

    // Mouse Location Value [ X , Y ]
	private final ObjectProperty<Point> point = new SimpleObjectProperty(null);

    private MacroView parent;

    public Macro(String name, String x, String y)
    {
        this(name, Integer.parseInt(x.replace(".0", "")), Integer.parseInt(y.replace(".0", "")));
    }

	public Macro(String name, int x, int y)
    {
        setText(name);
        setValue(new Point(x, y));
        setPadding(DEFAULT_PADDING_INSETS);
        setPrefHeight(DEFAULT_PREF_HEIGHT);
        getStyleClass().add(DEFAULT_STYLE_CLASS);
    }

    public String getName()
    {
        return getText();
    }

	public MacroView getView()
    {
        return parent;
    }

    public Point getValue()
    {
        return point.get();
    }

    public double getValueX()
    {
        return getValue().getX();
    }

    public double getValueY()
    {
        return getValue().getY();
    }

	public void setName(String name)
    {
        this.setText(name);
    }

	public void setValue(Point point)
	{
		this.point.set(point);
	}

	public void setView(MacroView parent)
    {
        this.parent = parent;
    }

    public ObjectProperty<Point> getValueProperty()
    {
        return point;
    }
}