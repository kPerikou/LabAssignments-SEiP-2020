package codeanalyzer;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;

public class StrCompAnalyzerTest {

	private final static String TEST_CLASS = "src/test/resources/TestClass.java";

	SourceFileReaderFactory sfrFactory = new SourceFileReaderFactory();
	SourceFileReader sfrLocal = sfrFactory.createSourceFileReader("local");
	SourceCodeAnalyzer scaStrComp = new StrCompAnalyzer(sfrLocal);

	@Test
	public void testCalculateStrCompLOC() throws IOException {
		assertEquals(7, scaStrComp.calculateLOC(TEST_CLASS));
	}

	@Test
	public void testCalculateStrCompNOM() throws IOException {
		assertEquals(3, scaStrComp.calculateNOM(TEST_CLASS));
	}

	@Test
	public void testCalculateStrCompNOC() throws IOException {
		assertEquals(3, scaStrComp.calculateNOC(TEST_CLASS));
	}

}
