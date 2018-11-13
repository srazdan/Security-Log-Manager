/**
 * 
 */
package edu.ncsu.csc316.security_log.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.ArrayList;

/**
 * LogEntryReaderTest class
 * @author Sanchit Razdan
 */
public class LogEntryReaderTest {
	
	String filePath = "input/activityLog_small.txt";
	String filePath2 = "input/activityLog_medium.txt";
	
	/**
	 * testProcessFile method. 
	 * tests the processFile method. 
	 */
	@Test
	public void testProcessFile() {
		ArrayList<LogEntry> logs = new ArrayList<LogEntry>();
		LogEntryReader ler = new LogEntryReader();
		
		try {
			logs = ler.processFile(filePath);
			assertEquals(16, logs.size());
		} catch (FileNotFoundException e) {
			// do nothing
		}

		try {
			logs = ler.processFile(filePath2);
			assertEquals(4096, logs.size());
		} catch (FileNotFoundException e) {
			//do nothing
		}
	}
}
