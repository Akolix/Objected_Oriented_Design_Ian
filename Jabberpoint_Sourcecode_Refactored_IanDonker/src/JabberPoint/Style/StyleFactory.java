package JabberPoint.Style;

import java.awt.*;

public abstract class StyleFactory
{
    private static final String FONTNAME = "Helvetica";

    public static Style createStyle(StyleLevel level) throws LevelImplementationException
    {
        switch (level)
        {
            case ZERO -> {return new Style(0, Color.red, 48, 20);}
            case ONE -> {return new Style(20, Color.blue, 40, 10);}
            case TWO -> {return new Style(50, Color.black, 36, 10);}
            case THREE -> {return new Style(70, Color.black, 30, 10);}
            case FOUR -> {return new Style(90, Color.black, 24, 10);}
        }
        throw new LevelImplementationException();
    }

    /*
        Creating a font for the specific style, we supply the font name in the factory, which is Roboto.
        It's always bold & we supply the fontsize in a parameter.
     */

    public static Font createFont(int fontSize)
    {
        return new Font(StyleFactory.FONTNAME, Font.BOLD, fontSize);
    }

    /*
        Global font.
     */
    public static Font createFont(String fontName, int style, int fontSize)
    {
        return new Font(fontName, style, fontSize);
    }
}
