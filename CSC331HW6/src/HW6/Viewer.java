package HW6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.*;

import javax.swing.*;

public class Viewer {

	public Integer selectedNumber;
	public Integer selectedNumberOfPanels;
	public Boolean isAddSubtract;
	public String selectedImage;

	private JFrame frame;
	private BufferedImage[] images;
	private JPanel panelContainer;
	private List<Long> times;
	private int wins;
	private int losses;

	public Viewer() {
		// Instantiate JFrame
		frame = new JFrame("Homework 6");

		// Set initial properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(1205, 805);

		// Add menu
		frame.setJMenuBar(new ViewerMenu().menu(this));

		// Add container for all image components
		panelContainer = new JPanel();
		panelContainer.setPreferredSize(new Dimension(1200, 800));
		frame.add(panelContainer);

		// Show it
		frame.setVisible(true);
		frame.pack();

		// Show image components
		displayImageComponents();
		
	}

	public void displayImageComponents() {

		if (selectedNumber != null && selectedNumberOfPanels != null && isAddSubtract != null
				&& selectedImage != null) {

			// re-initialize game variables
			times = new ArrayList<Long>();
			wins = 0;
			losses = 0;

			int size = (int) Math.sqrt(selectedNumberOfPanels);

			images = new ImageSplitter().splitImage(selectedNumberOfPanels, selectedImage, false);
			panelContainer.setLayout(new GridLayout(size, size));
			for (BufferedImage img : images) {
				panelContainer.add(new ImageComponent(img, this));
			}

			panelContainer.revalidate();
		}
	}

	public void recordWin(Long timeToSolve) {
		wins += 1;
		times.add(timeToSolve);
		showResults();
	}

	public void recordLoss() {
		losses += 1;
		showResults();
	}

	public void showResults() {
		
		if (wins + losses == selectedNumberOfPanels) {
			JPanel answerResults = new JPanel();
			JLabel label = new JLabel("Total answered Correctly: " + wins + "\nTotal time to finish: " + times);
			answerResults.add(label);
			frame.add(answerResults, BorderLayout.CENTER);
			
		}
	}

	public static void main(String[] args) {
		new Viewer();
	}

	// Method to get average time for each problem correctly answered
	private long getAverageElapsedTime() {
		long total = 0;

		for (Long t : times) {
			total += t;
		}

		return total / times.size();
	}
}
