package web.service;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import web.service.MathQuestionService;

public class TestMathQuestionService {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

// Question 1 Test Cases
	@Test
	public void testQuestion1TrueAdd() {
		Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
	}

	@Test
	public void testAddNumber1Empty() {
		thrown.expect(IllegalArgumentException.class); 
		MathQuestionService.q1Addition("", "2");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion1WithEmptyValues() {
		MathQuestionService.q1Addition("", "");
	}

	@Test(expected = NullPointerException.class)
	public void testQuestion1WithNullValues() {
		MathQuestionService.q1Addition(null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion1WithFirstInvalidNumber() {
		MathQuestionService.q1Addition("abc", "10.2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion1WithSecondInvalidNumber() {
		MathQuestionService.q1Addition("10.2", "xyz");
	}

	@Test
	public void testQuestion1WithNegativeNumbers() {
		double result = MathQuestionService.q1Addition("-5", "-10");
		Assert.assertEquals(-15, result, 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion1WithFirstEmptySecondValid() {
		MathQuestionService.q1Addition("", "10.2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion1WithFirstValidSecondEmpty() {
		MathQuestionService.q1Addition("10.2", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion1WithNonNumericCharacters() {
		MathQuestionService.q1Addition("12x", "3.5");
	}

	@Test
	public void testQuestion1WithLargeNumbers() {
		double result = MathQuestionService.q1Addition("1000000000", "1000000000");
		Assert.assertEquals(2000000000, result, 0.001);
	}

	// Question 2 Test Cases
	@Test(expected = IllegalArgumentException.class)
	public void testQuestion2WithEmptyValues() {
		MathQuestionService.q2Subtraction("", "");
	}

	@Test(expected = NullPointerException.class)
	public void testQuestion2WithNullValues() {
		MathQuestionService.q2Subtraction(null, null);
	}

	@Test
	public void testQuestion2WithValidNumbers() {
		double result = MathQuestionService.q2Subtraction("20.5", "10.2");
		Assert.assertEquals(10.3, result, 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion2WithFirstInvalidNumber() {
		MathQuestionService.q2Subtraction("abc", "10.2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion2WithSecondInvalidNumber() {
		MathQuestionService.q2Subtraction("10.2", "xyz");
	}

	@Test
	public void testQuestion2WithNegativeNumbers() {
		double result = MathQuestionService.q2Subtraction("-5", "-10");
		Assert.assertEquals(5, result, 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion2WithFirstEmptySecondValid() {
		MathQuestionService.q2Subtraction("", "10.2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion2WithFirstValidSecondEmpty() {
		MathQuestionService.q2Subtraction("10.2", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion2WithNonNumericCharacters() {
		MathQuestionService.q2Subtraction("12x", "3.5");
	}

	@Test
	public void testQuestion2WithLargeNumbers() {
		double result = MathQuestionService.q2Subtraction("2000000000", "1000000000");
		Assert.assertEquals(1000000000, result, 0.001);
	}
	// Question 3 Test Cases

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion3WithEmptyValues() {
		MathQuestionService.q3Multiplication("", "");
	}

	@Test(expected = NullPointerException.class)
	public void testQuestion3WithNullValues() {
		MathQuestionService.q3Multiplication(null, null);
	}

	@Test
	public void testQuestion3WithValidNumbers() {
		double result = MathQuestionService.q3Multiplication("12.5", "4");
		Assert.assertEquals(50.0, result, 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion3WithFirstInvalidNumber() {
		MathQuestionService.q3Multiplication("abc", "10");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion3WithSecondInvalidNumber() {
		MathQuestionService.q3Multiplication("10", "xyz");
	}

	@Test
	public void testQuestion3WithNegativeNumbers() {
		double result = MathQuestionService.q3Multiplication("-5", "3");
		Assert.assertEquals(-15, result, 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion3WithFirstEmptySecondValid() {
		MathQuestionService.q3Multiplication("", "10");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion3WithFirstValidSecondEmpty() {
		MathQuestionService.q3Multiplication("10", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQuestion3WithNonNumericCharacters() {
		MathQuestionService.q3Multiplication("12x", "3.5");
	}

	@Test
	public void testQuestion3WithLargeNumbers() {
		double result = MathQuestionService.q3Multiplication("1000000000", "3");
		Assert.assertEquals(3000000000.0, result, 0.001);
	}

	@Test
	public void testQuestion3WithZero() {
		double result = MathQuestionService.q3Multiplication("0", "12345.67");
		Assert.assertEquals(0.0, result, 0.001);
	}

}
