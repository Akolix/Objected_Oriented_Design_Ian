package JabberPoint.Navigation;

import JabberPoint.Interfaces.LoadAble;
import JabberPoint.Interfaces.SaveAble;
import JabberPoint.Loaders.LoadFactory;
import JabberPoint.Loaders.XMLAccessor;
import JabberPoint.Presentation.Presentation;
import JabberPoint.Presentation.SlideViewerComponent;
import JabberPoint.Presentation.SlideViewerFrame;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * <p>The controller for the menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar
{

    private SlideViewerFrame p;
    private SlideViewerComponent sc;
    private final SaveAble saveAble = LoadFactory.createXMLAccessor();
    private final LoadAble loadAble = LoadFactory.createXMLAccessor();

    private static final long serialVersionUID = 227L;

    protected static final String ABOUT = "About";
    protected static final String FILE = "File";
    protected static final String EXIT = "Exit";
    protected static final String GOTO = "Go to";
    protected static final String HELP = "Help";
    protected static final String NEW = "New";
    protected static final String NEXT = "Next";
    protected static final String OPEN = "Open";
    protected static final String PAGENR = "Page number?";
    protected static final String PREV = "Prev";
    protected static final String SAVE = "Save";
    protected static final String VIEW = "View";

    protected static final String TESTFILE = "testPresentation.xml";
    protected static final String SAVEFILE = "savedPresentation.xml";

    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";

    public MenuController(SlideViewerFrame frame)
    {
		this.p = frame;
		this.sc = this.p.getSlideViewerComponent();
		this.createMenu();
    }

	private void createMenu()
	{
		Presentation presentation = this.sc.getPresentation();
		this.createFileMenu();
		this.createViewMenu();
		this.createHelpMenu();
	}

	private void createFileMenu()
	{
		MenuItem menuItem;
		Presentation presentation = this.sc.getPresentation();
		Menu fileMenu = new Menu(FILE);
		fileMenu.add(menuItem = mkMenuItem(OPEN));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.clear();
				try {
					loadAble.loadFile(sc, TESTFILE);
					p.update(presentation);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(p, IOEX + exc,
							LOADERR, JOptionPane.ERROR_MESSAGE);
				}
			}
		} );
		fileMenu.add(menuItem = mkMenuItem(NEW));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.clear();
				p.update(presentation);
			}
		});
		fileMenu.add(menuItem = mkMenuItem(SAVE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saveAble.saveFile(sc, SAVEFILE);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(p, IOEX + exc,
							SAVEERR, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		fileMenu.addSeparator();
		fileMenu.add(menuItem = mkMenuItem(EXIT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				sc.exit(0);
			}
		});
		add(fileMenu);
	}

	private void createViewMenu()
	{
		MenuItem menuItem;
		Presentation presentation = this.sc.getPresentation();
		Menu viewMenu = new Menu(VIEW);
		viewMenu.add(menuItem = mkMenuItem(NEXT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				sc.nextSlide();
			}
		});
		viewMenu.add(menuItem = mkMenuItem(PREV));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				sc.prevSlide();
			}
		});
		viewMenu.add(menuItem = mkMenuItem(GOTO));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);
				int pageNumber = Integer.parseInt(pageNumberStr);
				sc.setSlideNumber(pageNumber - 1);
			}
		});
		add(viewMenu);
	}

	private void createHelpMenu()
	{
		MenuItem menuItem;
		Presentation presentation = this.sc.getPresentation();
		Menu helpMenu = new Menu(HELP);
		helpMenu.add(menuItem = mkMenuItem(ABOUT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AboutBox.show(p);
			}
		});
		setHelpMenu(helpMenu);
	}

    //Creating a menu-item
    public MenuItem mkMenuItem(String name)
    {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
