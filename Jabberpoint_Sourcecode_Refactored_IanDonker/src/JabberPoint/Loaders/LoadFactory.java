package JabberPoint.Loaders;

public class LoadFactory
{
    public static DemoPresentation createDemoPresentation()
    {
        return new DemoPresentation();
    }

    public static XMLAccessor createXMLAccessor()
    {
        return new XMLAccessor();
    }
}
