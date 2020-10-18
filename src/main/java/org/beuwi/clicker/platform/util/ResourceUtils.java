package org.beuwi.clicker.platform.util;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.net.URL;

public class ResourceUtils
{
    public static InputStream getFont(String name)
    {
        return ResourceUtils.class.getResourceAsStream("/fonts/" + name + ".ttf");
    }

    public static Image getImage(String name)
    {
        return new Image(ResourceUtils.class.getResource("/images/" + name + ".png").toExternalForm());
    }

    public static URL getForm(String name)
    {
        return ResourceUtils.class.getResource("/forms/" + name + ".fxml");
    }

    public static String getStyle(String name)
    {
        return ResourceUtils.class.getResource("/styles/" + name + ".css").toExternalForm();
    }

    public static String getTheme(String name)
    {
        return ResourceUtils.class.getResource("/themes/" + name + ".css").toExternalForm();
    }
}