package com.nhlstenden.JabberPoint.PresentationControls;

import java.awt.*;

public abstract class Command
{
    private Presentation presentation;
    private Component parent;

    public Command(Presentation presentation)
    {
        this.presentation = presentation;
        this.parent = null;
    }

    public Command(Presentation presentation, Component parent)
    {
        this.presentation = presentation;
        this.parent = parent;
    }

    public Presentation getPresentation()
    {
        return this.presentation;
    }

    public void setPresentation(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public Component getParent()
    {
        return this.parent;
    }

    public void setParent(Component parent)
    {
        this.parent = parent;
    }

    public abstract void execute();
}
