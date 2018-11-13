/**
 * 
 */
package edu.ncsu.csc316.security_log.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TimeStampTest class
 * @author Sanchit Razdan
 */
public class TimeStampTest {
	
	/**
	 * testTimeStamp method
	 * tests to check whether the time stamp class works properly. 
	 */
	@Test
	public void testTimeStamp() {
		TimeStamp time = new TimeStamp("01/18/2018 01:22:21PM");
		assertEquals(1, time.getMonth());
		assertEquals(18, time.getDate());
		assertEquals(2018, time.getYear());
		assertEquals("01/18/2018 01:22:21PM", time.getTimeStamp());
		assertEquals(1, time.getHours());
		assertEquals(22, time.getMins());
		assertEquals(21, time.getSecs());
		assertEquals("PM", time.getTimeOfDay());
		
		time.setMonth(4);
		assertEquals(4, time.getMonth());
		time.setDate(4);
		assertEquals(4, time.getDate());
		time.setYear(2017);
		assertEquals(2017, time.getYear());
		time.setHours(4);
		assertEquals(4, time.getHours());
		time.setMins(40);
		assertEquals(40, time.getMins());
		time.setSecs(4);
		assertEquals(4, time.getSecs());
		time.setTimeOfDay("PM");
		assertEquals("PM", time.getTimeOfDay());
		time.setTimeStamp("01/18/2018 1:23:47PM");
		assertEquals("01/18/2018 1:23:47PM", time.getTimeStamp());
		
		try {
			time.setMonth(-1);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setMonth(14);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setDate(-1);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setMonth(4);
			time.setDate(31);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setMonth(1);
			time.setDate(32);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setYear(1600);
			time.setMonth(2);
			time.setDate(32);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setYear(1601);
			time.setMonth(2);
			time.setDate(32);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setYear(-1);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setHours(-1);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setHours(13);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setMins(-1);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setMins(70);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setSecs(-1);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
		
		try {
			time.setSecs(80);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid Time Stamp", e.getMessage());
		}
	}
	
	/**
	 * testToCompare
	 * tests the compareTo method. 
	 */
	@Test
	public void testToCompare() {
		TimeStamp t1 = new TimeStamp("01/18/2018 01:22:21PM");
		TimeStamp t2 = new TimeStamp("01/18/2018 01:23:47PM");
		TimeStamp t3 = new TimeStamp("01/18/2018 01:22:01PM");
		TimeStamp t4 = new TimeStamp("01/18/2018 01:24:21PM");
		
		assertEquals(-1, t1.compareTo(t2));
		assertEquals(-1, t2.compareTo(t4));
		assertEquals(1, t4.compareTo(t3));
	}
	/**
	 * testToString method. 
	 * tests the toString method for the TimeStamp object. 
	 */
	@Test
	public void testToString() {
		TimeStamp t1 = new TimeStamp("01/18/2018 01:22:21PM");
		TimeStamp t2 = new TimeStamp("01/18/2018 01:23:47PM");
		TimeStamp t3 = new TimeStamp("01/18/2018 01:22:01PM");
		TimeStamp t4 = new TimeStamp("01/18/2018 01:24:21PM");
		
		assertEquals("01/18/2018 01:22:21PM", t1.toString());
		assertEquals("01/18/2018 01:23:47PM", t2.toString());
		assertEquals("01/18/2018 01:22:01PM", t3.toString());
		assertEquals("01/18/2018 01:24:21PM", t4.toString());
	}
	
	/**
	 * testToString method. 
	 * tests the toString method for the TimeStamp object. 
	 */
	@Test
	public void testEquals() {
		TimeStamp t1 = new TimeStamp("01/18/2018 01:22:21PM");
		TimeStamp t2 = new TimeStamp("01/18/2018 01:22:21PM");
		TimeStamp t3 = new TimeStamp("01/18/2018 01:22:01PM");
		TimeStamp t4 = new TimeStamp("01/18/2018 01:24:21PM");
		
		assertTrue("01/18/2018 01:22:21PM", t1.equals(t2));
		assertFalse("01/18/2018 01:23:47PM", t2.equals(t3));
		assertFalse("01/18/2018 01:22:01PM", t3.equals(t4));
		assertFalse("01/18/2018 01:24:21PM", t4.equals(t1));
	}
	
	/**
	 * testToString method. 
	 * tests the toString method for the TimeStamp object. 
	 */
	@Test
	public void testHascode() {
		TimeStamp t1 = new TimeStamp("01/18/2018 01:22:21PM");
		TimeStamp t2 = new TimeStamp("01/18/2018 01:22:21AM");
		
		assertEquals(587085279, t1.hashCode());
		assertEquals(587070864, t2.hashCode());
	}
}
