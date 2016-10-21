package HW6;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Viewer {

	public Integer selectedNumber;
	public Integer selectedNumberOfProblems;
	public String selectedMath;
	public String selectedImage;

	JFrame frame;
	MathEngine engine;
	ImageSplitter splitter;
	BufferedImage[] images;
	JLabel imageHolder;

	public Viewer() {
		// Instantiate JFrame
		frame = new JFrame("Homework 6");

		// Set initial properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);

		// Add menu
		frame.setJMenuBar(new ViewerMenu().menu(this));

		// Add image component so that it can be easily updated
		imageHolder = new JLabel();
		frame.add(imageHolder);

		// Show it
		frame.setVisible(true);

		// Show image components
		displayImageComponents();
	}

	public void displayImageComponents() {

		if (selectedNumber != null && selectedNumberOfProblems != null && selectedMath != null
				&& selectedImage != null) {
			imageHolder.setIcon(getIcon(selectedImage));

			// images = new ImageSplitter(16,"picture1").getSplitImages();
		}
	}

	private ImageIcon getIcon(String imagePath) {
		File imgFile = new File(imagePath);
		Image img = null;

		try {
			img = ImageIO.read(imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ImageIcon(img);
	}

	public static void main(String[] args) {
		new Viewer();
	}
}
