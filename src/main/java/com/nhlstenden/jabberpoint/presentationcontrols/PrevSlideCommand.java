package com.nhlstenden.jabberpoint.presentationcontrols;

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
