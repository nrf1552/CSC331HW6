package HW6;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private int panelHeight;
	private int panelWidth;
	private BufferedImage img;
	
	public ImagePanel(BufferedImage image){
		panelHeight = image.getHeight();
		panelWidth = image.getWidth();
		img = image;
		setPreferredSize(new Dimension(panelWidth,panelHeight));
	}
		
	// paints the grey top panel
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.fillRect(0, 0, panelWidth, panelHeight);
		g2.drawImage(img,0,0,this);
	}
}
