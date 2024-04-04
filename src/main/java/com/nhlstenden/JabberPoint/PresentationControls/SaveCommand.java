package com.nhlstenden.JabberPoint.PresentationControls;

import com.nhlstenden.JabberPoint.Accessors.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SaveCommand extends Command
{
    protected static final String SAVEFILE = "dump.xml";
    protected static final String IOEX = "IO Exception: ";
    protected static final String SAVEERR = "Save Error";

    public SaveCommand(Presentation presentation, Component parent)
    {
        super(presentation, parent);
    }

    @Override
    public void execute()
    {
        SaveAccessor xmlAccessor = (SaveAccessor) new AccessorCreator().createAccessor(AccessorEnum.XML);

        try
        {
            xmlAccessor.saveFile(this.getPresentation(), SAVEFILE);
        }
        catch (IOException exception)
        {
            JOptionPane.showMessageDialog(this.getParent(), IOEX + exception, SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
