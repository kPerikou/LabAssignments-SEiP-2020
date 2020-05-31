package codeanalyzer;

public class MetricsExporterFactory {

	public MetricsExporter createMetricsExporter(String outputFileType) {
		MetricsExporter exporter;
		if (outputFileType.contentEquals("csv")) {
			exporter = new CsvExporter();
		} else {
			exporter = new NullExporter();
		}
		return exporter;
	}
}
