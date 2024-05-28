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
    void setUp() {
        presentation = new Presentation();
        slide = new Slide();
        frame = new JFrame();
        slideViewerComponent = new SlideViewerComponent(presentation, frame);
    }

    @Test
    void testGetAndSetSlide_expectSameSlide() {
        slideViewerComponent.setSlide(slide);
        assertEquals(slide, slideViewerComponent.getSlide());
    }

    @Test
    void testGetAndSetLabelFont_expectSameFont() {
        Font newFont = new Font("Serif", Font.PLAIN, 12);
        slideViewerComponent.setLabelFont(newFont);
        assertEquals(newFont, slideViewerComponent.getLabelFont());
    }

    @Test
    void testGetAndSetPresentation_expectSamePresentation() {
        slideViewerComponent.setPresentation(presentation);
        assertEquals(presentation, slideViewerComponent.getPresentation());
    }

    @Test
    void testGetAndSetFrame_expectSameFrame() {
        JFrame newFrame = new JFrame();
        slideViewerComponent.setFrame(newFrame);
        assertEquals(newFrame, slideViewerComponent.getFrame());
    }

    @Test
    void testUpdateWithSlide_expectUpdatedSlideAndTitle() {
        presentation.setTitle("Test Presentation");
        presentation.append(slide);
        slideViewerComponent.update(presentation, slide);
        assertEquals(presentation, slideViewerComponent.getPresentation());
        assertEquals(slide, slideViewerComponent.getSlide());
        assertEquals("Test Presentation", frame.getTitle());
    }
}