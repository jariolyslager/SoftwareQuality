package com.nhlstenden.jabberpoint.slides;

public class SlideItemCreator
{
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
