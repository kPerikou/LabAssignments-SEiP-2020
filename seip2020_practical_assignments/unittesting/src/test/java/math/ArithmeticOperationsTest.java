package math;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import math.ArithmeticOperations;

/**
 * A class that provides test cases for the math operations (division and
 * multiplication) of the ArithmeticOperations class.
 * 
 * @author Aikaterini Perikou
 *
 */
public class ArithmeticOperationsTest {

	private static final double DELTA = 1e-15;

	/*
	 * A reference to the ArithmeticOperations class whose methods are being tested
	 * in this class.
	 */
	ArithmeticOperations arop;

	/*
	 * A constructor which is called when the ArithmeticOperationsTest class is
	 * initialized.
	 */
	public ArithmeticOperationsTest() {
		this.arop = new ArithmeticOperations();
	}

	/*
	 * A test case that examines the divide method with normal input values
	 * (denominator not equal to zero)
	 */
	@Test
	public void testDivideNormal() {
		Assert.assertEquals(2.0, arop.divide(10.0, 5.0), DELTA);
	}
	
	/*
	 * A test case that examines the divide method with numerator equal to zero.
	 */
	@Test
	public void testDivideShouldReturnZeroOnZeroNumerator() {
		Assert.assertEquals(0, arop.divide(0, 5.0), DELTA);
	}

	/*
	 * A test case for the exceptions which are caused when the input value for
	 * denominator is zero.
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivideShouldThrowExceptionOnZeroDenominator() {
		arop.divide(5, 0);
	}

	/*
	 * A test case that examines the multiply method with normal input values
	 */
	@Test
	public void testMultiplyNormal() {
		Assert.assertEquals(50, arop.multiply(5, 10), DELTA);
	}

	/*
	 * A test case that examines the multiply method with input y equal to zero
	 */
	@Test
	public void testMultiplyShouldReturnZeroOnZeroInputY() {
		Assert.assertEquals(0, arop.multiply(5, 0), DELTA);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/*
	 * A test case for the exceptions which are caused when the input x in the
	 * multiply method is negative. Testing the exception is performed with a @Rule
	 */
	@Test
	public void testMultiplyShouldThrowExceptionOnNegativeInputX() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		arop.multiply(-5, 4);
	}

	/*
	 * A test case for the exceptions which are caused when the input y in the
	 * multiply method is negative. Testing the exception is performed with a @Rule
	 */
	@Test
	public void testMultiplyShouldThrowExceptionOnNegativeInputY() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		arop.multiply(4, -5);
	}

	/*
	 * A test case for the exceptions which are caused when the result of
	 * multiplication doesn't fit in an Integer variable. Testing the exception is
	 * performed with a @Rule
	 */
	@Test
	public void testMultiplyShouldThrowExceptionOverflow() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		arop.multiply(200000, 300000);
	}

}
