package com.nhlstenden.JabberPoint.Slides;

public class SlideItemCreator
{
    public SlideItemCreator()
    {
    }

    public SlideItem createSlideItem(SlideItemType type)
    {
        switch (type)
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
