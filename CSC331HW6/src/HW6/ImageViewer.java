package HW6;

import javax.swing.*;

public class ImageViewer {

	public JFrame frame;
	
	public ImageViewer() {
		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);

		// Add menu
		frame.setJMenuBar(new ImageMenu().menu(this));
		
		frame.setVisible(true);
	}

}
