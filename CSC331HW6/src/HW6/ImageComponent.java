package HW6;

import javax.swing.*;
import java.awt.image.*;

public class ImageComponent {

	public MathEngine math;
	
	JFrame imageLayer;
	JFrame mathLayer;
	JFrame solidLayer;
	
	String problem;


	public ImageComponent(BufferedImage image, int userInput, int mathType) {
		math = new MathEngine();
		//problem = math.getProblem();
		
		showTopLayer();
	}
	
	private void showImageLayer(){
		
	}
	
	private void showMathLayer(){		
		//display problem
		
		//get user input
		
		//if (math.isCorrect(6)){
			//showImageLayer();
		//}

	}
	
	private void showTopLayer(){
		
	}

}
