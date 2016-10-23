package HW6;

import java.util.Random;
import java.util.Scanner;

public class MathEngine {

	private int userNumber;
	private int randomNum;
	private int userAnswer;
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
	
	public int getAnswer(){
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

	private boolean getRandomBool(){
		return new Random().nextBoolean();
	}
	private int getRandomInt() {
		return new Random().nextInt(12);
	}
	
	public static void main(String[] args){
		MathEngine m = new MathEngine(6, true);
		String p = m.getProblem();
		
	}

}