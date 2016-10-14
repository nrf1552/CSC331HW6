package HW6;

import javax.swing.*;

public class ImageViewer {

	public JFrame frame;
	
	public ImageViewer() {
		frame = new JFrame("Homework 6");
		
		// Set initial properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);

		// Add menu
		frame.setJMenuBar(new ImageMenu().menu(this));
		
		// Show it
		frame.setVisible(true);
	}

}
