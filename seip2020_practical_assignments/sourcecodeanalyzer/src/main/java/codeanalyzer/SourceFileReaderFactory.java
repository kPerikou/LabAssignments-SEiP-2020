package codeanalyzer;

public class SourceFileReaderFactory {
	
	public SourceFileReader createSourceFileReader(String sourceFileLocation) {
		SourceFileReader sfr;
		if (sourceFileLocation.contentEquals("local")) {
			sfr = new LocalSourceFileReader();
		} else if (sourceFileLocation.contentEquals("web")) {
			sfr = new WebSourceFileReader();	
		} else {
			sfr = new NullSourceFileReader();
		}
		return sfr;
	}
}
