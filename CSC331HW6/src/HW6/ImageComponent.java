package HW6;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class ImageComponent extends JPanel {

	private static final long serialVersionUID = 1L;

	public MathEngine math;
	private BufferedImage finalImage;
	private String problem;
	private JPanel workingPanel;
	int width;
	int height;

	public ImageComponent(BufferedImage image){//Viewer viewer) {
		width = image.getWidth();
		height = image.getHeight();
		setPreferredSize(new Dimension(width,height));
		//math = new MathEngine(viewer.selectedNumber, viewer.isAddSubtract);
		finalImage = image;
		workingPanel = new JPanel(new CardLayout());
		workingPanel.add(new TopPanel(height,width));
		workingPanel.add(new MathPanel("2+2",height,width,0).showPanel());

		showTopLayer();
	}

	private void showTopLayer() {
		workingPanel.add(new TopPanel(height, width));
	}

	private void showMathLayer() {
		String problem = math.getProblem();

		// check answer
		if (math.isCorrect(6)) {
			showImageLayer();
		}
	}

	private void showImageLayer() {

	}
	
	
	
	
	
	
	private boolean answered;
	private boolean working;
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (!answered) {
			if (working){
				g2.setColor(Color.green);
				g2.fillRect(0, 0, width, height);
				g2.setPaint(Color.yellow);
				g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
				g2.drawString("Testing, one, two, three.", width/3, height/2);
				((JFrame)SwingUtilities.getRoot(this)).setTitle("Testing, one, two, three.");
			}
			else{
				g2.setColor(Color.darkGray);
				g2.fillRect(0, 0, width, height);
			}
			working = !working;  // toggles on and off
		} else {
			g2.drawImage(finalImage, 0, 0, this);
			((JFrame)SwingUtilities.getRoot(this)).setTitle("Testing GPanel");
		}
		answered = !answered; // toggles on and off 
	}
	public static void main(String[] args) {
		BufferedImage img = null;
		try 
		{
		    img = ImageIO.read(new File("fall.jpg")); 
	    } 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
		
		CardLayout lo = new CardLayout();
		
		
		JFrame f = new JFrame("Test");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new ImageComponent(img));

		f.pack();
		f.setVisible(true);
	}
}
