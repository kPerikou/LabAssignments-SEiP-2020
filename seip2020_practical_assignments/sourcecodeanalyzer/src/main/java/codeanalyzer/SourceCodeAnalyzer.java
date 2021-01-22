package codeanalyzer;

import java.io.IOException;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes. 
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison).
 *  
 * @author agkortzis
 * @author Aikaterini Perikou
 *
 */
public abstract class SourceCodeAnalyzer {
	
	protected SourceFileReader fileReader;
	
	public SourceCodeAnalyzer(SourceFileReader sfr) {
		this.fileReader = sfr;
	}
	
	/**
	 * Calculates the lines which has some specific symbols ("//", "/*","*","{","}","") in a Java source file's code
	 * @param filepath the url of the file
	 * @return an integer, the number of code lines
	 * @throws IOException
	 */
	public abstract int calculateLOC(String filepath) throws IOException;
	
	/**
	 * Calculates the methods of a Java source file's code
	 * @param filepath the url of the file
	 * @return an integer, the number of methods of the given file
	 * @throws IOException
	 */
	public abstract int calculateNOM(String filepath) throws IOException;
	
	/**
	 * Calculates the classes of a Java source file's code
	 * @param filepath the url of the file
	 * @return an integer, the number of classes of the given file
	 * @throws IOException
	 */
	public abstract int calculateNOC(String filepath) throws IOException;
	
}