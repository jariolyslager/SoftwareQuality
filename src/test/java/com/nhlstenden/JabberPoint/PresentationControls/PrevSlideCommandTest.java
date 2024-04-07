package com.nhlstenden.JabberPoint.PresentationControls;

import com.nhlstenden.JabberPoint.Slides.Slide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrevSlideCommandTest
{

    @Test
    void execute_onePrev_expect1()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        presentation.append(slide1);
        presentation.setSlideNumber(1);

        new PrevSlideCommand(presentation).execute();

        assertEquals(0, presentation.getSlideNumber());
    }
}