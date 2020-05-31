package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SourceFileAnalyzer {

	public void operations(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation,
			String outputFilePath, String outputFileType) throws IOException {
		
		SourceFileReaderFactory sfrFactory = new SourceFileReaderFactory();
		SourceFileReader sfr = sfrFactory.createSourceFileReader(sourceFileLocation);
	
		SourceCodeAnalyzer sca = null;
		if (sourceCodeAnalyzerType.contentEquals("regex")) {
			sca = new RegexAnalyzer(sfr);
		} else if (sourceCodeAnalyzerType.contentEquals("strcomp")) {
			sca = new StrCompAnalyzer(sfr);
		} 
	
		int loc = sca.calculateLOC(filepath);
		int nom = sca.calculateNOM(filepath);
		int noc = sca.calculateNOC(filepath);
		
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",loc);
		metrics.put("nom",nom);
		metrics.put("noc",noc);
			
		MetricsExporterFactory meFactory = new MetricsExporterFactory();
		MetricsExporter me = meFactory.createMetricsExporter(outputFileType);	
		me.writeFile(metrics, outputFilePath);
	}

}
