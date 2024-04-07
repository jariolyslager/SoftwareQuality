package com.nhlstenden.JabberPoint.PresentationControls;

public class PrevSlideCommand extends Command
{
    public PrevSlideCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        this.getPresentation().prevSlide();
    }
}
