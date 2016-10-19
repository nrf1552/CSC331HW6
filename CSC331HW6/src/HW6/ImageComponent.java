package HW6;

import javax.swing.*;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.*;

public class ImageComponent extends JPanel{

	public MathEngine math;

	private JLabel workingLayer;
	private BufferedImage finalImage;
	private String problem;
	
	int width;
	int height;

	public ImageComponent(BufferedImage image, int userInput, int mathType) {
		width = image.getWidth();
		height = image.getHeight();
		workingLayer = new JLabel();
		math = new MathEngine();
		
		finalImage = image;
		// problem = math.getProblem();

		showTopLayer();
	}

	private void showTopLayer() {
		Icon icon = new Icon() {			
			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {}
			
			@Override
			public int getIconWidth() {return width;}
			
			@Override
			public int getIconHeight() {return height;}
		};
		
		
	}

	private void showMathLayer() {
		
		// display problem

		// get user input

		// if (math.isCorrect(6)){
		// showImageLayer();
		// }

	}

	private void showImageLayer() {

	}
	
	public static void main(){
		
	}
}
