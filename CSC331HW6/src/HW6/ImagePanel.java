package HW6;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int panelHeight;
	private int panelWidth;
	private BufferedImage img;
	private ImageComponent imageComponent;

	public ImagePanel(ImageComponent ic) {
		panelHeight = ic.height;
		panelWidth = ic.width;
		imageComponent = ic;
		img = ic.finalImage;
		setPreferredSize(new Dimension(panelWidth, panelHeight));
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				imageComponent.showTopLayer();
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
		});
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.fillRect(0, 0, panelWidth, panelHeight);
		g2.drawImage(img, 0, 0, this);
	}
}