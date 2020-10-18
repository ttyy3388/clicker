package org.beuwi.clicker.openapi;

import javafx.application.Platform;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import javax.swing.Timer;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class MouseObserver
{
	private static final int DELAY = 10;

	private static Set<MouseListener> listeners = new HashSet<>();

	private static Timer timer = new Timer(DELAY, new ActionListener()
	{
		private Point last = MouseInfo.getPointerInfo().getLocation();

		public synchronized void actionPerformed(ActionEvent e)
		{
			Point point = MouseInfo.getPointerInfo().getLocation();

			if (!point.equals(last))
			{
				fireMouseMotionEvent(point);
			}

			last = point;
		}
	});

	public static void addMouseMotionListener(MouseListener listener)
	{
		if (!timer.isRunning())
        {
            timer.start();
        }

		synchronized (listeners)
		{
			listeners.add(listener);
		}
	}

	public static void delMouseMotionListener(MouseListener listener)
	{
		synchronized (listeners)
		{
			listeners.remove(listener);
		}
	}

	protected static void fireMouseMotionEvent(Point point)
	{
		synchronized (listeners)
		{
			for (final MouseListener listener : listeners)
			{
				final MouseEvent event = new MouseEvent(MouseEvent.MOUSE_MOVED, point.x, point.y, 0, 0, MouseButton.NONE, 0, false, false, false, false,
                        false, false, false, true, false, false, null);

                Platform.runLater(() ->
				{
					listener.moved(event);
				});
			}
		}
	}
}
