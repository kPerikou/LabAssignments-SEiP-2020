package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class SourceFileReaderFactoryTest {

	@Test
	public void LocalFileReaderFactorytest() {
		SourceFileReaderFactory sfrFactory = new SourceFileReaderFactory();
		SourceFileReader sfr = sfrFactory.createSourceFileReader("local"); 
		Assert.assertTrue(sfr instanceof LocalSourceFileReader);
	}
	
	@Test
	public void WebFileReaderFactorytest() {
		SourceFileReaderFactory sfrFactory = new SourceFileReaderFactory();
		SourceFileReader sfr = sfrFactory.createSourceFileReader("web"); 
		Assert.assertTrue(sfr instanceof WebSourceFileReader);
	}
	
	@Test
	public void NullFileReaderFactoryTest() {
		SourceFileReaderFactory sfrFactory = new SourceFileReaderFactory();
		SourceFileReader sfr = sfrFactory.createSourceFileReader(""); 
		Assert.assertTrue(sfr instanceof NullSourceFileReader);
		
	}

}
