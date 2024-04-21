package JabberPoint.Style;

public class LevelImplementationException extends Exception
{
    @Override
    public String getMessage()
    {
        return "No implementation made for the StyleLevel.";
    }
}
