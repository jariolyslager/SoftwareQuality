package com.nhlstenden.jabberpoint.presentationcontrols;

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
