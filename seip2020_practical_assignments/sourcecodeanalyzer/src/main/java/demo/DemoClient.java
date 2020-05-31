package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.*;

public class DemoClient {

	public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";
		
		if(args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}

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
				
		MetricsExporter exporter = new MetricsExporter();
		exporter.writeFile(outputFileType, metrics, outputFilePath);
	}

}
