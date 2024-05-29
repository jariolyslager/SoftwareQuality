package com.nhlstenden.jabberpoint.presentationcontrols;

import com.nhlstenden.jabberpoint.slides.Slide;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.*;

class NewCommandTest {

    @Test
    void execute_clearPresentation_expectNoSlides()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        presentation.append(slide1);
        presentation.setSlideNumber(1);

        new NewCommand(presentation, new JPanel()).execute();

        assertEquals(0, presentation.getSize());
    }
}