package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class MetricsExporterFactoryTest {

	@Test
	public void CsvExporterFactoryTest() {
		MetricsExporterFactory meFactory = new MetricsExporterFactory();
		MetricsExporter csvExporter = meFactory.createMetricsExporter("csv"); 
		Assert.assertTrue(csvExporter instanceof CsvExporter);
	}
	
	@Test
	public void NullExporterFactoryTest() {
		MetricsExporterFactory meFactory = new MetricsExporterFactory();
		MetricsExporter csvExporter = meFactory.createMetricsExporter("Unknown type");
		Assert.assertTrue(csvExporter instanceof NullExporter);
		
	}

}
