package org.beuwi.clicker.platform.gui.control;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

// Macro List View
public class MacroView extends ListView<Macro>
{
	public static final String DEFAULT_STYLE_CLASS = "macro-view";

	private final ContextMenu menu = new ContextMenu
	(
		new Menu("Remove"),
	    new Menu("Modify")
	);

	public MacroView()
	{
		setContextMenu(menu);

		getItems().addListener((ListChangeListener<Macro>) change ->
		{
			while (change.next())
			{
				for (Macro macro : change.getRemoved())
				{
                    macro.setView(null);
				}

				for (Macro macro : change.getAddedSubList())
				{
                    macro.setView(this);
				}
			}
		});

		getStyleClass().add(DEFAULT_STYLE_CLASS);
	}

	public void addMacro(Macro macro)
    {
        addItem(macro);
    }

    public Macro getMacro(int index)
    {
        return getItem(index);
    }

    public Macro getMacro(String id)
    {
        return getItem(id);
    }

    public ObservableList<Macro> getMacros()
    {
        return getItems();
    }
}