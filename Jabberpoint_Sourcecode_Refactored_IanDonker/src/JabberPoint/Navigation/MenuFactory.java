package JabberPoint.Navigation;

import JabberPoint.Presentation.SlideViewerComponent;
import JabberPoint.Presentation.SlideViewerFrame;

public class MenuFactory
{
    public static KeyController createKeyController(SlideViewerComponent slideViewerComponent)
    {
        return new KeyController(slideViewerComponent);
    }

    public static MenuController createMenuController(SlideViewerFrame frame)
    {
        return new MenuController(frame);
    }
}
