package HW6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TopPanel extends JPanel{
	public int panelHeight;
	public int panelWidth;
	
	public TopPanel(int height, int width){
		panelHeight = height;
		panelWidth = width;
		setPreferredSize(new Dimension(width,height));
	}
		
	// paints the grey top panel
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.blue);
		g2.fillRect(0, 0, panelWidth, panelHeight);
		g2.setPaint(Color.yellow);
		g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
		g2.drawString("Click to show problem", panelWidth/4, panelWidth/2);
	}
}
