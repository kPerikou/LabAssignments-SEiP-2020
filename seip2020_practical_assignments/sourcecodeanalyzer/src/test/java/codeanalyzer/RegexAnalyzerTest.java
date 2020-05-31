package codeanalyzer;

import java.io.IOException;
import org.junit.Test;

import codeanalyzer.SourceCodeAnalyzer;

import static org.junit.Assert.*;

public class RegexAnalyzerTest {
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";

	SourceFileReaderFactory sfrFactory = new SourceFileReaderFactory();
	SourceFileReader sfrLocal = sfrFactory.createSourceFileReader("local");
	SourceCodeAnalyzer scaRegex = new RegexAnalyzer(sfrLocal);

	@Test
	public void testCalculateRegexLOC() throws IOException {
		assertEquals(21, scaRegex.calculateLOC(TEST_CLASS));
	}

	@Test
	public void testCalculateRegexNOM() throws IOException {
		assertEquals(3, scaRegex.calculateNOM(TEST_CLASS));
	}

	@Test
	public void testCalculateRegexNOC() throws IOException {
		assertEquals(3, scaRegex.calculateNOC(TEST_CLASS));
	}

}
