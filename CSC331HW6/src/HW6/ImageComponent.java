package HW6;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class ImageComponent extends JPanel {

	static final long serialVersionUID = 1L;
	static final String TOP = "TopPanel";
	static final String MATH = "MathPanel";
	static final String IMAGE = "ImagePanel";

	public MathEngine math;
	public BufferedImage finalImage;
	public String problem;

	int width;
	int height;
	
	CardLayout cardLayout;
	JPanel workingPanel;
	
	public ImageComponent(BufferedImage image) {// Viewer viewer) {
		setLayout(new CardLayout());
		cardLayout = (CardLayout)getLayout();
		
		width = image.getWidth();
		height = image.getHeight();
		finalImage = image;
		
		math = new MathEngine(6, true);
		
		setPreferredSize(new Dimension(width, height));
		add(new TopPanel(this), TOP);
		add(new MathPanel(this).showPanel(), MATH);
		add(new ImagePanel(this), IMAGE);
	}

	public void showTopLayer() {
		cardLayout.show(this, TOP);
	}

	public void showMathLayer() {
		cardLayout.show(this, MATH);
	}

	public void showImageLayer() {
		cardLayout.show(this, IMAGE);
	}

	public static void main(String[] args) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("fall.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JFrame f = new JFrame("Test");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		f.add(new ImageComponent(img));
		f.pack();
		f.setVisible(true);
	}
}
