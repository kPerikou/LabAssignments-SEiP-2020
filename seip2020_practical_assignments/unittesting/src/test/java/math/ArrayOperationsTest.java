package math;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import io.FileIO;

/**
 * A class that provides test cases for the array operations of the
 * ArrayOperations class.
 * 
 * @author Aikaterini Perikou
 *
 */
public class ArrayOperationsTest {

	/*
	 * A test case that examines the findPrimesInFile method. Because this method
	 * uses the isPrime method from MyMath class and the readFile method from FileIO
	 * class, we mock these external dependencies (MyMath, FileIO), in order to
	 * isolate them, and predefine the results of the calls that will be executed.
	 */
	@Test
	public void testfindPrimesInFile() {

		// Mock the FileIO dependency
		FileIO fileio = mock(FileIO.class);
		String path = "src/test/resources/valid_elements.txt";

		// Define return value for method readFile
		when(fileio.readFile(path)).thenReturn(new int[] { 2, 3, 4, 5, 6, 24, 23, 9, 7 });

		// Mock the MyMath dependency
		MyMath mm = mock(MyMath.class);

		// Define return values for method isPrime
		when(mm.isPrime(2)).thenReturn(true);
		when(mm.isPrime(3)).thenReturn(true);
		when(mm.isPrime(4)).thenReturn(false);
		when(mm.isPrime(5)).thenReturn(true);
		when(mm.isPrime(6)).thenReturn(false);
		when(mm.isPrime(24)).thenReturn(false);
		when(mm.isPrime(23)).thenReturn(true);
		when(mm.isPrime(9)).thenReturn(false);
		when(mm.isPrime(7)).thenReturn(true);

		ArrayOperations arop = new ArrayOperations();
		int[] expected = { 2, 3, 5, 23, 7 };
		int[] actuals = arop.findPrimesInFile(fileio, path, mm);

		Assert.assertArrayEquals(expected, actuals);

	}
}
