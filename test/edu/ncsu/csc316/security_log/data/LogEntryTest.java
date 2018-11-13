package edu.ncsu.csc316.security_log.data;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * LogEntryTest Class
 * @author Sanchit Razdan
 */
public class LogEntryTest {
	
	/**
	 * testLogEntry method.
	 * checks to see if Log Entry class is working properly. 
	 */
	@Test
	public void testLogEntry() {
		LogEntry ln = new LogEntry("jtking, 01/18/2018 01:22:21PM, view, prescription information");
		assertEquals("jtking", ln.getUsername());
		assertEquals("view", ln.getAction());
		assertEquals("prescription information", ln.getResource());
		ln.setAction("delete");
		assertEquals("delete", ln.getAction());
		ln.setResource("immunization record");
		assertEquals("immunization record", ln.getResource());
		ln.setUsername("srazdan");
		assertEquals("srazdan", ln.getUsername());
		
		try {
			ln.setAction("");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Log.", e.getMessage());
		}
		
		try {
			ln.setAction(null);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Log.", e.getMessage());
		}
		
		try {
			ln.setResource("");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Log.", e.getMessage());
		}
		
		try {
			ln.setResource(null);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Log.", e.getMessage());
		}
		
		try {
			ln.setUsername("");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Log.", e.getMessage());
		}
		
		try {
			ln.setUsername("");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Log.", e.getMessage());
		}
	}
	
	/**
	 * testCompareTo method.
	 * test the compareTo method for the log entry. 
	 */
	@Test
	public void testCompareTo() {
		LogEntry log = new LogEntry("jtking, 01/18/2018 01:22:21PM, view, prescription information");
		LogEntry l1 = new LogEntry("jtking, 02/18/2018 04:22:21PM, view, immunization information");
		LogEntry log2 = new LogEntry("mbbrown, 01/18/2018 01:23:47PM, create, immunization order");
		LogEntry log3 = new LogEntry("ssoulcrusher, 01/18/2018 01:22:21PM, view, prescription information");
		LogEntry log4 = new LogEntry("mbbrown, 01/18/2018 01:23:47PM, view, prescription information");
		LogEntry log5 = new LogEntry("srazdan, 01/18/2018 01:23:47PM, view, immunization order");
		
		assertEquals(log.hashFunction(), l1.hashFunction());
		assertEquals(-1, log.compareTo(log2));
		assertEquals(-1, log.compareTo(log3));
		assertEquals(-1, log2.compareTo(log4));
		assertEquals(-1, log5.compareTo(log4));
		
	}
}
