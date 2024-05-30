package com.nhlstenden.jabberpoint.accessors;

import com.nhlstenden.jabberpoint.presentationcontrols.Presentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoPresentationTest
{

    @Test
    void loadFile_expect3DemoSlides()
    {
        Presentation presentation = Presentation.getInstance();

        DemoPresentation demoPresentation = new DemoPresentation();

        demoPresentation.loadFile(presentation, "demo");

        assertEquals(3, presentation.getSize());
    }
}