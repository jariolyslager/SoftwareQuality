package com.nhlstenden.JabberPoint.Accessors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.nhlstenden.JabberPoint.Accessors.AccessorEnum.DEMO;
import static com.nhlstenden.JabberPoint.Accessors.AccessorEnum.XML;
import static org.junit.jupiter.api.Assertions.*;

class AccessorCreatorTest
{
    private static AccessorCreator accessorCreator;

    @BeforeAll
    static void init()
    {
        accessorCreator = new AccessorCreator();
    }

    @Test
    void createAccessor_XML_ExpectXML()
    {
        Accessor accessor = accessorCreator.createAccessor(XML);

        assertInstanceOf(XMLAccessor.class, accessor);
    }

    @Test
    void createAccessor_Demo_ExpectDemo()
    {
        Accessor accessor = accessorCreator.createAccessor(DEMO);

        assertInstanceOf(DemoPresentation.class, accessor);
    }

    @Test
    void createAccessor_noArgument_ExpectDemo()
    {
        Accessor accessor = accessorCreator.createAccessor(DEMO);

        assertInstanceOf(DemoPresentation.class, accessor);
    }
}