package com.nhlstenden.jabberpoint.presentationcontrols;

import java.awt.*;

public class NewCommand extends Command
{

    public NewCommand(Presentation presentation, Component parent)
    {
        super(presentation, parent);
    }

    @Override
    public void execute()
    {
        this.getPresentation().clear();
        this.getParent().repaint();
    }
}
