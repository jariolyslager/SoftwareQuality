package com.nhlstenden.JabberPoint.Slides;

import com.nhlstenden.JabberPoint.Styles.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/** <p>Een tekst item.</p>
 * <p>Een TextItem heeft tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class TextItem extends SlideItem
{
	private String text;
	
	private static final String EMPTYTEXT = "No Text Given";

	// Een textitem van level level, met als tekst string
	public TextItem(int level, String string)
	{
		super(level);
		this.text = string;
	}

	// Een leeg textitem
	public TextItem()
	{
		this(0, EMPTYTEXT);
	}

	// Geef de tekst
	public String getText()
	{
		return this.text == null ? "" : this.text;
	}

	// Geef de AttributedString voor het item
	public AttributedString getAttributedString(Style style, float scale)
	{
		AttributedString attrStr = new AttributedString(getText());
		attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, this.text.length());

		return attrStr;
	}

	// Geef de bounding box van het item
	public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer,	float scale, Style myStyle)
	{
		List<TextLayout> layouts = getLayouts(graphics, myStyle, scale);
		int xsize = 0, ysize = (int) (myStyle.getLeading() * scale);
		Iterator<TextLayout> iterator = layouts.iterator();
		while (iterator.hasNext())
		{
			TextLayout layout = iterator.next();
			Rectangle2D bounds = layout.getBounds();
			if (bounds.getWidth() > xsize)
			{
				xsize = (int) bounds.getWidth();
			}
			if (bounds.getHeight() > 0)
			{
				ysize += bounds.getHeight();
			}
			ysize += layout.getLeading() + layout.getDescent();
		}

		return new Rectangle((int) (myStyle.getIndent()*scale), 0, xsize, ysize);
	}

	// Teken het item
	public void draw(int x, int y, float scale, Graphics graphics, Style myStyle, ImageObserver observer)
	{
		if (this.text == null || this.text.length() == 0)
		{
			return;
		}

		List<TextLayout> layouts = getLayouts(graphics, myStyle, scale);
		Point pen = new Point(x + (int) (myStyle.getIndent() * scale), y + (int) (myStyle.getLeading() * scale));
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setColor(myStyle.getColor());
		Iterator<TextLayout> iterator = layouts.iterator();
		while (iterator.hasNext())
		{
			TextLayout layout = iterator.next();
			pen.y += layout.getAscent();
			layout.draw(graphics2D, pen.x, pen.y);
			pen.y += layout.getDescent();
		}
	  }

	private List<TextLayout> getLayouts(Graphics graphics, Style style, float scale)
	{
		List<TextLayout> layouts = new ArrayList<TextLayout>();
		AttributedString attributedString = getAttributedString(style, scale);
    	Graphics2D graphics2D = (Graphics2D) graphics;
    	FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
    	LineBreakMeasurer measurer = new LineBreakMeasurer(attributedString.getIterator(), fontRenderContext);
    	float wrappingWidth = (Slide.WIDTH - style.getIndent()) * scale;
    	while (measurer.getPosition() < getText().length())
		{
    		TextLayout layout = measurer.nextLayout(wrappingWidth);
    		layouts.add(layout);
    	}

    	return layouts;
	}

	public String toString()
	{
		return "TextItem[" + getLevel() + ", " + getText() + "]";
	}
}
