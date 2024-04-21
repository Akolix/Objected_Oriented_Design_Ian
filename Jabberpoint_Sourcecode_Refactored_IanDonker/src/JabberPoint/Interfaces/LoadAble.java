package JabberPoint.Interfaces;

import JabberPoint.Presentation.SlideViewerComponent;

import java.io.IOException;

public interface LoadAble
{
    void loadFile(SlideViewerComponent slideViewerComponent, String fileName) throws IOException;
}
