package com.nhlstenden.JabberPoint.PresentationControls;

public class NextSlideCommand extends Command
{
    public NextSlideCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        this.getPresentation().nextSlide();
    }
}
