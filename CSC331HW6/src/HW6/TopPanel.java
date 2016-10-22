package HW6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class TopPanel extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	private int panelHeight;
	private int panelWidth;
	private ImageComponent imageComponent;

	public TopPanel(ImageComponent ic) {
		imageComponent = ic;
		panelHeight = ic.height;
		panelWidth = ic.width;
		setPreferredSize(new Dimension(ic.width, ic.height));
	}

	// paints the grey top panel
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.blue);
		g2.fillRect(0, 0, panelWidth, panelHeight);
		g2.setPaint(Color.yellow);
		g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
		g2.drawString("Click to show problem", panelWidth / 4, panelWidth / 2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
		imageComponent.showImageLayer();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
