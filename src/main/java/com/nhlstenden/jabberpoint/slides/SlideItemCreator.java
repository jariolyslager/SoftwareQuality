package com.nhlstenden.jabberpoint.slides;

public class SlideItemCreator
{
    public SlideItemCreator()
    {
    }

    public SlideItem createSlideItem(SlideItemType type)
    {
        return switch (type)
        {
            case BITMAP -> new BitmapItem();
            case TEXT -> new TextItem();
            default -> null;
        };
    }
}
