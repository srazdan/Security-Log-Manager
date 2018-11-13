/**
 * 
 */
package edu.ncsu.csc316.security_log.data;

/**
 * OperationalProfile class
 * @author Sanchit Razdan
 * @param <E> the type of parameter used for the operational profile. 
 */
public class OperationalProfile<E> implements Comparable<OperationalProfile> {
	
	/** action of the log entry */
	private String function;
	
	/** frequency of the log entry */
	private int frequency;
	
	/**
	 * OperationalProfile constructor. 
	 * @param function the function of the log entry. 
	 * @param frequency the frequcny of the log entry. 
	 */
	public OperationalProfile(String function, int frequency) {
		setFunction(function);
		setFrequency(frequency);
	}

	/**
	 * getFunction method. 
	 * @return the function
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * setFunction method. 
	 * @param function the function to set
	 */
	public void setFunction(String function) {
		this.function = function;
	}

	/**
	 * getFrequency method. 
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * setFrequency method. 
	 * @param frequency the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * compareTo method. 
	 * @param o the other operational profile to be compared to. 
	 * @return 0 if this operational profile and the other profile are same, -1 if this profile comes before
	 * and 1 if it comes after the other profile. 
	 */
	@Override
	public int compareTo(OperationalProfile o) {
		if(this.getFrequency() < o.getFrequency()) {
			return 1;
		} else if(this.getFrequency() > o.getFrequency()) {
			return -1;
		}  else if(this.getFunction().compareTo(o.getFunction()) > 0) {
			return 1; 
		} else if(this.getFunction().compareTo(o.getFunction()) < 0) {
			return -1;
		}
		return 0;
	}

}
