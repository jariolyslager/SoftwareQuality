package com.nhlstenden.JabberPoint.Accessors;

import com.nhlstenden.JabberPoint.PresentationControls.Presentation;

import java.io.IOException;

public interface SaveAccessor
{
    void saveFile(Presentation presentation, String fileName) throws IOException;
}
