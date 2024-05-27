package com.nhlstenden.jabberpoint.slides;

import com.nhlstenden.jabberpoint.styles.Style;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/** <p>Een slide. Deze klasse heeft tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide
{
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	// De titel wordt apart bewaard
	private String title;
	// De slide-items worden in een Vector bewaard
	private Vector<SlideItem> items;

	public Slide()
	{
		this.items = new Vector<>();
	}

	// Voeg een SlideItem toe
	public void append(SlideItem anItem)
	{
		this.items.addElement(anItem);
	}

	// Geef de titel van de slide
	public String getTitle()
	{
		return this.title;
	}

	// Verander de titel van de slide
	public void setTitle(String newTitle)
	{
		this.title = newTitle;
	}

	public Vector<SlideItem> getItems()
	{
		return this.items;
	}

	public void setItems(Vector<SlideItem> items)
	{
		this.items = items;
	}

	// Maak een TextItem van String, en voeg het TextItem toe
	public void appendTextItem(int level, String message)
	{
		this.append(new TextItem(level, message));
	}

	// Geef het betreffende SlideItem
	public SlideItem getSlideItem(int number)
	{
		return this.items.elementAt(number);
	}

	// Geef alle SlideItems in een Vector
	public Vector<SlideItem> getSlideItems()
	{
		return this.items;
	}

	// Geef de afmeting van de Slide
	public int getSize()
	{
		return this.items.size();
	}

	// Teken de slide
	public void draw(Graphics graphics, Rectangle area, ImageObserver view)
	{
		float scale = this.getScale(area);
	    int y = area.y;
		// De titel wordt apart behandeld
		SlideItem slideItem = new TextItem(0, this.getTitle());
		Style style = Style.getStyle(slideItem.getLevel());
		slideItem.draw(area.x, y, scale, graphics, style, view);
		y += slideItem.getBoundingBox(graphics, view, scale, style).height;
		for (int number = 0; number < this.getSize(); number++)
		{
	    	slideItem = this.getSlideItems().elementAt(number);
			style = Style.getStyle(slideItem.getLevel());
			slideItem.draw(area.x, y, scale, graphics, style, view);
			y += slideItem.getBoundingBox(graphics, view, scale, style).height;
	    }
	}

	// Geef de schaal om de slide te kunnen tekenen
	private float getScale(Rectangle area)
	{
		return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
	}
}
