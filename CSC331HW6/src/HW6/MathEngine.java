package HW6;

import java.util.Random;
import java.util.Scanner;

public class MathEngine {

	private int fixedNum;
	private int randomNum;
	private int userAnswer;
	private int answer;
	private String problem;

	public MathEngine(int fixedNum, boolean isAddSubtract) {

		randomNum = getRandomNum();

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
	
	private void addSubtract() {
		int addsubInteger = (int) (Math.random() * 2 + 1);
		System.out.println(addsubInteger);

		if (addsubInteger == 1) {
			System.out.println(fixedNum + " + " + randomNum);
			problem = fixedNum + " + " + randomNum;
			answer = fixedNum + randomNum;
		}

		else {
			System.out.println(fixedNum + " - " + randomNum);
			problem = fixedNum + " - " + randomNum;
			answer = fixedNum - randomNum;
		}

	}

	private void multDivide() {

		int multdivInteger = (int) (Math.random() * 2 + 1);
		System.out.println(multdivInteger);

		if (multdivInteger == 1) {
			System.out.println(fixedNum + " * " + randomNum);
			problem = fixedNum + " * " + randomNum;
			answer = fixedNum * randomNum;
		}

		else {
			System.out.println(fixedNum + " / " + randomNum);
			problem = fixedNum + " / " + randomNum;
			answer = fixedNum / randomNum;
		}

	}

	private int getRandomNum() {

		return (int) (Math.random() * 12 + 1);

	}

}