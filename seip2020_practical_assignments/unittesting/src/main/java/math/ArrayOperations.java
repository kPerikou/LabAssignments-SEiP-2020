package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

/**
 * ArrayOperations class provides array operations for demonstrating Unit
 * Testing.
 * 
 * @author Aikaterini Perikou
 *
 */
public class ArrayOperations {

	/**
	 * Returns all the prime numbers from a given file
	 * 
	 * @param fileIo the class that reads the file and returns an integer array with its contents
	 * @param filepath the file that contains a list of numbers
	 * @param myMath the file that checks whether each number from the file is prime or not
	 * @return an integer array that contains the numbers that are prime
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {

		// reads a file with numbers in the filepath location by using readFile method
		int[] numbers = fileIo.readFile(filepath);

		/*
		 * Declares a String ArrayList and fill it with all the elements included in the
		 * array numbers
		 */
		List<String> primeNumbers = new ArrayList<>();
		for (int number : numbers) {
			if (myMath.isPrime(number)) {
				primeNumbers.add(String.valueOf(number));
			}
		}

		/*
		 * Declare an integer array and fill it with all the elements included in the
		 * ArrayList primeNumbers
		 */
		int[] primeNumbersArray = new int[primeNumbers.size()];
		for (int i = 0; i < primeNumbersArray.length; i++) {
			primeNumbersArray[i] = Integer.parseInt(primeNumbers.get(i));

		}

		// returns the integer array which contains only the prime numbers
		return primeNumbersArray;

	}

}
