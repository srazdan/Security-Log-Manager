/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

/**
 * List interface. Interface used to make the array list. 
 * @author Sanchit Razdan
 * @param <E> the type of object used in the interface
 */
public interface Dictionary<E> {
	
	/**
	 * insert method. inserts an object in the array list at the very end of the list. 
	 * @param object the object to be added in the array list. 
	 */
	public void insert(E object);
	
	/**
	 * lookUp method. finds an object in the array list. 
	 * @param object the object to be found in the array list. 
	 * @return true if the object is present in the array list and false if not. 
	 */
	public int lookUp(E object);
	
	/**
	 * size method. gives the size of the array list. 
	 * @return size of the array list. 
	 */
	public int size();

}
