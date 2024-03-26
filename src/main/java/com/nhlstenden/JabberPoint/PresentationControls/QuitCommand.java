package com.nhlstenden.JabberPoint.PresentationControls;

public class QuitCommand extends Command
{
    public QuitCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        System.exit(0);
    }
}
