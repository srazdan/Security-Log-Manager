/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

/**
 * HashTable Class.
 * @author Sanchit Razdan
 * @param <E> the type of hash table. 
 */
public class HashTable<E> {
	/**
	 * size of the hash table. 
	 */
	private static final int CAP = 200;
	
	/**
	 * PHI is a number used for the golden ratio method. 
	 */
	private static final double PHI = (1 + Math.sqrt(5.0)) / 2;
	
	/**
	 * inverse of phi. 
	 */
	private static final double INPHI = 1 / PHI;
	
	/**
	 * capacity of the hash table. 
	 */
	private int capacity;
	
	/**
	 * number of elements of the hash table. 
	 */
	private int size;
	
	/**
	 * array of hash table. 
	 */
	private ArrayList<ArrayList<E>> alist;
	
	/**
	 * HashTable Constructor. 
	 */
	public HashTable() {
		this.size = 0;
		this.alist = new ArrayList<ArrayList<E>>(CAP);
		this.capacity = CAP;
	}
	
	/**
	 * HashTable Constructor. 
	 * @param cap the capacity to set. 
	 */
	public HashTable(int cap) {
		this.size = 0;
		this.alist = new ArrayList<ArrayList<E>>(cap);
		this.capacity = cap;
	}
	
	

	/**
	 * insert method. 
	 * @param object which is to be added. 
	 */
	public void insert(E object) {
		if( size / this.getHashTableLength() > 0.5) {
			rehash();
		}
		int hash = object.hashCode();
		int index = compress(hash);
		if(alist.get(index) == null) {
			alist.set(index, new ArrayList<E>());
		}
		alist.get(index).insert(object);
		size++;
	}

	/**
	 * rehash function. 
	 * rehashes the whole hash table. 
	 */
	private void rehash() {
		int cap = this.capacity;
		this.capacity = capacity * 2;
		ArrayList<ArrayList<E>> newTable = new ArrayList<ArrayList<E>>(capacity);
		for(int i = 0; i < cap; i++) {
			if(alist.get(i) != null) {
				ArrayList<E> n = alist.get(i);
				if(n != null) {
					for(int j = 0; j < n.size(); j++) {
						E object = n.get(j);
						int hash = 0;
						int index = 0;
						if(object != null ) {
							hash = object.hashCode();
							index = compress(hash);
						}
						if(newTable.get(index) == null) {
							newTable.set(index, new ArrayList<E>());
						}
						if(object != null) {
							newTable.get(index).insert(object);
						}
					}
				}
			}
		}
		this.alist = newTable;
	}

	/**
	 * lookUp method. 
	 * @param object that is to be looked up.
	 * @return E the object itself.  
	 */
	public E lookUp(E object) {
		int hash = object.hashCode();
		int index = compress(hash);
		if(alist.get(index) != null && alist.get(index).lookUp(object) != -1) {
			return alist.get(index).get(alist.get(index).lookUp(object));
		}
		return null;
	}
	
	/**
	 * compress method. 
	 * @param hashcode the hashcode representation of the object. 
	 * @return the index at which the object is to be added. 
	 */
	public int compress(int hashcode) {
		if(hashcode < 0) {
			hashcode = hashcode * -1;
		}
		double hash = hashcode * INPHI;
		int hashc = (int) hash;
		double diff = hash - hashc;
		double ind = capacity * diff;
		
		return (int) ind;
	}

	/**
	 * size method. 
	 * @return integer size of the hash table. 
	 */
	public int size() {
		return size;
	}

	/**
	 * getHashTableLength method. 
	 * @return the capacity of the hash table. 
	 */
	public int getHashTableLength() {
		return capacity;
	}

	/**
	 * getSize method. 
	 * @return the size of the hash table. 
	 */
	public int getSize() {
		return size;
	}

	/**
	 * setSize method. 
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
