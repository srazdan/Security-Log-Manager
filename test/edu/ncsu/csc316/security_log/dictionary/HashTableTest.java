package edu.ncsu.csc316.security_log.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * HashTableTest Class. 
 * @author Sanchit Razdan
 */
public class HashTableTest {
	
	/**
	 * testHashTable method. 
	 * tests the hash table class and all its methods. 
	 */
	@Test
	public void testHashTable() {
		HashTable<String> ht = new HashTable<String>();
		assertEquals(0, ht.size());
		assertEquals(0, ht.getSize());
		assertEquals(200, ht.getHashTableLength());
		
		ht.setSize(1);
		assertEquals(1, ht.size());
		assertEquals(1, ht.getSize());
		
		ht.setSize(0);
		assertEquals(0, ht.size());
		assertEquals(0, ht.getSize());
		
		String sa = "sanchit";
		String bo = "bodhit";
		String su = "surag";
		String av = "avani";
		
		ht.insert(sa);
		ht.insert(bo);
		ht.insert(su);
		ht.insert(av);
		
		assertEquals(4, ht.getSize());
		assertEquals("sanchit", ht.lookUp(sa));
		
		HashTable<String> h = new HashTable<String>(1);
		h.insert(sa);
		h.insert(bo);
		
		assertEquals(2, h.getSize());
		assertEquals("sanchit", h.lookUp(sa));
	}

}
