package HW6;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	public MathPanel(ImageComponent ic) {
		imageComponent = ic;
		math = new MathEngine(ic.viewer.selectedNumber, ic.viewer.isAddSubtract);
		mathProblem = math.getProblem();
		mathAnswer = math.getAnswer();
	}

	public JPanel showPanel() {
		this.setLayout(new GridLayout(4, 1));
		// show problem
		JLabel problemLabel = new JLabel(mathProblem, SwingConstants.CENTER);
		problemLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 48));
		this.add(problemLabel);

		// show textbox for user entry
		JPanel entryPanel = new JPanel();
		entryPanel.setLayout(new GridLayout(1, 2));

		JLabel textfieldLabel = new JLabel("Enter answer: ", SwingConstants.RIGHT);
		fieldAnswer = new JTextField();
		fieldAnswer.setPreferredSize(new Dimension(200, 20));
		textfieldLabel.setLabelFor(fieldAnswer);
		entryPanel.add(textfieldLabel);
		entryPanel.add(fieldAnswer);
		this.add(entryPanel);

		// show enter button
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// when enter button is pressed, check to see
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
						enterButton.setEnabled(false);
						imageComponent.viewer.recordLoss();
					}
				}
			}
		});
		this.add(enterButton);
		startTime = System.nanoTime();

		return this;
	}

	public long getElapsedTime() {
		return solveTime;
	}
}