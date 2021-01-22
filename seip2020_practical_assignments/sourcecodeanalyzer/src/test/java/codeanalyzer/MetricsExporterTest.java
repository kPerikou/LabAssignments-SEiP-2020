package codeanalyzer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import codeanalyzer.MetricsExporter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doCallRealMethod;

public class MetricsExporterTest {
	
	@Test
	public void testExporterCsv() {
		
		MetricsExporter mex = new CsvExporter();
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		
		// generate and write the output file
		String outputFilepath = "src/test/resources/output_metrics";
		mex.writeFile(metrics, outputFilepath);
		
		// evaluate that the file exists
		File outputFile = new File(outputFilepath + ".csv");
		Assert.assertTrue(outputFile.exists());
		
		// delete the generated file
		outputFile.delete();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWriteFileWithUknownFIleType() {
		MetricsExporter mex = new NullExporter();
		mex.writeFile(null, null);
	}

}
