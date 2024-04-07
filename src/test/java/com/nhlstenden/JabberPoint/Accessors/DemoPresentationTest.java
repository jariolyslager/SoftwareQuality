package com.nhlstenden.JabberPoint.Accessors;

import com.nhlstenden.JabberPoint.PresentationControls.Presentation;
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