package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class that provides test cases for the math operations of the MyMath class
 * 
 * @author Aikaterini Perikou
 *
 */
public class MyMathTest {

	/*
	 * A reference to the MyMath class whose methods are being tested in this class.
	 */
	MyMath mm;

	/*
	 * A constructor which is called when the MyMathTest class is initialized.
	 */
	public MyMathTest() {
		this.mm = new MyMath();
	}

	/*
	 * A test case for the exceptions which are caused when the input value in
	 * factorial method is negative.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorialShouldCauseAnExceptionOnNegativeInput() {
		mm.factorial(-5);
	}

	/*
	 * A test case for the exceptions which are caused when the input value in
	 * factorial method is over twelve.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorialShouldCauseAnExceptionOnOverTwelveInput() {
		mm.factorial(13);
	}

	/*
	 * A test case that examines the isPrime method with a valid prime input number.
	 */
	@Test
	public void testIsPrimeShouldReturnTrue() {
		Assert.assertEquals(true, mm.isPrime(2));
	}

	/*
	 * A test case that examines the isPrime method with a valid composite (not
	 * prime) input number.
	 */
	@Test
	public void testIsPrimeShouldReturnFalse() {
		Assert.assertEquals(false, mm.isPrime(9));
	}

	/*
	 * A test case for the exceptions which are caused when the input value in
	 * isPrime method is below two.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIsPrimeShouldCauseAnExceptionBelowTwoInput() {
		mm.isPrime(1);
	}
}
