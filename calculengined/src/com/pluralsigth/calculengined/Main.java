package com.pluralsigth.calculengined;


import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double leftArray[] = {1.0d, 2.0d, 3.0d, 4.0d};
		double rightArray[] = {4.0d, 5.0d, 6.0d, 7.0d};
		char opCodes[] = {'d', 'm', 's', 'a'};
		double results[] = new double[opCodes.length];

		if (args.length == 0) {
			for (int i = 0; i < opCodes.length; i++) {
				results[i] = execute(opCodes[i], leftArray[i], rightArray[i]);
			}
			for (double currentValue : results)
				System.out.println(currentValue);

		}else if(args.length == 1 && args[0].equals("interactive"))
			executeInteractively();
		else if (args.length == 3) {
			handleCommandLine(args);
		} else {
			System.out.println("please add two valid numbers and an operator");
		}
	}

	private static void handleCommandLine(String[] args) {
		char opCode = args[0].charAt(0);
		double lefVal = Double.parseDouble(args[1]);
		double rightVal = Double.parseDouble(args[2]);
		double result = execute(opCode, lefVal, rightVal);
		System.out.println(result);
	}

	static void executeInteractively(){
		System.out.println("please add two valid numbers and an operator");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		String[] parts = userInput.split(" ");
		performOperations(parts);
	}

	private static void performOperations(String[] parts) {
		char opCode = opCodeFromString(parts[0]);
		if(opCode == 'w')
			handleWhen(parts);
		else {
			double leftValue = valueFromWord(parts[1]);

			double rightValue = valueFromWord((parts[2]));

			double result = execute(opCode, leftValue, rightValue);
			displayResult(opCode, leftValue, rightValue, result);
		}
	}

	private static void handleWhen(String[] parts) {
		LocalDate startDate = LocalDate.parse(parts[1]);
		long daysToAdd = (long) valueFromWord(parts[2]);
		LocalDate newDate = startDate.plusDays(daysToAdd);
		String output = String.format(" %s plus %d days is %s", startDate, daysToAdd, newDate);
		System.out.println(output);
	}

	private static void displayResult(char opCode, double leftValue, double rightValue, double result) {
		char symbol = symbolFromOpCode(opCode);
		/*StringBuilder builder = new StringBuilder(20);
		builder.append(leftValue);
		builder.append(" ");
		builder.append(symbol);
		builder.append(" ");
		builder.append(rightValue);
		builder.append(" = ");
		builder.append(result);
		string output = builder.toString()*/

	String output =  String.format( "%.3f %c %.3f = %.3f", leftValue, symbol, rightValue, result);
	System.out.println(output);
	}

	private static char symbolFromOpCode(char opCode){
		char [] opCodes = { 'a', 's', 'm', 'd'};
		char [] symbols = {'+', '-', '*', '/'};
		char symbol = ' ';

		for(int i= 0; i < opCodes.length; i++){
			if(opCodes[i] == opCode) {
				symbol = symbols[i];
				break;
			}
			}
		return symbol;
	}

	static double execute(char opCode, double leftVal, double rightVal) {
		double result;
		switch (opCode) {
			case 'a':
				result = leftVal + rightVal;
				break;
			case 's':
				result = leftVal - rightVal;
				break;
			case 'm':
				result = leftVal * rightVal;
				break;
			case 'd':
				result = rightVal != 0 ? leftVal / rightVal : 0.0d;
				break;
			default:
				System.out.println("Invalid code" + opCode);
				result = 0.0d;
				break;

		}
		return result;
	}

	static char opCodeFromString(String operatorName) {
		char opCode = operatorName.charAt(0);
		return opCode;
	}

	;

	static double valueFromWord(String word) {
		String[] numberWords = {
				"zero", "one", "two", "three", "four",
				"five", "six", "seven", "eight", "nine"
		};
		double value = -1d;
		for (int index = 0; index < numberWords.length; index++) {
			if (word.equals(numberWords[index])) {
				value = index;
				break;
			}
			;
		}
		if(value == -1)
			value = Double.parseDouble(word);
		return value;
	}
}