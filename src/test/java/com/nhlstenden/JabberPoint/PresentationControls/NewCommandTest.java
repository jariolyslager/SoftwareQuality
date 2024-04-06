package com.nhlstenden.JabberPoint.PresentationControls;

import com.nhlstenden.JabberPoint.Slides.Slide;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class NewCommandTest
{

    @Test
    void execute_expectEmptyPresentation()
    {
        Presentation presentation = new Presentation();
        JFrame component = new JFrame();
        Slide slide1 = new Slide();
        presentation.append(slide1);

        new NewCommand(presentation, component).execute();

        assertEquals(0, presentation.getSize());
    }
}