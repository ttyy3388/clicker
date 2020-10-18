package org.beuwi.clicker;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.beuwi.clicker.platform.app.action.CreateMacroAction;
import org.beuwi.clicker.platform.app.action.DeleteMacroAction;
import org.beuwi.clicker.platform.app.view.MainView.MainWindow;
import org.beuwi.clicker.platform.app.view.actions.StartMacroClickAction;
import org.beuwi.clicker.platform.app.view.actions.RunMacroTimerAction;
import org.beuwi.clicker.platform.app.view.parts.RegistAreaPart;
import org.beuwi.clicker.platform.app.view.parts.UpperAreaPart;
import org.beuwi.clicker.platform.util.ResourceUtils;

public class Launcher extends Application
{
    @Override
    public void start(Stage stage)
    {
        try
        {
            // Text Anti Aliasing
			/* System.setProperty("prism.text", "t2k");
			System.setProperty("prism.lcdtext", "false");
			System.setProperty("prism.subpixeltext", "false"); */

            // Load Fonts
            Font.loadFont(ResourceUtils.getFont("consola"),       0); // Family : "Consolas"
            Font.loadFont(ResourceUtils.getFont("consola-bold"),  0); // Family : "Consolas Bold"
            Font.loadFont(ResourceUtils.getFont("d2coding"),      0); // Family : "D2Coding"
            Font.loadFont(ResourceUtils.getFont("d2coding-bold"), 0); // Family : "D2Coding"
            Font.loadFont(ResourceUtils.getFont("roboto"), 	    0); // Family : "Roboto"
            Font.loadFont(ResourceUtils.getFont("roboto-bold"),   0); // Family : "Roboto Bold"
            Font.loadFont(ResourceUtils.getFont("roboto-medium"), 0); // Family : "Roboto Medium"

            // Set Basic Theme
            Application.setUserAgentStylesheet(ResourceUtils.getTheme("base"));

            new UpperAreaPart().init();
            new RegistAreaPart().init();

            new CreateMacroAction().init();
            new DeleteMacroAction().init();

            new StartMacroClickAction().init();
            new RunMacroTimerAction().init();

            new MainWindow(stage).create();
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void stop()
    {

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}