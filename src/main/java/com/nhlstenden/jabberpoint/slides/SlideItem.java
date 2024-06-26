package com.nhlstenden.jabberpoint.slides;

import com.nhlstenden.jabberpoint.styles.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

/** <p>De abstracte klasse voor een item op een Slide<p>
 * <p>Alle SlideItems hebben tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public abstract class SlideItem
{
	// Het level van het SlideItem
	private int level;

	public SlideItem(int level)
	{
		this.level = level;
	}

	// Geef het level
	public int getLevel()
	{
		return this.level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	// Geef de bounding box
	public abstract Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style style);

	// Teken het item
	public abstract void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer);
}
