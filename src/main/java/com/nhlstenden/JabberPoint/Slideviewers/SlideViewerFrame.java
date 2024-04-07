package com.nhlstenden.JabberPoint.Slideviewers;

import com.nhlstenden.JabberPoint.PresentationControls.KeyController;
import com.nhlstenden.JabberPoint.PresentationControls.MenuController;
import com.nhlstenden.JabberPoint.PresentationControls.Presentation;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

/**
 * <p>Het applicatiewindow voor een slideviewcomponent</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class SlideViewerFrame extends JFrame
{
	private static final long serialVersionUID = 3227L;
	
	private static final String JABTITLE = "Jabberpoint 1.6 - OU";
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	
	public SlideViewerFrame(String title, Presentation presentation)
	{
		super(title);
		SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
		presentation.setShowView(slideViewerComponent);
		this.setupWindow(slideViewerComponent, presentation);
	}

	// De GUI opzetten
	public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation)
	{
		setTitle(JABTITLE);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		getContentPane().add(slideViewerComponent);
		// Een controller toevoegen
		addKeyListener(new KeyController(presentation));
		// Nog een controller toevoegen
		setMenuBar(new MenuController(this, presentation));
		// Dezelfde maten als Slide hanteert.
		setSize(new Dimension(WIDTH, HEIGHT));
		setVisible(true);
	}
}
