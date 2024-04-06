package com.nhlstenden.JabberPoint.Accessors;

import com.nhlstenden.JabberPoint.Slides.BitmapItem;
import com.nhlstenden.JabberPoint.Slides.Slide;
import com.nhlstenden.JabberPoint.Slides.TextItem;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public class SlideItemLoader
{
    protected static final String LEVEL = "level";
    protected static final String KIND = "kind";
    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";

    /** tekst van messages */
    protected static final String UNKNOWNTYPE = "Unknown Element type";
    protected static final String NFE = "Number Format Exception";

    public SlideItemLoader()
    {
    }

    public void loadSlideItem(Slide slide, Element item)
    {
        int level = 1; // default
        NamedNodeMap attributes = item.getAttributes();
        String leveltext = attributes.getNamedItem(LEVEL).getTextContent();

        if (leveltext != null)
        {
            try
            {
                level = Integer.parseInt(leveltext);
            }
            catch (NumberFormatException x)
            {
                System.err.println(NFE);
            }
        }

        String type = attributes.getNamedItem(KIND).getTextContent();

        if (TEXT.equals(type))
        {
            slide.append(new TextItem(level, item.getTextContent()));
        }
        else
        {
            if (IMAGE.equals(type))
            {
                slide.append(new BitmapItem(level, item.getTextContent()));
            }
            else
            {
                System.err.println(UNKNOWNTYPE);
            }
        }
    }
}
