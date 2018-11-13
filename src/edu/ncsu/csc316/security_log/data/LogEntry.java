/**
 * 
 */
package edu.ncsu.csc316.security_log.data;

import java.util.Scanner;

/**
 * LogEntry Class
 * Gets the information of the Log Entry
 * @author Sanchit Razdan
 * @param <E> type of parameter used for the LogEntry
 */
public class LogEntry<E> implements Comparable<LogEntry> {
	
	/** user name of the log entry */
	private String username;
	
	/** action of the log entry */
	private String action;
	
	/** resource of the log entry */
	private String resource;
	
	/** timestamp for the log entry */
	private TimeStamp time;
	
	/**
	 * LogEntry Constructor. Constructs a new Log Entry with the information. 
	 * @param log the log entry in the input file 
	 */
	public LogEntry(String log) {
		Scanner scan = new Scanner(log);
		scan.useDelimiter(", ");
		setUsername(scan.next());			
		time = new TimeStamp(scan.next());
		setTimeStamp(time);
		setAction(scan.next());
		setResource(scan.next());
		scan.close();
	}
	
	private void setTimeStamp(TimeStamp time) {
		this.time = time;
	}
	
	/**
	 * getTime method. 
	 * gets the time stamp of the log entry. 
	 * @return the action of the log entry. 
	 */
	public TimeStamp getTime() {
		return time;
	}

	/**
	 * getAction method. 
	 * gets the action of the log entry. 
	 * @return the action of the log entry. 
	 */
	public String getAction() {
		return action;
	}
	
	/**
	 * setAction method. 
	 * @param action the action to set
	 */
	public void setAction(String action) {
		if(action == null || action.equals("") ) {
			throw new IllegalArgumentException("Invalid Log.");
		}
		this.action = action;
	}
	
	/**
	 * getResource method. 
	 * gets the resource of the log entry. 
	 * @return the resource of the log entry. 
	 */
	public String getResource() {
		return resource;
	}
	
	/**
	 * setResource method. 
	 * @param resource the resource to set
	 */
	public void setResource(String resource) {
		if(resource == null || resource.equals("")) {
			throw new IllegalArgumentException("Invalid Log.");
		}
		this.resource = resource;
	}
	
	/**
	 * getUsername method. 
	 * gets the user name of the log entry. 
	 * @return the username of the log entry. 
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * setUsername method. 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		if(username == null || username.equals("")) {
			throw new IllegalArgumentException("Invalid Log.");
		}
		this.username = username;
	}

	/**
	 * compareTo method. 
	 * @param other LogEntry to be used as a parameter. 
	 * @return 0, 1, -1 if this log entry is equal, greater or smaller than the other log entry. 
	 */
	@Override
	public int compareTo(LogEntry other) {
		if(time.compareTo(other.getTime()) < 0) {
			return -1;
		} else if(time.compareTo(other.getTime()) > 0) {
			return 1;
		} else if(action.compareTo(other.getAction()) < 0) {
			return -1;
		} else if(action.compareTo(other.getAction()) > 0) {
			return 1;
		} else if(resource.compareTo(other.getResource()) < 0) {
			return -1;
		} else if(resource.compareTo(other.getResource()) > 0) {
			return 1;
		} else if(username.compareTo(other.getUsername()) < 0) {
			return -1;
		} else if(username.compareTo(other.getUsername()) > 0) {
			return 1;
		}
		
		return 0;
	}
	
	/**
	 * hashFunction method. 
	 * @return makes a hashcode for the log entry. 
	 */
	public int hashFunction() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
}
