/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * ArrayListTest class. tests the ArrayList class.  
 * Code used from CSC 216 Pack Scheduler Util Package. 
 * @author Sanchit Razdan
 */
public class ArrayListTest {
	
	/**
	 * Tests ArrayList constructor
	 */
	@Test
	public void testArrayListConstructor() {
		ArrayList<String> al = new ArrayList<String>();
		assertEquals(0, al.size());
	}
	
	/**
	 * tests the lookUp method 
	 */
	@Test
	public void testLookUp() {
		ArrayList<String> al = new ArrayList<String>();
		al.add(0, "dog");
		al.add(1, "mouse");
		al.add(2, "pumpkin");
		al.add(3, "boo");
		al.add(4, "spooky");
		
		assertEquals(0, al.lookUp("dog"));
		assertEquals(-1, al.lookUp("Hello World!"));
	}
	
	/**
	 * tests add()
	 */
	@Test
	public void testAdd() {
		
		//creates a new array list
		ArrayList<String> al = new ArrayList<String>();
		assertEquals(0, al.size());
		
		
		//tests adding an element to the beginning
		al.add(0, "Hello world!");
		assertEquals("Hello world!", al.get(0));
		assertEquals(1, al.size());
		
		//tests adding an element to the end
		al.add(1, "cat");
		assertEquals("cat", al.get(1));
		assertEquals(2, al.size());
		
		//tests adding an element to the middle
		al.add(1, "cats");
		assertEquals("cats", al.get(1));
		assertEquals(3, al.size());
		
		
		//fills the current ArrayList capacity
		al.add(3, "dog");
		al.add(4, "mouse");
		al.add(5, "pumpkin");
		al.add(6, "boo");
		al.add(7, "dogs");
		al.add(8, "spooky");
		al.add(9, "skeleton");
		
		//tests that the capacity doubles when the ArrayList is "full"
		assertEquals(10, al.size());
		try { 
			for (int i = 0; i < 20; i++ ) {
			//accessing each element
			}
		} catch (ArrayIndexOutOfBoundsException error) {
			fail();
		}
		
		//tests that adding at an index out of bounds throws an exception
		try {
			al.add(-1, "ghost");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(10, al.size());
		}
		
		try {
			al.add(100, "ghost");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(10, al.size());
		}
	}
	
	/**
	 * Test set()
	 */
	@Test
	public void testSet() {
		//creates a new array list
		ArrayList<String> al = new ArrayList<String>();
		
		al.add(0, "dog");
		al.add(1, "mouse");
		al.add(2, "pumpkin");
		al.add(3, "boo");
		al.add(4, "spooky");
		
		//tests setting a valid element
		assertEquals("pumpkin", al.set(2, "new stuff"));
		assertEquals("dog", al.get(0));
		assertEquals("mouse", al.get(1));
		assertEquals("new stuff", al.get(2));
		assertEquals("boo", al.get(3));
		assertEquals("spooky", al.get(4));
		
		//tests setting at an invalid index
		try {
			al.set(-1, "about");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals("dog", al.get(0));
			assertEquals("mouse", al.get(1));
			assertEquals("new stuff", al.get(2));
			assertEquals("boo", al.get(3));
			assertEquals("spooky", al.get(4));
		}
		
	}
	
	/**
	 * Test get()
	 */
	@Test
	public void testGet() {
		//creates a new array list
		ArrayList<String> al = new ArrayList<String>();
		
		al.add(0, "dog");
		al.add(1, "mouse");
		al.add(2, "pumpkin");
		al.add(3, "boo");
		al.add(4, "spooky");
		
		//tests getting an element at a valid index
		assertEquals(al.get(0), "dog");
		
		//tests getting an element at an invalid index
		try {
			al.get(-1);
			fail();
		} catch(IndexOutOfBoundsException e) {
			//skip
		}
		
	}

}
