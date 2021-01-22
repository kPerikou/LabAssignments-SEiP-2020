package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Exports (writes) the metrics to a given output. The output can be CSV or JSON
 * files.
 * 
 * @author agkortzis
 * @author Aikaterini Perikou
 */

public interface MetricsExporter {

	/**
	 * Exports the metrics into a file
	 * 
	 * @param Map<String,
	 *            Integer> metrics, which contains the number of lines, the number
	 *            of methods and the number of classes of a given file
	 * @param filepath
	 *            the url of the file
	 */
	public void writeFile(Map<String, Integer> metrics, String filepath);
}

/**
 * Exports (writes) the metrics to a given output. The output can be CSV files.
 * 
 * @author agkortzis
 * @author Aikaterini Perikou
 */
class CsvExporter implements MetricsExporter {

	/**
	 * Exports the metrics into a CSV file
	 * 
	 * @param Map<String,
	 *            Integer> metrics, which contains the number of lines, the number
	 *            of methods and the number of classes of a given file
	 * @param filepath
	 *            the url of the file
	 */
	@Override
	public void writeFile(Map<String, Integer> metrics, String filepath) {
		File outputFile = new File(filepath + ".csv");
		StringBuilder metricsNames = new StringBuilder();
		StringBuilder metricsValues = new StringBuilder();

		for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
			metricsNames.append(entry.getKey() + ",");
			metricsValues.append(entry.getValue() + ",");
		}

		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.append(metricsNames + "\n");
			writer.append(metricsValues + "\n");
			writer.close();
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}


class NullExporter implements MetricsExporter {
	
	@Override
	public void writeFile(Map<String, Integer> metrics, String filepath) {
		throw new IllegalArgumentException("Unknown ouptut file type");
	}
}