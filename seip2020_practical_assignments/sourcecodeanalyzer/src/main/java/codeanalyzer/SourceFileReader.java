package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Retrieves (reads) the contents of a given file.
 * The file can be stored locally or exist on the web.
 * 
 * @author agkortzis
 * @author Aikaterini Perikou
 *
 */
public interface SourceFileReader {
	
	/**
	 * Reads a file and returns its content in a List 
	 * @param filepath the url of the file
	 * @return a List that contains the contents of the file 
	 * @throws IOException
	 */
	public List<String> readFileIntoList(String filepath) throws IOException;
	
	/**
	 * Reads a file and returns its content in a single String 
	 * @param filepath the url of the file
	 * @return a String that contains the contents of the file
	 * @throws IOException
	 */
	public String readFileIntoString(String filepath) throws IOException;

}


class LocalSourceFileReader implements SourceFileReader {

	/**
	 * Reads a local file and returns its content in a List 
	 * @param filepath the url of the file
	 * @return a List that contains the contents of the file 
	 * @throws IOException
	 */
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		// read a locally stored file
		List<String> lines = new ArrayList<>();
		File file = new File(filepath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		reader.close();
		return lines;
	}
	
	/**
	 * Reads a local file and returns its content in a single String 
	 * @param filepath the url of the file
	 * @return a String that contains the contents of the file
	 * @throws IOException
	 */
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		// read a locally stored file
		StringBuilder sb = new StringBuilder();
		File file = new File(filepath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		reader.close();
		return sb.toString();
	}
}

class WebSourceFileReader implements SourceFileReader {
	
	/**
	 * Reads a web file and returns its content in a single String 
	 * @param filepath the url of the file
	 * @return a List that contains the contents of the file 
	 * @throws IOException
	 */	
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		List<String> lines = new ArrayList<>();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
        	lines.add(line);
        }
        reader.close();
		return lines;
	}
	
	/**
	 * Reads a web file and returns its content in a single String 
	 * @param filepath the url of the file
	 * @return a String that contains the contents of the file
	 * @throws IOException
	 */
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		StringBuilder sb = new StringBuilder();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
        	sb.append(line + "\n");
        }
        reader.close();
		return sb.toString();
	}
	
}

class NullSourceFileReader implements SourceFileReader {
	
	/**
	 * Reads a file in case there is neither stored locally nor on the web and returns a message error. 
	 * @param filepath the url of the file
	 * @return null
	 * @throws IOException
	 */
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		System.err.println("Operation aborted due to unknown source file");
		return null;
	}
	
	/**
	 * Reads a file in case there is neither stored locally nor on the web and returns a message error. 
	 * @param filepath the url of the file
	 * @return null
	 * @throws IOException
	 */
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		System.err.println("Operation aborted due to unknown source file");
		return null;
	}
}


