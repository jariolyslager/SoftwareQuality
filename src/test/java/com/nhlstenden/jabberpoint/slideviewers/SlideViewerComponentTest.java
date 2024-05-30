package com.nhlstenden.jabberpoint.slideviewers;

import com.nhlstenden.jabberpoint.presentationcontrols.Presentation;
import com.nhlstenden.jabberpoint.slides.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SlideViewerComponentTest
{
    private Presentation presentation;
    private Slide slide;
    private JFrame frame;
    private SlideViewerComponent slideViewerComponent;

    @BeforeEach
    void setUp()
    {
        presentation = new Presentation();
        slide = new Slide();
        frame = new JFrame();
        slideViewerComponent = new SlideViewerComponent(presentation, frame);
    }

    @Test
    void testGetAndSetSlide_expectSameSlide()
    {
        this.slideViewerComponent.setSlide(slide);
        assertEquals(slide, slideViewerComponent.getSlide());
    }

    @Test
    void testGetAndSetLabelFont_expectSameFont()
    {
        Font newFont = new Font("Serif", Font.PLAIN, 12);
        this.slideViewerComponent.setLabelFont(newFont);
        assertEquals(newFont, this.slideViewerComponent.getLabelFont());
    }

    @Test
    void testGetAndSetPresentation_expectSamePresentation()
    {
        this.slideViewerComponent.setPresentation(presentation);
        assertEquals(presentation, this.slideViewerComponent.getPresentation());
    }

    @Test
    void testGetAndSetFrame_expectSameFrame()
    {
        JFrame newFrame = new JFrame();
        this.slideViewerComponent.setFrame(newFrame);
        assertEquals(newFrame, this.slideViewerComponent.getFrame());
    }

    @Test
    void testUpdateWithSlide_expectUpdatedSlideAndTitle()
    {
        this.presentation.setTitle("Test Presentation");
        this.presentation.append(slide);
        this.slideViewerComponent.update(this.presentation, slide);
        assertEquals(this.presentation, this.slideViewerComponent.getPresentation());
        assertEquals(this.slide, this.slideViewerComponent.getSlide());
        assertEquals("Test Presentation", this.frame.getTitle());
    }
}