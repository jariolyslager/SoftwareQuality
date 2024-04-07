package com.nhlstenden.JabberPoint.Slides;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextItemTest
{

    @Test
    void getText_null_expectEmptyString()
    {
        TextItem textItem = new TextItem();

        textItem.setText(null);

        assertEquals("", textItem.getText());
    }

    @Test
    void getText_stringWithText_expectText()
    {
        TextItem textItem = new TextItem();

        textItem.setText("text");

        assertEquals("text", textItem.getText());
    }

    @Test
    void testToString_expectStringWithCorrectLevelAndText()
    {
        TextItem textItem = new TextItem(1, "text");

        assertEquals("TextItem[1, text]", textItem.toString());
    }
}