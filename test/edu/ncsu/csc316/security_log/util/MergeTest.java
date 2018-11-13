/**
 * 
 */
package edu.ncsu.csc316.security_log.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ncsu.csc316.security_log.dictionary.ArrayList;
import util.Merge;

/**
 * SorterTest Class.
 * @author Sanchit Razdan
 */
public class MergeTest {
	
	/**
	 * sorterTest method. 
	 */
	@Test
	public void sorterTest() {
		ArrayList<String> list = new ArrayList<String>();
		list.insert("Surag");
		list.insert("Avani");
		list.insert("Shane");
		list.insert("Nodhit");
		list.insert("Bodhit");
		
		Merge<String> m = new Merge<String>();
		m.sort(list, 0, list.size() - 1);
		
		String s1 = "Avani";
		String s2 = "Bodhit";
		String s3 = "Nodhit";
		String s4 = "Shane";
		String s5 = "Surag";
		
		assertEquals(s1, list.get(0));
		assertEquals(s2, list.get(1));
		assertEquals(s3, list.get(2));
		assertEquals(s4, list.get(3));
		assertEquals(s5, list.get(4));
	}
}

