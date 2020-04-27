package math;

/**
 * MyMath class provides math operations for demonstrating Unit Testing.
 * 
 * @author Aikaterini Perikou
 *
 */
public class MyMath {

	/**
	 * This method performs the factorial of an input positive integer number.
	 * Particularly, it calculates the product of all the integers between 1 and the
	 * given number. Numbers over twelve and under zero cause an
	 * {@link IllegalArgumentException}
	 * 
	 * @param n the integer input number
	 * @return an integer number which is the factorial of the input number
	 * @exception IllegalArgumentException when input number is below zero or over twelve
	 */
	public int factorial(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0 || n > 12) {
			throw new IllegalArgumentException("n should be >= 0 and <= 12");
		} else {
			return (n * factorial(n - 1));
		}
	}

	/**
	 * This method receives an integer number and returns if it is prime or
	 * composite(not prime). Numbers below two cause an
	 * {@link IllegalArgumentException}
	 * 
	 * @param n the integer input number
	 * @return true if n is prime, false otherwise
	 * @exception IllegalArgumentException when n is below two
	 */
	public boolean isPrime(int n) {
		if (n < 2) {
			throw new IllegalArgumentException("n should be >= 2");
		} else {
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
