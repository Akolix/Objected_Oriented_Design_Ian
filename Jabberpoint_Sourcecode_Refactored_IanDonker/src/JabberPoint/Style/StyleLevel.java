package JabberPoint.Style;

public enum StyleLevel
{
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR;

    public static StyleLevel intToLevel(int i)
    {
        switch(i)
        {
            case 0 -> {return StyleLevel.ZERO;}
            case 1 -> {return StyleLevel.ONE;}
            case 2 -> {return StyleLevel.TWO;}
            case 3 -> {return StyleLevel.THREE;}
            case 4 -> {return StyleLevel.FOUR;}
        }
        throw new IllegalArgumentException("Int level does not to the available Style levels");
    }
}
