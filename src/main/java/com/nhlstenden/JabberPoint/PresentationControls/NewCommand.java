package com.nhlstenden.JabberPoint.PresentationControls;

import java.awt.*;

public class NewCommand extends Command
{
    private Component parent;

    public NewCommand(Presentation presentation, Component parent)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        this.getPresentation().clear();
        this.parent.repaint();
    }
}
