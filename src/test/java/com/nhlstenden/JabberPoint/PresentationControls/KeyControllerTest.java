package com.nhlstenden.JabberPoint.PresentationControls;

import com.nhlstenden.JabberPoint.Slides.Slide;
import com.nhlstenden.JabberPoint.Slideviewers.SlideViewerComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.HeadlessException;

import static org.junit.jupiter.api.Assertions.*;

class KeyControllerTest
{
    private static Presentation presentation;
    private static JFrame frame;

    @BeforeAll
    static void init()
    {
        presentation = new Presentation();
        try
        {
            frame = new JFrame();
        }
        catch (HeadlessException exception)
        {
            System.err.println(exception.toString());
        }

        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, frame);
        presentation.setShowView(slideViewerComponent);
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        Slide slide3 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.append(slide3);
    }

    @Test
    void keyPressed_pageDown_expectNextSlide()
    {
        presentation.setSlideNumber(1);

        KeyController keyController = new KeyController(presentation);
        KeyEvent keyEvent = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN);

        keyController.keyPressed(keyEvent);

        assertEquals(2, presentation.getSlideNumber());
    }

    @Test
    void keyPressed_down_expectNextSlide()
    {
        Presentation presentation = new Presentation();
        JFrame frame = new JFrame();
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, frame);
        presentation.setShowView(slideViewerComponent);
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        Slide slide3 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.append(slide3);

        presentation.setSlideNumber(1);

        KeyController keyController = new KeyController(presentation);
        KeyEvent keyEvent = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN);

        keyController.keyPressed(keyEvent);

        assertEquals(2, presentation.getSlideNumber());
    }

    @Test
    void keyPressed_enter_expectNextSlide()
    {
        Presentation presentation = new Presentation();
        JFrame frame = new JFrame();
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, frame);
        presentation.setShowView(slideViewerComponent);
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        Slide slide3 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.append(slide3);

        presentation.setSlideNumber(1);

        KeyController keyController = new KeyController(presentation);
        KeyEvent keyEvent = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER);

        keyController.keyPressed(keyEvent);

        assertEquals(2, presentation.getSlideNumber());
    }

    @Test
    void keyPressed_pageUp_expectPrevSlide()
    {
        Presentation presentation = new Presentation();
        JFrame frame = new JFrame();
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, frame);
        presentation.setShowView(slideViewerComponent);
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        Slide slide3 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.append(slide3);

        presentation.setSlideNumber(2);

        KeyController keyController = new KeyController(presentation);
        KeyEvent keyEvent = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_UP);

        keyController.keyPressed(keyEvent);

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void keyPressed_up_expectPrevSlide()
    {
        Presentation presentation = new Presentation();
        JFrame frame = new JFrame();
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, frame);
        presentation.setShowView(slideViewerComponent);
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        Slide slide3 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.append(slide3);

        presentation.setSlideNumber(2);

        KeyController keyController = new KeyController(presentation);
        KeyEvent keyEvent = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP);

        keyController.keyPressed(keyEvent);

        assertEquals(1, presentation.getSlideNumber());
    }

}