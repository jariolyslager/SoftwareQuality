package com.nhlstenden.jabberpoint.presentationcontrols;

import com.nhlstenden.jabberpoint.slides.Slide;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OpenCommandTest
{

    @Test
    void execute_openTestFile_expectSuccess() throws Exception
    {
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        presentation.append(slide1);
        presentation.setSlideNumber(1);


        assertDoesNotThrow(() ->
        {
            new OpenCommand(presentation, new JPanel()).execute();
        });
    }
}