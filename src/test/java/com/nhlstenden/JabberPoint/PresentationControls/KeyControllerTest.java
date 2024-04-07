package com.nhlstenden.JabberPoint.PresentationControls;

import com.nhlstenden.JabberPoint.Accessors.Accessor;
import com.nhlstenden.JabberPoint.Slides.Slide;
import com.nhlstenden.JabberPoint.Slideviewers.SlideViewerComponent;
import com.nhlstenden.JabberPoint.Slideviewers.SlideViewerFrame;
import com.nhlstenden.JabberPoint.Styles.Style;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class KeyControllerTest
{
    private static Presentation presentation;
    private static SlideViewerFrame slideViewerFrame;

    @BeforeAll
    static void init() throws IOException
    {
        Style.createStyles();
        presentation = Presentation.getInstance();

        slideViewerFrame = new SlideViewerFrame("TestFrame", presentation);
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, slideViewerFrame);
        presentation.setShowView(slideViewerComponent);
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        Slide slide3 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.append(slide3);

        try
        {
            Accessor.getDemoAccessor().loadFile(presentation, "");
        }
        catch (IOException iox)
        {
            System.err.println(iox.toString());
        }

    }

    @Test
    void keyPressed_pageDown_expectNextSlide()
    {
        presentation.setSlideNumber(1);

        KeyController keyController = new KeyController(presentation);
        KeyEvent keyEvent = new KeyEvent(slideViewerFrame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN);

        keyController.keyPressed(keyEvent);

        assertEquals(2, presentation.getSlideNumber());
    }

    @Test
    void keyPressed_down_expectNextSlide()
    {
        presentation.setSlideNumber(1);

        KeyController keyController = new KeyController(presentation);
        KeyEvent keyEvent = new KeyEvent(slideViewerFrame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN);

        keyController.keyPressed(keyEvent);

        assertEquals(2, presentation.getSlideNumber());
    }

    @Test
    void keyPressed_enter_expectNextSlide()
    {
        presentation.setSlideNumber(1);

        KeyController keyController = new KeyController(presentation);
        KeyEvent keyEvent = new KeyEvent(slideViewerFrame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER);

        keyController.keyPressed(keyEvent);

        assertEquals(2, presentation.getSlideNumber());
    }

    @Test
    void keyPressed_pageUp_expectPrevSlide()
    {
        presentation.setSlideNumber(2);

        KeyController keyController = new KeyController(presentation);
        KeyEvent keyEvent = new KeyEvent(slideViewerFrame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_UP);

        keyController.keyPressed(keyEvent);

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void keyPressed_up_expectPrevSlide()
    {
        presentation.setSlideNumber(2);

        KeyController keyController = new KeyController(presentation);
        KeyEvent keyEvent = new KeyEvent(slideViewerFrame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP);

        keyController.keyPressed(keyEvent);

        assertEquals(1, presentation.getSlideNumber());
    }

}