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

}