package com.nhlstenden.JabberPoint.Accessors;

public class AccessorCreator
{
    public AccessorCreator()
    {
    }

    public Accessor createAccessor(AccessorEnum type)
    {
        switch(type)
        {
            case XML:
                return new XMLAccessor();
            case DEMO:
                return new DemoPresentation();
            default:
                return new DemoPresentation();
        }
    }
}
