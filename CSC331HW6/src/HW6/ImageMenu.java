package HW6;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class ImageMenu {

	JTextArea output;
	JScrollPane scrollPane;

	String image1Name = "Pig";
	String image2Name = "Dog";
	String image3Name = "Cat";
	String image1File = "";
	String image2File = "";
	String image3File = "";

	public ImageMenu() {
		// TODO Auto-generated constructor stub
	}

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

		// Create first sub menu
		submenu = new JMenu("Select an image");
		submenu.setMnemonic(KeyEvent.VK_A);

		menuitem = new JMenuItem(image1Name, KeyEvent.VK_1);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		submenu.add(menuitem);

		menuitem = new JMenuItem(image2Name, KeyEvent.VK_2);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuitem);

		menuitem = new JMenuItem(image3Name, KeyEvent.VK_3);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		submenu.add(menuitem);

		menu.add(submenu);

		// create second sub menu
		submenu = new JMenu("Select # of problems");
		submenu.setMnemonic(KeyEvent.VK_B);

		menuitem = new JMenuItem("4", KeyEvent.VK_4);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		submenu.add(menuitem);

		menuitem = new JMenuItem("9", KeyEvent.VK_5);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
		submenu.add(menuitem);

		menuitem = new JMenuItem("16", KeyEvent.VK_6);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.ALT_MASK));
		submenu.add(menuitem);

		menu.add(submenu);

		// create third sub menu
		submenu = new JMenu("Select number family");
		submenu.setMnemonic(KeyEvent.VK_C);

		// radio button group with 0 thru 12
		radiogroup = new ButtonGroup();

		for (int i = 0; i <= 12; i++) {
			radioItem = new JRadioButtonMenuItem(Integer.toString(i));
			if (i == 0) {
				radioItem.setSelected(true);
			} else {
				radioItem.setSelected(false);
			}
			radiogroup.add(radioItem);
			submenu.add(radioItem);
		}

		submenu.addSeparator();

		// radio button group with add/subtract or multiply/divide
		radiogroup = new ButtonGroup();

		radioItem = new JRadioButtonMenuItem("Add/Subtract");
		radioItem.setSelected(true);
		radiogroup.add(radioItem);
		submenu.add(radioItem);

		radioItem = new JRadioButtonMenuItem("Multiply/Divide");
		radioItem.setSelected(true);
		radiogroup.add(radioItem);
		submenu.add(radioItem);

		menu.add(submenu);
		
		menu.addSeparator();
		
		// exit menu item
		menuitem = new JMenuItem("Exit");
		menu.add(menuitem);

		return menuBar;
	}

}
