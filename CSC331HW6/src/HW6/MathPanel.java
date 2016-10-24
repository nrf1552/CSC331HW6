package HW6;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MathPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int attempts = 0;
	private int mathAnswer;

	private String mathProblem;
	private JTextField fieldAnswer;
	private long solveTime;

	private long startTime;
	private long current;

	private MathEngine math;
	private ImageComponent imageComponent;
	
	JLabel problemLabel;
	JPanel entryPanel;
	JLabel textfieldLabel;
	JButton enterButton;
	

	public MathPanel(ImageComponent ic) {
		imageComponent = ic;
		math = new MathEngine(ic.viewer.selectedNumber, ic.viewer.isAddSubtract);
		mathProblem = math.getProblem();
		mathAnswer = math.getAnswer();
	}

	public JPanel showPanel() {
		this.setLayout(new GridLayout(4, 1));
		// show problem
		problemLabel = new JLabel(mathProblem, SwingConstants.CENTER);
		problemLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 48));
		this.add(problemLabel);

		// show textbox for user entry
		entryPanel = new JPanel();
		fieldAnswer = new JTextField();
		textfieldLabel = new JLabel("Enter answer: ", SwingConstants.RIGHT);
		entryPanel.setLayout(new GridLayout(1, 2));
		fieldAnswer.setPreferredSize(new Dimension(200, 20));
		fieldAnswer.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {			
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					validateAnswer();
				}
			}
		});
		textfieldLabel.setLabelFor(fieldAnswer);
		entryPanel.add(textfieldLabel);
		entryPanel.add(fieldAnswer);
		this.add(entryPanel);

		// show enter button
		enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validateAnswer();
			}
		});
		this.add(enterButton);
		startTime = System.nanoTime();

		return this;
	}

	public long getElapsedTime() {
		return solveTime;
	}
	
	private void validateAnswer(){
		// when either enter button is pressed, or enter is keyed, checks
		// if userAnswer = math problem solution
		attempts += 1;
		

		if (math.isCorrect(fieldAnswer.getText())) {
			current = System.nanoTime();
			solveTime = current - startTime;

			imageComponent.showImageLayer();
			imageComponent.viewer.recordWin(getElapsedTime());
		} else {
			// Only 2 attempts allowed before the correct answer
			// displays
			if (attempts == 2) {
				fieldAnswer.setText(Integer.toString(mathAnswer));
				fieldAnswer.setEditable(false);
				textfieldLabel.setText("Correct answer:");
				
				imageComponent.viewer.recordLoss();
				enterButton.setText("Click to reveal image");
				enterButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						imageComponent.showImageLayer();
					}
				});
			}
		}
	}
}