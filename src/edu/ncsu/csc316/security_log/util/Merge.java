/**
 * 
 */
package edu.ncsu.csc316.security_log.util;

import edu.ncsu.csc316.security_log.dictionary.ArrayList;

/**
 * MergeClass
 * Merges the lists. 
 * @author Sanchit Razdan
 * @param <E> the type of parameter which is used for sorting.
 */
public class Merge<E extends Comparable<E>> {
	
	/**
	 * mergeSort method.  
	 * @param users array based list used for sorting
	 * @param start start index 
	 * @param middle middle index 
	 * @param end end index 
	 */
	public void mergeSort(ArrayList<E> users, int start, int middle, int end) {
		int n = middle - start + 1;
		int n1 = end - middle;
		
		ArrayList<E> left = new ArrayList<>();
		ArrayList<E> right = new ArrayList<>();
		
        /*Copy data to temp arrays*/
        for (int i = 0; i < n; i++) {
            left.insert(users.get(start + i));
        }
        for (int j = 0; j < n1; j++) {
            right.insert(users.get(middle + 1 + j));
        }
        
        /* Merge the temp arrays */
        
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = start;
        while (i < n && j < n1) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                users.set(k, left.get(i));
                i++;
            }
            else {
                users.set(k, right.get(j));
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n)
        {
            users.set(k, left.get(i));
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n1)
        {
            users.set(k, right.get(j));
            j++;
            k++;
        }
    }
 
    /**
     * main sort method. 
     * @param users the array based list which is to be sorted. 
     * @param start the start index. 
     * @param end the end index. 
     */
    public void sort(ArrayList<E> users, int start, int end) {
        if (start < end)
        {
            // Find the middle point
            int middle = (start + end) / 2;
 
            // Sort first and second halves
            sort(users, start, middle);
            sort(users, middle + 1, end);
 
            // Merge the sorted halves
            mergeSort(users, start, middle, end);
        }
    }
}
