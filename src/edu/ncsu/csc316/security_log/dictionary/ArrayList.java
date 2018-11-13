/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

/**
 * ArrayBasedList class. makes an array based list from the input file. 
 * Code used from CSC 216 Pack Scheduler Util Package. 
 * @author Sanchit Razdan
 * @param <E> the type of object to be used in the list. 
 */
public class ArrayList<E> implements Dictionary<E> {
	
	/** a custom value for initializing the list size */
	private static final int INIT_SIZE = 10;
	/** an array of type E */
	private E[] list;
	/** the size of the list */
	private int size;
	/** the capacity of the array */
	private int capacity = INIT_SIZE;
	
	
	/**
	 * Constructor for custom ArrayBasedList object.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		this.size = 0;
		this.list = (E[]) new Object[INIT_SIZE];
	}
	
	/**
	 * Constructor for custom ArrayBasedList object
	 * @param cap the capacity to be set.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int cap) {
		this.size = 0;
		this.capacity = cap;
		this.list = (E[]) new Object[cap];
	}
	
	/**
	 * insertMethod. inserts an object at the end of the array based list. 
	 * @param object that is to be added at the end of the array based list. 
	 */
	@Override
	public void insert(E object) {
		add(size, object);
		
	}
	
	/**
	 * Adds the element parameter to the specific index parameter.
	 * @param index the index to add the element at
	 * @param element the element to be added
	 * @throws IndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if the element to be set is null
	 * @throws IllegalArgumentException if a duplicate element is to be added
	 */
	public void add(int index, E element) {
		
		//doubles the capacity if the size is equal to the capacity
		if (size == capacity) {
			growArray();
		}
		
		for (int i = size; i > index; i--) {
			list[i] = list[i - 1];
		}
		
		list[index] = element;
		//increases the size of the array
		size++;
	}
	
	/**
	 * growArray method. 
	 * Doubles the size of the list
	 */
	@SuppressWarnings("unchecked")
	private void growArray() {
		capacity = capacity * 2;
		E[] temp = (E[]) new Object[capacity];
		for(int i = 0; i < list.length; i++)
			temp[i] = list[i];
		list = temp;
	}
	
	/**
	 * lookUp method. 
	 * looks for an object in the array based list. 
	 * @param object that is to be found in the array based list. 
	 * @return true if it is found and false if not. 
	 */
	@Override
	public int lookUp(E object) {
		for(int i = 0; i < size; i++) {
			if(list[i].equals(object)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * size method. 
	 * @return size of the array based list. 
	 */
	@Override
	public int size() {
		return size;
	}
	
    /**
     * get method. gets the element at that index.  
     * @param i the index whose element is to be returned. 
     * @return the element at that index. 
     */
	public E get(int i) {
		return list[i];
	}
	
	/**
	 * Sets an element at the specific index.
	 * @param index the index of the element to be set
	 * @param element the new element to set
	 * @return originalElement the original element before setting
	 * @throws IndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if the element to be set is null
	 * @throws IllegalArgumentException if a duplicate element is to be set
	 */
	public E set(int index, E element) {
		E originalElement = list[index];
		list[index] = element;
		return originalElement;
	}

}
