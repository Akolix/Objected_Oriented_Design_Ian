package JabberPoint.Presentation;

import JabberPoint.Navigation.KeyController;
import JabberPoint.Navigation.MenuController;
import JabberPoint.Navigation.MenuFactory;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

/**
 * <p>The applicatiewindow for a slideviewcomponent</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerFrame extends JFrame
{
    private static final long serialVersionUID = 3227L;
    private SlideViewerComponent slideViewerComponent;

    private static final String JABTITLE = "Jabberpoint 1.6 - OU";
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;

    public SlideViewerFrame(String title, Presentation presentation)
    {
        super(title);
        this.slideViewerComponent = PresentationFactory.createSlideViewerComponent(presentation);
        this.slideViewerComponent.setSlideNumber(0);
        setupWindow();
    }

    //Setup the GUI
    public void setupWindow()
    {
        setTitle(JABTITLE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        getContentPane().add(slideViewerComponent);
        addKeyListener(MenuFactory.createKeyController(slideViewerComponent));
        setMenuBar(MenuFactory.createMenuController(this));
        setSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
    }

	public void update(Presentation presentation)
	{
		this.setTitle(presentation.getTitle());
		this.repaint();
	}

	public SlideViewerComponent getSlideViewerComponent()
	{
		return this.slideViewerComponent;
	}
}
