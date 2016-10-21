package HW6;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.IIOException;
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
//another comment to test commit changes
// Open an image file, create a grid 2 x 2 and
// save each portion of the grid as an separate image file (makes 4)
// displays the original image and the 4 new image
// to change target image syntax needs to be change

public class ImageSplitter {
	
	/**
	 * provided a file directory route this method will create an array of subimages and return
	 * it within an Image array
	 * @param userIn
	 * @param file
	 * @param save
	 * @return Images[]
	 */
	public BufferedImage[] splitImage(int userIn, String file, boolean save){
		int rows = 0, col = 0;
		//initializes the row and column value needed for subimage creation based on userIn
		if(userIn==4){
			rows=2;
			col=2;
		}
		else if(userIn==9){
			rows=3;
			col=3;
		}
		else if(userIn==16){
			rows=4;
			col=4;
		}
		//BufferedImage array that will hold the subimages
		BufferedImage[] imgs=new BufferedImage[rows*col];
		
		try{
			File filename=new File(file);
			FileInputStream fis = new FileInputStream(filename);
			BufferedImage image = ImageIO.read(fis);
			
			int pieceWidth = image.getWidth() / col; //gets total width for subimage divisiom
			int pieceHeight = image.getHeight() / rows; // and total height for subimage division

			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < col; y++) {
					// initializes and creates an image array by creating a new subimage in each iteration
					// of y by multiplying the userInput value rows to the x value being iterated
					imgs[x * rows + y] = new BufferedImage(pieceWidth, pieceHeight, image.getType());
					// draws the image piece
					Graphics2D gr = imgs[x * rows + y].createGraphics();
					gr.drawImage(image, 0, 0, pieceWidth, pieceHeight, pieceWidth * y, pieceHeight * x,
							pieceWidth * y + pieceWidth, pieceHeight * x + pieceHeight, null);
					gr.dispose();
				}
			
			}
			System.out.println("Code has been reached, subimages created");
			if (save) {
				// writing mini images into image files
				String name = file.split(".")[0];
				for (int i = 0; i < imgs.length; i++) {
					ImageIO.write(imgs[i], "jpg", new File(name + i + ".jpg"));
				}
				System.out.println("Mini images saved to file");
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}

		return imgs;
	}


}

