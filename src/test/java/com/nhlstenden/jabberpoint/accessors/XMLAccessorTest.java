package com.nhlstenden.jabberpoint.accessors;

import com.nhlstenden.jabberpoint.presentationcontrols.Presentation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class XMLAccessorTest
{
    private static ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static PrintStream originalErr = System.err;

    @BeforeAll
    static void init()
    {
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    static void restore()
    {
        System.setErr(originalErr);
    }

    @Test
    void loadFile_existingFile_expectSuccess() throws Exception
    {
        XMLAccessor xmlAccessor = new XMLAccessor();
        Presentation presentation = new Presentation();

        xmlAccessor.loadFile(presentation, "test.xml");

        assertEquals("XML-Based Presentation for Jabberpoint", presentation.getTitle());
        assertEquals(5, presentation.getSize());
        assertEquals("JabberPoint XML-Demo", presentation.getShowList().get(0).getTitle());
        assertEquals(9, presentation.getShowList().get(0).getItems().size());
        assertEquals("TextItem[1, Welkom bij Jabberpoint]", presentation.getShowList().get(0).getItems().get(0).toString());
    }

    @Test
    void loadFile_nonExistingFile_expectException() throws IOException
    {
        XMLAccessor xmlAccessor = new XMLAccessor();
        Presentation presentation = new Presentation();
        xmlAccessor.loadFile(presentation, "file.xml");


        assertTrue(errContent.toString().contains("File not found in resources"));
    }

    @Test
    void saveFile_valid_expectSuccess() throws Exception
    {
        XMLAccessor xmlAccessor = new XMLAccessor();
        Presentation presentation = new Presentation();

        xmlAccessor.saveFile(presentation, "newFile.xml");
        assertEquals(null, presentation.getTitle());
        assertEquals(0, presentation.getSize());
    }

    @Test
    void saveFile_invalidFileName_expectException() throws IOException
    {
        XMLAccessor xmlAccessor = new XMLAccessor();
        Presentation presentation = new Presentation();

        assertThrows(IOException.class, () ->
        {
            xmlAccessor.saveFile(presentation, "file___?//l");
        });
    }
}