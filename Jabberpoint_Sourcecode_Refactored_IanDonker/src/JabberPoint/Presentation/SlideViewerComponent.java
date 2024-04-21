package JabberPoint.Presentation;

import JabberPoint.Style.StyleFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;


/**
 * <p>JabberPoint.Presentation.SlideViewerComponent is a graphical component that ca display Slides.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent
{

    private Font labelFont = null; //The font for labels
    private Presentation presentation = null; //The presentation
    private int currentSlideNumber;

    private static final long serialVersionUID = 227L;

    private static final Color BGCOLOR = Color.white;
    private static final Color COLOR = Color.black;
    private static final String FONTNAME = "Dialog";
    private static final int FONTSTYLE = Font.BOLD;
    private static final int FONTHEIGHT = 10;
    private static final int XPOS = 1100;
    private static final int YPOS = 20;

    public SlideViewerComponent(Presentation pres)
    {
        setBackground(BGCOLOR);
        presentation = pres;
        labelFont = StyleFactory.createFont(FONTNAME, FONTSTYLE, FONTHEIGHT);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(Slide.WIDTH, Slide.HEIGHT);
    }

    public void update(Presentation presentation)
    {
        this.presentation = presentation;
        repaint();
    }

	public void update()
	{
		repaint();
	}

    //Draw the slide
    public void paintComponent(Graphics g)
    {
        g.setColor(BGCOLOR);
        g.fillRect(0, 0, getSize().width, getSize().height);
        if (currentSlideNumber < 0 || presentation.getCurrentSlide(currentSlideNumber) == null)
        {
            return;
        }
        g.setFont(labelFont);
        g.setColor(COLOR);
        g.drawString("Slide" + (1 + currentSlideNumber) + " of " + presentation.getSize(), XPOS, YPOS);
        Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
        presentation.getCurrentSlide(currentSlideNumber).draw(g, area, this);
    }

	public void setSlideNumber(int number)
	{
		currentSlideNumber = number;
		update();
	}

	public void prevSlide()
	{
		if (currentSlideNumber > 0)
		{
			setSlideNumber(currentSlideNumber - 1);
		}
	}

	public void nextSlide()
	{
		if (currentSlideNumber < (presentation.getSize() - 1))
		{
			setSlideNumber(currentSlideNumber + 1);
		}
	}

	public void exit(int n)
	{
		System.exit(n);
	}

	public Presentation getPresentation()
	{
		return this.presentation;
	}
}
