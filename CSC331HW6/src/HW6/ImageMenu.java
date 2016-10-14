package HW6;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class ImageMenu {

	JTextArea output;
	JScrollPane scrollPane;

	String[] images = { "Spring", "Summer", "Fall", "Winter" };
	String[] imageFiles = { "Spring.jpg", "Summer.jpg", "Fall.jpg", "Winter.jpg" };

	int[] numberOfProblems = { 4, 9, 16 };
	String[] calculationType = {"Add/Subtract","Multiply/Divide"};

	int acceleratorKeyCodeTracker = KeyEvent.VK_1;
	int mnemonicKeyCode = KeyEvent.VK_1;

	public JMenuBar menu(ImageViewer viewer) {
		JMenuBar menuBar;
		JMenu menu;
		JMenu submenu;
		JMenuItem menuitem;
		ButtonGroup radiogroup;
		JRadioButtonMenuItem radioItem;

		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menuBar.add(menu);

		// Create sub menu for all available images
		submenu = new JMenu("Select an image");
		for (int i = 0; i < images.length; i++) {
			menuitem = new JMenuItem(images[i], acceleratorKeyCodeTracker + i);
			acceleratorKeyCodeTracker += i;
			menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1 + i, ActionEvent.ALT_MASK));
			submenu.add(menuitem);
		}
		menu.add(submenu);

		// create sub menu for the # of problems
		submenu = new JMenu("Select # of problems");
		for (int i = 0; i < numberOfProblems.length; i++) {
			menuitem = new JMenuItem(Integer.toString(numberOfProblems[i]), acceleratorKeyCodeTracker + i);
			acceleratorKeyCodeTracker += i;
			menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1 + i, ActionEvent.ALT_MASK));
			submenu.add(menuitem);
		}
		menu.add(submenu);

		// create sub menu for the number family type and calculation type
		submenu = new JMenu("Select number family");
		radiogroup = new ButtonGroup();

		for (int i = 0; i <= 12; i++) {
			radioItem = new JRadioButtonMenuItem(Integer.toString(i));
			if (i == 0) { // default
				radioItem.setSelected(true);
			}
			radiogroup.add(radioItem);
			submenu.add(radioItem);
		}		
		submenu.addSeparator();
		radiogroup = new ButtonGroup();
		for (int i = 0; i  < calculationType.length; i++){
			radioItem = new JRadioButtonMenuItem(calculationType[i]);
			radiogroup.add(radioItem);
			submenu.add(radioItem);
		}
		menu.add(submenu);
		menu.addSeparator();

		// exit menu item
		menuitem = new JMenuItem("Exit");
		menu.add(menuitem);

		return menuBar;
	}

}
