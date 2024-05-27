package com.nhlstenden.jabberpoint.slides;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BitmapItemTest
{
    @Test
    void createBitmapItem_invalidFile_ExpectError()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            new BitmapItem(0, "niks");
        });
    }

    @Test
    void createBitmapItem_validFile_ExpectNoError()
    {
        assertDoesNotThrow(() -> new BitmapItem(0, "JabberPoint.gif"));
    }

    @Test
    void createBitmapItem_noParms_expectEmptyBitmapItem()
    {
        BitmapItem item = new BitmapItem();

        assertEquals("", item.getName());
        assertEquals(0, item.getLevel());
    }

    @Test
    void ToString_emptyBitmapItem_ExpectStringNoNameLevel0()
    {
        BitmapItem item = new BitmapItem();

        String string = item.toString();

        assertEquals("BitmapItem[" + "0" + "," + "" + "]", string);
    }

    @Test
    void ToString_BitmapItem_ExpectCorrectString()
    {
        BitmapItem item = new BitmapItem(1, "JabberPoint.gif");

        String string = item.toString();

        assertEquals("BitmapItem[" + "1" + "," + "JabberPoint.gif" + "]", string);
    }
}