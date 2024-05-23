package web.service;

public class MathQuestionService {

	/**
	 * Calculate Q1 result.
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q1Addition(String number1, String number2) {
		double num1, num2;

		try {
			num1 = Double.parseDouble(number1);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("First number is not valid.");
		}

		try {
			num2 = Double.parseDouble(number2);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Second number is not valid.");
		}
		double result = num1 + num2;
		return result; 
	}

	/**
	 * Calculate Q2 result.
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q2Subtraction(String number1, String number2) {
		double num1, num2;

		try {
			num1 = Double.parseDouble(number1);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("First number is not valid.");
		}

		try {
			num2 = Double.parseDouble(number2);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Second number is not valid.");
		}
		double result = num1 - num2;
		return result;
	}

	/**
	 * Calculate Q3 result.
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q3Multiplication(String number1, String number2) {
		double num1, num2;

		try {
			num1 = Double.parseDouble(number1);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("First number is not valid.");
		}

		try {
			num2 = Double.parseDouble(number2);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Second number is not valid.");
		}
		double result = num1 * num2;
		return result;
	}
}
