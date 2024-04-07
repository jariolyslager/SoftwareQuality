package com.nhlstenden.JabberPoint.Styles;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.nhlstenden.JabberPoint.Styles.Style.createStyles;
import static org.junit.jupiter.api.Assertions.*;

class StyleTest
{
    private static Style style;

    @BeforeAll
    static void init()
    {
        Style.createStyles();
    }

    @Test
    void getStyle_levelOf3_expectStyle3()
    {
        assertEquals(Style.getStyle(3), style = Style.getStyle(3));
    }

    @Test
    void getStyle_levelOf4_expectStyle4()
    {
        assertEquals(Style.getStyle(4), style = Style.getStyle(4));
    }

    @Test
    void getStyle_levelOf5_expectStyle4()
    {
        assertEquals(Style.getStyle(4), style = Style.getStyle(5));
    }

    @Test
    void getStyle_levelOf6_expectStyle4()
    {
        assertEquals(Style.getStyle(4), style = Style.getStyle(6));
    }
}