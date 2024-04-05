package com.nhlstenden.JabberPoint.Slides;

import com.nhlstenden.JabberPoint.Styles.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;

import java.io.IOException;


/** <p>De klasse voor een Bitmap item</p>
 * <p>Bitmap items hebben de verantwoordelijkheid om zichzelf te tekenen.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class BitmapItem extends SlideItem
{
  	private BufferedImage bufferedImage;
  	private String imageName;
  
  	protected static final String FILE = "Bestand ";
  	protected static final String NOTFOUND = " niet gevonden";

	// level staat voor het item-level; name voor de naam van het bestand met de afbeelding
	public BitmapItem(int level, String name)
	{
		super(level);
		this.imageName = name;

		try
		{
			this.bufferedImage = ImageIO.read(getClass().getResourceAsStream("/" + this.imageName));
		}
		catch (IOException e)
		{
			System.err.println(FILE + this.imageName + NOTFOUND);
		}
	}

	// Een leeg bitmap-item
	public BitmapItem()
	{
		this(0, "");
	}

	// Geef de bestandsnaam van de afbeelding
	public String getName()
	{
		return this.imageName;
	}

	// Geef de bounding box van de afbeelding
	public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style myStyle)
	{
		return new Rectangle((int) (myStyle.getIndent() * scale), 0, (int) (this.bufferedImage.getWidth(observer) * scale), ((int) (myStyle.getLeading() * scale)) + (int) (this.bufferedImage.getHeight(observer) * scale));
	}

	// Teken de afbeelding
	public void draw(int x, int y, float scale, Graphics graphics, Style myStyle, ImageObserver observer)
	{
		int width = x + (int) (myStyle.getIndent() * scale);
		int height = y + (int) (myStyle.getLeading() * scale);
		graphics.drawImage(this.bufferedImage, width, height, (int) (this.bufferedImage.getWidth(observer) * scale), (int) (this.bufferedImage.getHeight(observer) * scale), observer);
	}

	public String toString()
	{
		return "BitmapItem[" + getLevel() + "," + this.imageName + "]";
	}
}
