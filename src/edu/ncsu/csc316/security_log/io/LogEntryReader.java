/**
 * 
 */
package edu.ncsu.csc316.security_log.io;

import java.io.*;
import java.util.*;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.ArrayList;

/**
 * LogEntryReader. Reads and processes the log files and stores them to be used in the program. 
 * @author Sanchit Razdan
 */
public class LogEntryReader {
	
	/**
	 * processFile method.
	 * Processes the file and puts it in an array based list of strings.  
	 * @param filePath the path to the input file. 
	 * @return the array based list of strings. 
	 * @throws FileNotFoundException if file is not found. 
	 */
	public ArrayList<LogEntry> processFile(String filePath) throws FileNotFoundException {
		ArrayList<LogEntry> logs = new ArrayList<LogEntry>();
		Scanner scan = new Scanner(new FileInputStream(filePath), "UTF8");
		scan.nextLine(); //scans the first line which is not in use. 
			while(scan.hasNextLine()) {
				LogEntry log = new LogEntry(scan.nextLine());
				logs.insert(log);
			}
		scan.close();
		return logs;
	}
}
