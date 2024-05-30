package com.nhlstenden.jabberpoint.slides;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlideTest
{

    @Test
    void appendTextItem_addingToVectorOf3_expectSizeOf4()
    {
        Slide slide = new Slide();
        SlideItem slideItem1 = new TextItem(1, "text");
        SlideItem slideItem2 = new TextItem(1, "text");
        SlideItem slideItem3 = new TextItem(1, "text");

        slide.append(slideItem1);
        slide.append(slideItem2);
        slide.append(slideItem3);

        slide.appendTextItem(1, "finalTextItem");

        assertEquals(4, slide.getSlideItems().size());
    }
}