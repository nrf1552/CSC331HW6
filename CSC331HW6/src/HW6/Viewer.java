package HW6;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.*;

public class Viewer {

	public Integer selectedNumber;
	public Integer selectedNumberOfPanels;
	public Boolean isAddSubtract;
	public String selectedImage;
	public Date[] times;

	JFrame frame;
	BufferedImage[] images;
	JPanel panelContainer;

	public Viewer() {
		// Instantiate JFrame
		frame = new JFrame("Homework 6");

		// Set initial properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);

		// Add menu
		frame.setJMenuBar(new ViewerMenu().menu(this));

		// Add container for all image components
		panelContainer = new JPanel();
		panelContainer.setSize(frame.getSize());
		frame.add(panelContainer);

		// Show it
		frame.setVisible(true);

		// Show image components
		displayImageComponents();
	}

	public void displayImageComponents() {

		if (selectedNumber != null && selectedNumberOfPanels != null && isAddSubtract != null
				&& selectedImage != null) {

			images = new ImageSplitter().splitImage(selectedNumberOfPanels,selectedImage, false);
			panelContainer.setLayout(new GridLayout((int)Math.sqrt(selectedNumberOfPanels),(int)Math.sqrt(selectedNumberOfPanels)));
			for(BufferedImage img:images){
				panelContainer.add(new ImageComponent(img));
			}
			
			panelContainer.revalidate();
		}
	}
	
	//Method to get average time for each problem correctly answered
	private long getAverageElapsedTime() {
		
		long total = 0;
		
		for (int i = 0; i < times.length; i++) {
			total = total + times[i].getTime();
		}
		
		long average = total / times.length;
		return average;
		
	}

	public static void main(String[] args) {
		new Viewer();
	}
}
