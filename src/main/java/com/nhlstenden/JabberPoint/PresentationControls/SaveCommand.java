package com.nhlstenden.JabberPoint.PresentationControls;

import com.nhlstenden.JabberPoint.Accessors.Accessor;
import com.nhlstenden.JabberPoint.Accessors.AccessorCreator;
import com.nhlstenden.JabberPoint.Accessors.AccessorEnum;
import com.nhlstenden.JabberPoint.Accessors.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SaveCommand extends Command
{
    protected static final String SAVEFILE = "dump.xml";
    protected static final String IOEX = "IO Exception: ";
    protected static final String SAVEERR = "Save Error";

    private Component parent;

    public SaveCommand(Presentation presentation, Component parent)
    {
        super(presentation);
        this.parent = parent;
    }

    @Override
    public void execute()
    {
        Accessor xmlAccessor = new AccessorCreator().createAccessor(AccessorEnum.XML);

        try
        {
            xmlAccessor.saveFile(this.getPresentation(), SAVEFILE);
        }
        catch (IOException exception)
        {
            JOptionPane.showMessageDialog(parent, IOEX + exception, SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
