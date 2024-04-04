package com.nhlstenden.JabberPoint.Accessors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.nhlstenden.JabberPoint.Accessors.AccessorEnum.DEMO;
import static com.nhlstenden.JabberPoint.Accessors.AccessorEnum.XML;
import static org.junit.jupiter.api.Assertions.*;

class AccessorCreatorTest
{
    @Test
    void createAccessor_XML_ExpectXML()
    {
        AccessorCreator accessorCreator = new AccessorCreator();
        Accessor accessor = accessorCreator.createAccessor(XML);

        assertInstanceOf(XMLAccessor.class, accessor);
    }

    @Test
    void createAccessor_Demo_ExpectDemo()
    {
        AccessorCreator accessorCreator = new AccessorCreator();
        Accessor accessor = accessorCreator.createAccessor(DEMO);

        assertInstanceOf(DemoPresentation.class, accessor);
    }

    @Test
    void createAccessor_noArgument_ExpectDemo()
    {
        AccessorCreator accessorCreator = new AccessorCreator();
        Accessor accessor = accessorCreator.createAccessor(DEMO);

        assertInstanceOf(DemoPresentation.class, accessor);
    }
}