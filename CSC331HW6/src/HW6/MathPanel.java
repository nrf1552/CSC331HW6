//Continue working on the MathPanel so that the panel displays 
//the problem, a textbox for input, an enter keylistener, and 
//a method that can be called to show the answer and disable 
//the textbox.
//comment
package HW6;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MathPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int attempts = 0;
	private int mathAnswer;
	private int panelHeight;
	private int panelWidth;
	private String mathProblem;
	private JTextField fieldAnswer;
	private long solveTime;
	
	private Date previous;
	private Date current;
	
	public MathPanel(ImageComponent ic){
		panelHeight = ic.height;
		panelWidth = ic.width;
		mathProblem = ic.math.getProblem();
		mathAnswer = ic.math.getAnswer();
	}
	
	public JPanel showPanel(){	
		//show problem in lab
		JLabel problem = new JLabel(mathProblem);
		this.add(problem);
		
		//show textbox for user entry
		JLabel textfieldLabel = new JLabel("Enter the answer to the problem: ");
		this.add(textfieldLabel);
				
		fieldAnswer = new JTextField();
		fieldAnswer.setPreferredSize(new Dimension(200, 20));
		this.add(fieldAnswer);
		
		//show enter button
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//when enter button is pressed, check to see
						//if userAnswer = math problem solution
						String inputAnswer = fieldAnswer.getText();
						if (inputAnswer == Integer.toString(mathAnswer)) {
							//end timer
							previous = current;
							current = new Date();
							solveTime = current.getTime() - previous.getTime();
							//Panel disappears, revealing the image underneath
							
						}
						
						else {
							//Only 2 attempts allowed before the correct answer displays
							attempts += 1;
							if (attempts == 2) {
								fieldAnswer.setText(Integer.toString(mathAnswer));
							}
						}
					}
				}	
		);
				
		this.add(enterButton);
		
		return this;
	}
	
	public long getElapsedTime() {
		return solveTime;
	}
}
