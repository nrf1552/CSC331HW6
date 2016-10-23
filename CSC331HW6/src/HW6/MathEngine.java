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

		// return string representation of that problem.
		return problem;
	}

	public boolean isCorrect(int userAnswer) {
		// returns if user's answer is true or false
		if (userAnswer == answer) {
			System.out.println("correct");
			return true;
		}

		else {
			System.out.println("incorrect");
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

		int multdivInteger = (int) (Math.random() * 2 + 1);
		System.out.println(multdivInteger);

		if (multdivInteger == 1) {
			System.out.println(userNumber + " * " + randomNum);
			problem = userNumber + " * " + randomNum;
			answer = userNumber * randomNum;
		}

		else {
			System.out.println(userNumber + " / " + randomNum);
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