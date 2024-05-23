package com.nhlstenden.jabberpoint.presentationcontrols;

import com.nhlstenden.jabberpoint.slides.Slide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextSlideCommandTest
{

    @Test
    void execute_oneNext_expect0()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        presentation.append(slide1);

        new NextSlideCommand(presentation).execute();

        assertEquals(0, presentation.getSlideNumber());
    }
}