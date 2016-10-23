package HW6;

import java.util.Random;

/**
 * 
 * @author Daniel Emery
 * MathEngine class creates a math problem based on the user's 
 * selected number, a randomly generated number between 1 and 12,
 * and whether or not the problems are based on Addition/Subtraction
 * or Multiplication/Division.
 * 
 */

public class MathEngine {

	private int userNumber;      //variable that holds the number selected by the user in the menu
	private int randomNum;       //variable that holds the randomly generated number between 1 and 12
	private int answer;          //variable that holds the answer to the math problem
	private String problem;      //variable that holds the string representation of the math problem

	public MathEngine(int userInput, boolean isAddSubtract) {
		userNumber = userInput;
		randomNum = getRandomInt();

		if (isAddSubtract) {
			addSubtract();
		}
		else {
			multDivide();
		}
	}

	public String getProblem() {
		return problem;
	}

	public boolean isCorrect(int userAnswer) {
		if (userAnswer == answer) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isCorrect(String userAnswer) {
		return isCorrect(Integer.parseInt(userAnswer));
	}

	public int getAnswer() {
		return answer;
	}

	private void addSubtract() {
		boolean isAddition = getRandomBool();

		if (isAddition) {
			problem = userNumber + " + " + randomNum;
			answer = userNumber + randomNum;
		}
		else {
			problem = userNumber + " - " + randomNum;
			answer = userNumber - randomNum;
		}
	}

	private void multDivide() {
		boolean isMult = getRandomBool();
		if (isMult) {
			problem = userNumber + " * " + randomNum;
			answer = userNumber * randomNum;
		}
		else {
			problem = userNumber + " / " + randomNum;
			answer = userNumber / randomNum;
		}

	}

	private boolean getRandomBool() {
		return new Random().nextBoolean();
	}

	private int getRandomInt() {
		return new Random().nextInt(12);
	}
}