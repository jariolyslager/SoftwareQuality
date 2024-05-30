package com.nhlstenden.jabberpoint.presentationcontrols;

import com.nhlstenden.jabberpoint.accessors.Accessor;
import com.nhlstenden.jabberpoint.accessors.AccessorCreator;
import com.nhlstenden.jabberpoint.accessors.AccessorEnum;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenCommand extends Command
{
    protected static final String TESTFILE = "test.xml";
    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";

    public OpenCommand(Presentation presentation, Component parent)
    {
        super(presentation, parent);
    }

    @Override
    public void execute()
    {
        this.getPresentation().clear();
        Accessor xmlAccessor = new AccessorCreator().createAccessor(AccessorEnum.XML);

        try
        {
            xmlAccessor.loadFile(this.getPresentation(), TESTFILE);
            this.getPresentation().setSlideNumber(0);
        }
        catch (IOException exc)
        {
            JOptionPane.showMessageDialog(this.getParent(), IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
        }

        this.getParent().repaint();
    }
}
