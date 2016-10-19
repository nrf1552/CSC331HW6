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

	JFrame outerFrame;
	MathEngine engine;
	ImageSplitter splitter;
	BufferedImage[] images;
	JPanel imagePanel;
	JLabel imageHolder;

	public Viewer() {
		// Instantiate JFrame
		outerFrame = new JFrame("Homework 6");

		// Set initial properties
		outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerFrame.setSize(1200, 800);

		// Add menu
		outerFrame.setJMenuBar(new ViewerMenu().menu(this));

		// Add image component so that it can be easily updated
		imagePanel = new JPanel();
		imageHolder = new JLabel();
		outerFrame.add(imageHolder);

		// Show it
		outerFrame.setVisible(true);

		// Show image components
		displayImageComponents();
	}

	public void displayImageComponents() {

		if (allOptionsSelected()) {
			
			images = [];

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

	private boolean allOptionsSelected() {
		return (selectedNumber != null 
				&& selectedNumberOfProblems != null 
				&& selectedMath != null
				&& selectedImage != null);
	}

	public static void main(String[] args) {
		new Viewer();
	}
}
