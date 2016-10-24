package HW6;

import java.util.Random;

public class MathEngine {

	private int userNumber;
	private int randomNum;
	private int answer;
	private String problem;

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
		if(userAnswer.isEmpty()){
			return false;
		}
		else{
			return isCorrect(Integer.parseInt(userAnswer));			
		}
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