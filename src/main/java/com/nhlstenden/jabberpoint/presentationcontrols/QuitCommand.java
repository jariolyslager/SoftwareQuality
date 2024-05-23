package com.nhlstenden.jabberpoint.presentationcontrols;

public class QuitCommand extends Command
{
    public QuitCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        this.getPresentation().exit(0);
    }
}
