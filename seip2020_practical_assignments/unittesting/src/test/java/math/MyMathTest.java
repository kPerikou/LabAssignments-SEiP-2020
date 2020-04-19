package math;

import org.junit.Test;

/**
 * A class that provides test cases for the math operations of the MyMath class
 * 
 * @author Aikaterini Perikou
 *
 */
public class MyMathTest {

	/*
	 * A reference to the MyMath class whose method is being tested in this class.
	 */
	MyMath mm;

	/*
	 * A constructor which is called when the MyMathTest class is initialized.
	 */
	public MyMathTest() {
		this.mm = new MyMath();
	}

	/*
	 * A test case for the exceptions which are caused when the input value is
	 * negative.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorialShouldCauseAnExceptionOnNegativeInput() {
		mm.factorial(-5);
	}

	/*
	 * A test case for the exceptions which are caused when the input value is over
	 * twelve.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorialShouldCauseAnExceptionOnOverTwelveInput() {
		mm.factorial(13);
	}

}
