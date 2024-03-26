package com.nhlstenden.JabberPoint.PresentationControls;

public abstract class Command
{
    private Presentation presentation;

    public Command(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public Presentation getPresentation()
    {
        return this.presentation;
    }

    public void setPresentation(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public abstract void execute();
}
