package HW6;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 */

/**
 * @author Jimmy Silva
 *
 */
//another comment to test commit
// Open an image file, create a grid 2 x 2 and
// save each portion of the grid as an separate image file (makes 4)
// displays the original image and the 4 new image
// to change target image syntax needs to be change

public class ImageSplitter {

	private static BufferedImage img = null;
	private static File f = null;

	private static BufferedImage topLeftImg = null;// works for 2x2, 3x3 and 4x4 grid
	private static BufferedImage topLeftMidImg = null; // works for 4x4 grid
	private static BufferedImage topMidImg = null; // works for 3x3 grid
	private static BufferedImage topRightMidImg = null;// works for 4x4 grid
	private static BufferedImage topRightImg = null;// works for 2x2, 3x3 and
													// 4x4 grid

	private static BufferedImage topMidLeftImg = null; // works for 4x4 grid
	private static BufferedImage topMidLeftMidImg = null;// works for 4x4 grid
	private static BufferedImage topMidRightMidImg = null;// works for 4x4 grid
	private static BufferedImage topMidRightImg = null;// works for 4x4 grid

	private static BufferedImage midLeftImg = null;// works for 3x3 grid
	private static BufferedImage middleImg = null;// works for 3x3 grid
	private static BufferedImage midRightImg = null;// works for 3x3 grid

	private static BufferedImage botMidLeftImg = null; // works for 4x4 grid
	private static BufferedImage botMidLeftMidImg = null;// works for 4x4 grid
	private static BufferedImage botMidRightMidImg = null;// works for 4x4 grid
	private static BufferedImage botMidRightImg = null;// works for 4x4 grid

	private static BufferedImage botLeftImg = null; // works for 2x2, 3x3 and
													// 4x4 grid
	private static BufferedImage botLeftMidImg = null; // for 4x4 grid
	private static BufferedImage botMidImg = null; // for 3x3 grid
	private static BufferedImage botRightMidImg = null; // for 4x4 grid
	private static BufferedImage botRightImg = null; // works for 2x2, 3x3 and
														// 4x4 grid

	// Takes image file and split it into four

	// @param none
	// @return none
	// @see original image and image split in four
	public ImageSplitter(int userIn, String file) {

		try {
			img = ImageIO.read(new File(file));
			JFrame frame = new JFrame();
			frame.getContentPane().setLayout(new FlowLayout());
			frame.getContentPane().add(new JLabel(new ImageIcon(img)));

			int height = img.getHeight();
			int width = img.getWidth();

			if (userIn == 4) {
				topLeftImg = img.getSubimage(0, 0, (width / 2), (height / 2));
				topRightImg = img.getSubimage((width / 2), 0, (width / 2), (height / 2));

				botLeftImg = img.getSubimage(0, (height / 2), (width / 2), (height / 2));
				botRightImg = img.getSubimage((width / 2), (height / 2), (width / 2), (height / 2));

				frame.getContentPane().add(new JLabel(new ImageIcon(topLeftImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(topRightImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(botLeftImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(botRightImg)));
				frame.pack();
				frame.setVisible(true);
			}

			else if (userIn == 9) {
				// x-y coords for top left at (0,0)
				topLeftImg = img.getSubimage(0, 0, (width / 2), (height / 2)); 
				// x coord is 1/3 of the total width of img
				topMidImg = img.getSubimage((width / 3), 0, (width / 3), (height / 3));
				 // x-coord starts at 1/3 of the total width multiplied by 2
				topRightImg = img.getSubimage(((width / 3) * 2), 0, (width / 3), (height / 3));

				midLeftImg = img.getSubimage(0, (height / 3), (width / 3), (height / 3));
				middleImg = img.getSubimage((width / 3), (height / 3), (width / 3), (height / 3));
				midRightImg = img.getSubimage(((width / 3) * 2), (height / 3), (width / 3), (height / 3));

				botLeftImg = img.getSubimage(0, (height / 2), (width / 3), (height / 3));
				botMidImg = img.getSubimage((width / 3), ((height / 3) * 2), (width / 3), (height / 3));
				botRightImg = img.getSubimage(((width / 3) * 2), ((height / 3) * 2), (width / 3), (height / 3));

				frame.getContentPane().add(new JLabel(new ImageIcon(topLeftImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(topMidImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(topRightImg)));

				frame.getContentPane().add(new JLabel(new ImageIcon(midLeftImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(middleImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(midRightImg)));

				frame.getContentPane().add(new JLabel(new ImageIcon(botLeftImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(botMidImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(botRightImg)));
				frame.pack();
				frame.setVisible(true);

			}

			else if (userIn == 16) {
				// x-y coords for top left at (0,0)
				topLeftImg = img.getSubimage(0, 0, (width / 2), (height / 2)); 
				 // x coord is 1/3 of the total width of img
				topLeftMidImg = img.getSubimage((width / 3), 0, (width / 3), (height / 3));
				// x-coord starts at 1/3 of the total width multiplied by 2
				topRightMidImg = img.getSubimage(((width / 3) * 2), 0, (width / 3), (height / 3)); 
				topRightImg = img.getSubimage(((width / 3) * 2), 0, (width / 3), (height / 3));

				topMidLeftImg = img.getSubimage(0, (height / 4), (width / 4), (height / 4));
				topMidLeftMidImg = img.getSubimage((width / 4), (height / 4), (width / 4), (height / 4));
				topMidRightMidImg = img.getSubimage(((width / 4) * 2), (height / 4), (width / 4), (height / 4));
				topMidRightImg = img.getSubimage(((width / 4) * 3), (height / 4), (width / 4), (height / 4));

				botMidLeftImg = img.getSubimage(0, ((height / 4) * 2), (width / 4), (height / 4));
				botMidLeftMidImg = img.getSubimage((width / 4), ((height / 4) * 2), (width / 4), (height / 4));
				botMidRightMidImg = img.getSubimage(((width / 4) * 2), ((height / 4) * 2), (width / 4), (height / 4));
				botMidRightImg = img.getSubimage(((width / 4) * 3), ((height / 4) * 2), (width / 4), (height / 4));

				botLeftImg = img.getSubimage(0, ((height / 4) * 3), (width / 4), (height / 4));
				botLeftMidImg = img.getSubimage((width / 4), ((height / 4) * 3), (width / 4), (height / 4));
				botRightMidImg = img.getSubimage(((width / 4) * 2), ((height / 4) * 3), (width / 4), (height / 4));
				botRightImg = img.getSubimage(((width / 4) * 3), ((height / 4) * 3), (width / 4), (height / 4));

				frame.getContentPane().add(new JLabel(new ImageIcon(topLeftImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(topLeftMidImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(topRightMidImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(topRightImg)));

				frame.getContentPane().add(new JLabel(new ImageIcon(topMidLeftImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(topMidLeftMidImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(topMidRightMidImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(topMidRightImg)));

				frame.getContentPane().add(new JLabel(new ImageIcon(botMidLeftImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(botMidLeftMidImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(botMidRightMidImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(botMidRightImg)));

				frame.getContentPane().add(new JLabel(new ImageIcon(botLeftImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(botLeftMidImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(botRightMidImg)));
				frame.getContentPane().add(new JLabel(new ImageIcon(botRightImg)));
				frame.pack();
				frame.setVisible(true);
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}
}