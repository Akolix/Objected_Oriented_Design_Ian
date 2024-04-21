package JabberPoint.Presentation;

import JabberPoint.Style.StyleLevel;

public class PresentationFactory
{
    public static SlideViewerFrame createSlideViewerFrame(String title, Presentation presentation)
    {
        return new SlideViewerFrame(title, presentation);
    }

    public static SlideViewerComponent createSlideViewerComponent(Presentation presentation)
    {
        return new SlideViewerComponent(presentation);
    }

    public static Presentation createPresentation()
    {
        return new Presentation();
    }

    public static Slide createSlide()
    {
        return new Slide();
    }

    public static BitmapItem createBitmapItem(StyleLevel level, String name)
    {
        return new BitmapItem(level, name);
    }

    public static BitmapItem createBitmapItem()
    {
        return new BitmapItem();
    }

    public static TextItem createTextItem(StyleLevel level, String string)
    {
        return new TextItem(level, string);
    }

    public static TextItem createTextItem()
    {
        return new TextItem();
    }
}
