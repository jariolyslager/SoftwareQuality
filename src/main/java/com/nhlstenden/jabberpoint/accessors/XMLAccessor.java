package com.nhlstenden.jabberpoint.accessors;

import java.io.*;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.nhlstenden.jabberpoint.presentationcontrols.Presentation;
import com.nhlstenden.jabberpoint.slides.BitmapItem;
import com.nhlstenden.jabberpoint.slides.Slide;
import com.nhlstenden.jabberpoint.slides.SlideItem;
import com.nhlstenden.jabberpoint.slides.TextItem;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


/** XMLAccessor, reads and writes XML files
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class XMLAccessor extends Accessor implements SaveAccessor
{
    /** Default API to use. */
    protected static final String DEFAULT_API_TO_USE = "dom";
    
    /** namen van xml tags of attributen */
    protected static final String SHOWTITLE = "showtitle";
    protected static final String SLIDETITLE = "title";
    protected static final String SLIDE = "slide";
    protected static final String ITEM = "item";
    
    /** tekst van messages */
    protected static final String PCE = "Parser Configuration Exception";
    protected static final String UNKNOWNTYPE = "Unknown Element type";
    protected static final String NFE = "Number Format Exception";
    
    private String getTitle(Element element, String tagName)
	{
    	NodeList titles = element.getElementsByTagName(tagName);

    	return titles.item(0).getTextContent();
    }

	@Override
	public void loadFile(Presentation presentation, String fileName) throws IOException
	{
		int slideNumber;
		int itemNumber;
		int max;
		int maxItems;
		try
		{
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

			if (inputStream == null)
			{
				throw new FileNotFoundException("File not found in resources: " + fileName);
			}

			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(inputStream);
			Element doc = document.getDocumentElement();
			presentation.setTitle(this.getTitle(doc, SHOWTITLE));

			NodeList slides = doc.getElementsByTagName(SLIDE);
			max = slides.getLength();

			SlideItemLoader slideItemLoader = new SlideItemLoader();

			for (slideNumber = 0; slideNumber < max; slideNumber++)
			{
				Element xmlSlide = (Element) slides.item(slideNumber);
				Slide slide = new Slide();
				slide.setTitle(this.getTitle(xmlSlide, SLIDETITLE));
				presentation.append(slide);
				
				NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
				maxItems = slideItems.getLength();

				for (itemNumber = 0; itemNumber < maxItems; itemNumber++)
				{
					Element item = (Element) slideItems.item(itemNumber);
					slideItemLoader.loadSlideItem(slide, item);
				}
			}
		} 
		catch (IOException | SAXException iox)
		{
			System.err.println(iox.getMessage());
		}
		catch (ParserConfigurationException pcx)
		{
			System.err.println(PCE);
		}	
	}

	@Override
	public void saveFile(Presentation presentation, String fileName) throws IOException
	{
		PrintWriter out = new PrintWriter(new FileWriter(fileName));
		out.println("<?xml version=\"1.0\"?>");
		out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
		out.println("<presentation>");
		out.print("<showtitle>");
		out.print(presentation.getTitle());
		out.println("</showtitle>");

		for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++)
		{
			Slide slide = presentation.getSlide(slideNumber);
			out.println("<slide>");
			out.println("<title>" + slide.getTitle() + "</title>");
			Vector<SlideItem> slideItems = slide.getSlideItems();

			for (int itemNumber = 0; itemNumber < slideItems.size(); itemNumber++)
			{
				SlideItem slideItem = slideItems.elementAt(itemNumber);
				out.print("<item kind=");

				if (slideItem instanceof TextItem)
				{
					out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
					out.print(((TextItem) slideItem).getText());
				}
				else
				{
					if (slideItem instanceof BitmapItem)
					{
						out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
						out.print(((BitmapItem) slideItem).getName());
					}
					else
					{
						System.out.println("Ignoring " + slideItem);
					}
				}

				out.println("</item>");
			}

			out.println("</slide>");
		}

		out.println("</presentation>");
		out.close();
	}
}
