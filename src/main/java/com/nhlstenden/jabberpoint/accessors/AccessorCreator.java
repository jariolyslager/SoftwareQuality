package com.nhlstenden.jabberpoint.accessors;

public class AccessorCreator
{
    public Accessor createAccessor(AccessorEnum type)
    {
        return switch (type)
        {
            case XML -> new XMLAccessor();
            default -> new DemoPresentation();
        };
    }
}
