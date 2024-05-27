package com.nhlstenden.jabberpoint.presentationcontrols;

import com.nhlstenden.jabberpoint.slides.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class KeyControllerTest
{
    private KeyController keyController;
    private Presentation presentation;
    private JPanel testComponent;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        // Adding slides to the presentation
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.append(new Slide());
        keyController = new KeyController(presentation);
        testComponent = new JPanel();
    }

    @Test
    void testKeyPressed_PageDown_expectNextSlide() {
        presentation.setSlideNumber(0);
        KeyEvent keyEvent = new KeyEvent(testComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, KeyEvent.CHAR_UNDEFINED);
        keyController.keyPressed(keyEvent);
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void testKeyPressed_Down_ExpectNextSlide() {
        presentation.setSlideNumber(0);
        KeyEvent keyEvent = new KeyEvent(testComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);
        keyController.keyPressed(keyEvent);
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void testKeyPressed_Enter_ExpectNextSlide() {
        presentation.setSlideNumber(0);
        KeyEvent keyEvent = new KeyEvent(testComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
        keyController.keyPressed(keyEvent);
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void testKeyPressed_PageUp_ExpectPreviousSlide() {
        presentation.setSlideNumber(1);
        KeyEvent keyEvent = new KeyEvent(testComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_UP, KeyEvent.CHAR_UNDEFINED);
        keyController.keyPressed(keyEvent);
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void testKeyPressed_Up_ExpectPreviousSlide() {
        presentation.setSlideNumber(1);
        KeyEvent keyEvent = new KeyEvent(testComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        keyController.keyPressed(keyEvent);
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void testKeyPressed_Minus_ExpectPreviousSlide() {
        presentation.setSlideNumber(1);
        KeyEvent keyEvent = new KeyEvent(testComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_MINUS, '-');
        keyController.keyPressed(keyEvent);
        assertEquals(0, presentation.getSlideNumber());
    }
}