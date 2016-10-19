package HW6;

//anything

import java.util.Random;
import java.util.Scanner;

public class MathEngine {
	
	private static int fixedNum;
	private static int randomNum;
	private static int userAnswer;
	private static int answer;
	private static String problem;
	
	public MathEngine() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		//Creates a fixed variable based on the user's input
		System.out.println("What number would you like your questions to be based on? (0 - 12): ");
		Scanner range = new Scanner(System.in);
		fixedNum = range.nextInt();
		System.out.println(fixedNum);
		
		//Create random number between 1 and 12
		int maxRange = 12;
		randomNum = (int) (Math.random() * maxRange + 1);
		System.out.println(randomNum);
		
		//Let user decide if they want to add or subtract
		System.out.println("Add/Subtract (1) or Multiply/Divide (2)?: ");
		Scanner user = new Scanner(System.in);
		int userNum = user.nextInt();
		if (userNum == 1) {
			addSubtract();
		}
		
		else if (userNum == 2) {
			multDivide();
		}
		
		System.out.println("Type your answer here: ");
		Scanner number = new Scanner(System.in);
		userAnswer = number.nextInt();
		
		getProblem();
		isCorrect();
	}
	
	public static void addSubtract() {
		
		//Random addsubInteger = new Random();
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
	
	public static void multDivide() {
		
		//Random multdivInteger = new Random;
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
	
	public static String getProblem() {
		
		//return string representation of that problem.
		return problem;
		
	}
	
	private static boolean isCorrect() {
		//returns if user's answer is true or false
		//int answer = fixedNum * randomNum;
		if (userAnswer == answer) {
			System.out.println("correct");
			return true;
		}
		
		else {
			System.out.println("incorrect");
			return false;
		}
		
	}
	
}