package com.nhlstenden.jabberpoint.accessors;

import com.nhlstenden.jabberpoint.presentationcontrols.Presentation;

import java.io.IOException;

public interface SaveAccessor
{
    void saveFile(Presentation presentation, String fileName) throws IOException;
}
