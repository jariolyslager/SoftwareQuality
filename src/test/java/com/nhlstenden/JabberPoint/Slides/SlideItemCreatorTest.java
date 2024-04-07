package com.nhlstenden.JabberPoint.Slides;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.nhlstenden.JabberPoint.Slides.SlideItemType.*;
import static org.junit.jupiter.api.Assertions.*;

class SlideItemCreatorTest
{
    private static SlideItemCreator slideItemCreator;

    @BeforeAll
    static void init()
    {
        slideItemCreator = new SlideItemCreator();
    }

    @Test
    void createSlideItem_BITMAPType_ExpectBitmapItem()
    {
        SlideItem slideItem = slideItemCreator.createSlideItem(BITMAP);

        assertInstanceOf(BitmapItem.class, slideItem);
    }

    @Test
    void createSlideItem_TEXTType_ExpectTextItem()
    {
        SlideItem slideItem = slideItemCreator.createSlideItem(TEXT);

        assertInstanceOf(TextItem.class, slideItem);
    }
}