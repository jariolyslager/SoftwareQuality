package com.nhlstenden.jabberpoint.presentationcontrols;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/** <p>This is the KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter
{
	private Presentation presentation; // Er worden commando's gegeven aan de presentatie

	public KeyController(Presentation presentation)
	{
		this.presentation = presentation;
	}

	public Presentation getPresentation()
	{
		return this.presentation;
	}

	public void setPresentation(Presentation presentation)
	{
		this.presentation = presentation;
	}

	public void keyPressed(KeyEvent keyEvent)
	{
		switch (keyEvent.getKeyCode())
		{
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				new NextSlideCommand(this.presentation).execute();
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
				new PrevSlideCommand(this.presentation).execute();
				break;
			case 'q':
			case 'Q':
				new QuitCommand(this.presentation).execute();
			default:
				break;
		}
	}
}
