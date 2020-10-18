package org.beuwi.clicker.openapi;

import java.awt.MouseInfo;
import java.awt.Point;

public class MouseManager
{
    public static Point getLocation()
    {
        return MouseInfo.getPointerInfo().getLocation();
    }

    public static double getX()
    {
        return MouseInfo.getPointerInfo().getLocation().getX();
    }

    public static double getY()
    {
        return MouseInfo.getPointerInfo().getLocation().getY();
    }
}
