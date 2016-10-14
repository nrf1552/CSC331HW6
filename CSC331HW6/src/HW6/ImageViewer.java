package HW6;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageViewer {

	JFrame frame;
	MathEngine engine;
	ImageSplitter splitter;
	BufferedImage[] images;
	
	
	public ImageViewer() {
		// Instantiate JFrame
		frame = new JFrame("Homework 6");
		
		// Set initial properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);

		// Add menu
		frame.setJMenuBar(new ImageMenu().menu(this));
		
		// Show it
		frame.setVisible(true);
		
		// Show image components
		displayImageComponents();
	}
	
	public void displayImageComponents(){
		
		Dimension size = frame.getSize();
		
		images = new ImageSplitter(16,"picture1").getSplitImages();
		
		for(BufferedImage img: images){
			ImageComponent image = new ImageComponent(img, 16, 1);
			
		}
		
		
	}
}
