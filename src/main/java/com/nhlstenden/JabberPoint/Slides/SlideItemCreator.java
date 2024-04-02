package com.nhlstenden.JabberPoint.Slides;

import com.nhlstenden.JabberPoint.Accessors.DemoPresentation;
import com.nhlstenden.JabberPoint.Accessors.XMLAccessor;

public class SlideItemCreator
{
    public SlideItemCreator()
    {
    }

    public SlideItem createSlideItem(SlideItemType type)
    {
        switch(type)
        {
            case BITMAP:
                return new BitmapItem();
            case TEXT:
                return new TextItem();
            default:
                return null;
        }
    }
}
