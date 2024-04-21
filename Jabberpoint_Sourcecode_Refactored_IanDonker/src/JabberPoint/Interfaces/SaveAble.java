package JabberPoint.Interfaces;

import JabberPoint.Presentation.SlideViewerComponent;

import java.io.IOException;

public interface SaveAble
{
    void saveFile(SlideViewerComponent slideViewerComponent, String filename) throws IOException;
}
