package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * A class that provides test cases for the file reader(readFile method) of the
 * FileIO class.
 * 
 * @author Aikaterini Perikou
 *
 */
public class FileIOTest {

	FileIO fileIO = new FileIO();
	public static String resourcesPath = "src/test/resources/";

	/*
	 * A test case that examines the readFile method with valid input file (a .txt
	 * file with only numbers).
	 */
	@Test
	public void testReadFileValidInput() {
		int[] expectedFileElements = new int[] { 1, 2, 3, 4, 5, 6 };
		String validInputFilePath = resourcesPath + "valid_input.txt";
		Assert.assertArrayEquals(expectedFileElements, fileIO.readFile(validInputFilePath));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/*
	 * A test case for the exceptions which are caused when the input file is
	 * invalid (the file doesn't exist). Testing the exception is performed with
	 * a @Rule
	 */
	@Test
	public void testReadFileInvalidInput() {
		String invalidInputFilePath = resourcesPath + "invalid_input.txt";
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		fileIO.readFile(invalidInputFilePath);
	}

	/*
	 * A test case for the exceptions which are caused when the input file is empty.
	 * Testing the exception is performed with a @Rule
	 */
	@Test
	public void testReadFileEmptyInput() {
		String emptyInputFilePath = resourcesPath + "empty_input.txt";
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		fileIO.readFile(emptyInputFilePath);
	}

	/*
	 * A test case that examines the readFile method with input file which contains
	 * invalid entries (such as strings and doubles).
	 */
	@Test
	public void testReadFileContainsInvalidEntries() {
		int[] expectedFileElements = new int[] { 1, 2, 3, 4 };
		String mixedInputFilePath = resourcesPath + "mixed_input.txt";
		Assert.assertArrayEquals(expectedFileElements, fileIO.readFile(mixedInputFilePath));
	}

}
