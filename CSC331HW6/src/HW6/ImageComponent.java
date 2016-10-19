package HW6;

import javax.swing.*;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.*;

public class ImageComponent extends JPanel {

	public MathEngine math;

	private JLabel workingLayer;
	private BufferedImage finalImage;
	private String problem;

	int width;
	int height;

	public ImageComponent(BufferedImage image, int userInput, boolean isAddSubtract) {
		width = image.getWidth();
		height = image.getHeight();
		workingLayer = new JLabel();
		math = new MathEngine(userInput, isAddSubtract);

		finalImage = image;
		// problem = math.getProblem();

		showTopLayer();
	}

	private void showTopLayer() {
		new TopPanel(height, width).show();
	}

	private void showMathLayer() {
		String problem = math.getProblem();

		// show problem
		MathPanel panel = new MathPanel(problem, 0, 0);

		// check answer
		if (math.isCorrect(6)) {
			showImageLayer();
		}
	}

	private void showImageLayer() {

	}

	public static void main() {

	}
}
