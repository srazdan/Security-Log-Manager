/**
 * 
 */
package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.ArrayList;
import edu.ncsu.csc316.security_log.io.LogEntryReader;

/**
 * SecurityLogManagerTest Class
 * @author Sanchit Razdan
 */
public class SecurityLogManagerTest {
	
	private static String filePath = "input/activityLog_small.txt";
	private static String fp2 = "input/activityLog_medium.txt";
	private static String fp3 = "input/activityLog_micro.txt";
	
	
	@SuppressWarnings("rawtypes")
	private ArrayList<LogEntry> smallLogs;
	@SuppressWarnings("rawtypes")
	private ArrayList<LogEntry> medLogs;
	
	/**
	 * testSecurityLogManager test
	 * tests the constructor. 
	 */
	 @Test
	 public void testSecurityLogManager() throws FileNotFoundException{
		LogEntryReader ler = new LogEntryReader();
		smallLogs = ler.processFile(filePath);
		assertEquals(16, smallLogs.size());
	
		medLogs = ler.processFile(fp2);
		assertEquals(4096, medLogs.size());
	}
	
	
	/**
	 * generateOperationalProfile testing method 
	 */
	@Test
	public void testGenerateOperationalProfile() {
		SecurityLogManager slm = new SecurityLogManager(fp3);
		
		String s = "OperationalProfile[\n"
				+ "   view prescription information: frequency: 2, percentage: 40.0%\n"
				+ "   create immunization order: frequency: 1, percentage: 20.0%\n"
				+ "   delete demographics information: frequency: 1, percentage: 20.0%\n"
				+ "   delete prescription information: frequency: 1, percentage: 20.0%\n"
		        + "]";
		
		String s2 = "OperationalProfile[\n"
				+ "   delete demographics information: frequency: 1, percentage: 100.0%\n"
		        + "]";
		
		assertEquals(s, slm.generateOperationalProfile("01/17/2018 12:00:00AM", "01/20/2018 12:00:00PM"));
		
		assertEquals(s2, slm.generateOperationalProfile("01/17/2018 00:00:00AM", "01/18/2018 12:58:14PM"));
		
	}
	
	/**
	 * generateOperationalProfile testing method 
	 */
	@Test
	public void testGetUserReport() {
		SecurityLogManager slm = new SecurityLogManager(fp3);
		
		
		String s2 = "Activity Report for jtking[\n" + 
				"   01/18/2018 12:58:14PM - delete demographics information\n" + 
				"   01/18/2018 01:22:21PM - view prescription information\n" + 
				"]";
		
		
		assertEquals(s2, slm.getUserReport("jtking"));
	}
	                                                                	
}
