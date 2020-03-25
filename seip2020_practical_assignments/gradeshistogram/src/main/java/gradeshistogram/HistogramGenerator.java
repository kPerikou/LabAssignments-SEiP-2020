package gradeshistogram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * The HistogramGenerator program implements an application that reads a file
 * from the user and generates a grades' histogram
 * 
 * @author Aikaterini Perikou
 *
 */
public class HistogramGenerator {

	/**
	 * This method is used to generate the chart. It is called from the main method
	 * and getting as a parameter a single dimension array filled with values
	 * (grades).
	 * 
	 * @param dataValues
	 *            a single dimension integer array (this is the parameter to
	 *            generateChart method)
	 */
	public void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that can be
		 * visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();

		/*
		 * The XYSeries that are loaded in the dataset. There might be many series in
		 * one dataset.
		 */
		XYSeries data = new XYSeries("grades");

		// find the highest grade from input Integer array
		int maxValue = dataValues[0];
		for (int i = 1; i < dataValues.length; i++) {
			if (dataValues[i] > maxValue) {
				maxValue = dataValues[i];
			}
		}

		/*
		 * Declare a boolean array with as many elements as the input Integer
		 * array(dataValues). This array will be used in order not to revisit an element
		 * (grade) from the input Integer array that has already been checked.
		 */
		boolean[] visited = new boolean[dataValues.length];

		// sets all the elements of the visited array into false
		Arrays.fill(visited, false);

		/*
		 * Count the frequency of each element(grade) from the input Integer
		 * array(dataValues)
		 */
		for (int i = 0; i < dataValues.length; i++) {
			if (visited[i] == true)
				continue;// the grade has been already checked, continue to the next element(grade)

			// Declare and initialize the frequency variable
			int frequency = 1;

			/*
			 * Compares the current element (grade) with the other elements from the input
			 * Integer array. If it is equal to another element the frequency variable
			 * increases by one and the respective index on the visited Array is set as
			 * true.
			 */
			for (int j = i + 1; j < dataValues.length; j++) {
				if (dataValues[i] == dataValues[j]) {
					visited[j] = true;
					frequency++;
				}
			}

			/*
			 * Populating the XYSeries data object from the input Integer array values with
			 * the frequency of each.
			 */
			data.add(dataValues[i], frequency);
		}

		/*
		 * Filling the XYSeries data object with elements(grades) that doesn't exist in
		 * the input Integer array and are below the maxValue (the highest grade in the
		 * input integer array)
		 */
		for (int i = 0; i <= maxValue; i++) {
			boolean exist = false;
			for (int j = 0; j < dataValues.length; j++) {
				if (i == dataValues[j]) {
					exist = true;
				}
			}
			if (exist == false)
				if (i <= maxValue)
					data.add(i, 0);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grades", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		XYPlot plot = chart.getXYPlot();

		// Makes the background white
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		// Makes visible black horizontal lines
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		// Makes visible black vertical lines
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("Grades Histogram", chart);
		frame.pack();

		// makes the previously created frame visible
		frame.setVisible(true);
	}

	/**
	 * This is the main method which makes use of generateChart method. Reads from
	 * the user a file with grades and calls a method in order to generate the chart.
	 * 
	 * @param args  command line arguments
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		try {
			if (args.length > 0) {
				Scanner file = new Scanner(new File(args[0]));
				ArrayList<String> grades = new ArrayList<>();

				/*
				 * Reads each line from the input file and adds the element into the ArrayList
				 * grades
				 */
				while (file.hasNext()) {
					String grade = file.nextLine();
					grades.add(grade);
				}

				// close the input file
				file.close();

				/*
				 * Declare an integer array and fill it with all the elements included in the
				 * ArrayList grades
				 */
				int[] arrayGrades = new int[grades.size()];
				for (int i = 0; i < arrayGrades.length; i = i + 1) {
					arrayGrades[i] = Integer.parseInt(grades.get(i));
				}

				HistogramGenerator demo = new HistogramGenerator();

				// calling generateChart method
				demo.generateChart(arrayGrades);
			} else {
				throw new FileNotFoundException();
			}
		} catch (FileNotFoundException e) {
			// an exception occurred
			System.out.println("File not found. Please add a .txt file with grades.");
		}
	}
}
