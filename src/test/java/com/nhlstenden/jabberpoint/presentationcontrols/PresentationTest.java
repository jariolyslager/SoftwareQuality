package com.nhlstenden.jabberpoint.presentationcontrols;

import com.nhlstenden.jabberpoint.slides.Slide;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PresentationTest
{

    @Test
    void getSize_size0_expect0()
    {
        Presentation presentation = new Presentation();

        assertEquals(0, presentation.getSize());
    }

    @Test
    void getSize_size1_expect1()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();

        presentation.append(slide1);

        assertEquals(1, presentation.getSize());
    }

    @Test
    void nextSlide_1next_expect0()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);

        presentation.nextSlide();

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void nextSlide_2next_noMoreSlides_expect0()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        presentation.append(slide1);

        presentation.nextSlide();
        presentation.nextSlide();

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void nextSlide_2next_expect1()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);

        presentation.nextSlide();
        presentation.nextSlide();

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void prevSlide_1prev_from1_expect1()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        presentation.append(slide1);

        presentation.setSlideNumber(1);

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void prevSlide_1prev_from2_expect1()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);

        presentation.setSlideNumber(1);

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void clear_expectSize0()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);

        presentation.clear();

        assertEquals(0, presentation.getSize());
    }

    @Test
    void getInstance_expectPresentation()
    {
        assertInstanceOf(Presentation.class, Presentation.getInstance());
    }

    @Test
    void getInstance_executeTwoTimes_ExpectSamePresentation()
    {
        Presentation presentation1 = Presentation.getInstance();
        Presentation presentation2 = Presentation.getInstance();

        assertEquals(presentation1, presentation2);
    }

    @Test
    void getSlide_negativeSlideNumber_expectNull()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        Slide slide3 = new Slide();
        ArrayList<Slide> slides = new ArrayList<>();
        slides.add(slide1);
        slides.add(slide2);
        slides.add(slide3);
        presentation.setShowList(slides);

        assertEquals(null, presentation.getSlide(-1));
    }

    @Test
    void getSlide_zeroSlideNumber_expectSlide()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        Slide slide3 = new Slide();
        ArrayList<Slide> slides = new ArrayList<>();
        slides.add(slide1);
        slides.add(slide2);
        slides.add(slide3);
        presentation.setShowList(slides);

        assertEquals(slide1, presentation.getSlide(0));
    }

    @Test
    void getSlide_tooLargeSlideNumber_expectNull()
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        Slide slide3 = new Slide();
        ArrayList<Slide> slides = new ArrayList<>();
        slides.add(slide1);
        slides.add(slide2);
        slides.add(slide3);
        presentation.setShowList(slides);

        assertEquals(null, presentation.getSlide(4));
    }
}
