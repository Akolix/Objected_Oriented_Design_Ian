package JabberPoint.Presentation;

import java.util.ArrayList;


/**
 * <p>Presentations keeps track of the slides in a presentation.</p>
 * <p>Only one instance of this class is available.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation
{
    private String showTitle; //The title of the presentation
    private ArrayList<Slide> showList = null; //An ArrayList with slides

    public Presentation()
    {
        clear();
    }

    public int getSize()
    {
        return showList.size();
    }

    public String getTitle()
    {
        return showTitle;
    }

    public void setTitle(String nt)
    {
        showTitle = nt;
    }

    //Remove the presentation
    public void clear()
    {
		this.setTitle("");
        showList = new ArrayList<Slide>();
    }

    //Add a slide to the presentation
    public void append(Slide slide)
    {
        showList.add(slide);
    }

    //Return a slide with a specific number
    public Slide getSlide(int number)
    {
        if (number < 0 || number >= getSize())
        {
            return null;
        }
        return (Slide) showList.get(number);
    }

    //Return the current slide
    public Slide getCurrentSlide(int currentSlideNumber)
    {
        return getSlide(currentSlideNumber);
    }

    public void exit(int n)
    {
        System.exit(n);
    }
}
