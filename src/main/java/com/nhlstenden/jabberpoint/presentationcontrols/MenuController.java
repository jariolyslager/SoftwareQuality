package com.nhlstenden.jabberpoint.presentationcontrols;

import com.nhlstenden.jabberpoint.aboutbox.AboutBox;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/** <p>De controller voor het menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar
{
	
	private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
	private Presentation presentation; // Er worden commando's gegeven aan de presentatie
	
	@Serial
	private static final long serialVersionUID = 227L;
	
	protected static final String ABOUT = "About";
	protected static final String FILE = "File";
	protected static final String EXIT = "Exit";
	protected static final String GOTO = "Go to";
	protected static final String HELP = "Help";
	protected static final String NEW = "New";
	protected static final String NEXT = "Next";
	protected static final String OPEN = "Open";
	protected static final String PAGENR = "Page number?";
	protected static final String PREV = "Prev";
	protected static final String SAVE = "Save";
	protected static final String VIEW = "View";
	
	protected static final String TESTFILE = "test.xml";
	protected static final String SAVEFILE = "dump.xml";
	
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";

	public MenuController(Frame frame, Presentation presentation)
	{
		this.parent = frame;
		this.presentation = presentation;
		MenuItem menuItem;
		Menu fileMenu = new Menu(FILE);
		fileMenu.add(menuItem = this.mkMenuItem(OPEN));
		menuItem.addActionListener(actionEvent -> new OpenCommand(Presentation.getInstance(), MenuController.this.parent).execute());
		fileMenu.add(menuItem = this.mkMenuItem(NEW));
		menuItem.addActionListener(actionEvent -> new NewCommand(Presentation.getInstance(), MenuController.this.parent).execute());
		fileMenu.add(menuItem = this.mkMenuItem(SAVE));
		menuItem.addActionListener(actionEvent -> new SaveCommand(Presentation.getInstance(), MenuController.this.parent).execute());
		fileMenu.addSeparator();
		fileMenu.add(menuItem = this.mkMenuItem(EXIT));
		menuItem.addActionListener(actionEvent -> new QuitCommand(Presentation.getInstance()).execute());
		add(fileMenu);
		Menu viewMenu = new Menu(VIEW);
		viewMenu.add(menuItem = this.mkMenuItem(NEXT));
		menuItem.addActionListener(actionEvent -> new NextSlideCommand(Presentation.getInstance()).execute());
		viewMenu.add(menuItem = this.mkMenuItem(PREV));
		menuItem.addActionListener(actionEvent -> new PrevSlideCommand(Presentation.getInstance()).execute());
		viewMenu.add(menuItem = this.mkMenuItem(GOTO));
		menuItem.addActionListener(actionEvent ->
		{
            String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
            int pageNumber = Integer.parseInt(pageNumberStr);
            MenuController.this.presentation.setSlideNumber(pageNumber - 1);
        });
		add(viewMenu);
		Menu helpMenu = new Menu(HELP);
		helpMenu.add(menuItem = this.mkMenuItem(ABOUT));
		menuItem.addActionListener(actionEvent -> AboutBox.show(MenuController.this.parent));
		setHelpMenu(helpMenu); // Nodig for portability (Motif, etc.).
	}

	public Frame getParent()
	{
		return this.parent;
	}

	public void setParent(Frame parent)
	{
		this.parent = parent;
	}

	public Presentation getPresentation()
	{
		return this.presentation;
	}

	public void setPresentation(Presentation presentation)
	{
		this.presentation = presentation;
	}

	// Een menu-item aanmaken
	public MenuItem mkMenuItem(String name)
	{
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
