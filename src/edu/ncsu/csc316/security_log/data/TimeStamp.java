/**
 * 
 */
package edu.ncsu.csc316.security_log.data;

/**
 * TimeStamp class. 
 * @author Sanchit Razdan
 */
public class TimeStamp implements Comparable <TimeStamp> {
	
	/** month instance variable. */
	private int month;
	
	/** date instance variable */
	private int date;
	
	/** year instance variable */
	private int year;
	
	/** hours instance variable */
	private int hours;
	
	/** mins instance variable */
	private int mins;
	
	/** secs instance variable */
	private int secs;
	
	/** timeOfDay instance variable */
	private String timeOfDay;
	
	/** timeStamp instance variable */
	private String timeStamp;
	
	// 01/01/2001 01:01:30PM
	
	/**
	 * TimeStamp constructor. Constructs a new time stamp. 
	 * @param timeStamp the timeStamp of that log entry. 
	 */
	public TimeStamp(String timeStamp) {
		setTimeStamp(timeStamp);
		String t = timeStamp;
		
		setMonth(Integer.parseInt(t.substring(0, 2)));
		setDate(Integer.parseInt(t.substring(3, 5)));
		setYear(Integer.parseInt(t.substring(6, 10)));
		
		setHours(Integer.parseInt(t.substring(11, 13)));
		setMins(Integer.parseInt(t.substring(14, 16)));
		setSecs(Integer.parseInt(t.substring(17, 19)));
		setTimeOfDay(t.substring(19));
	}
	
	/**
	 * getMonth method. 
	 * @return the month of the log entry. 
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * setMonth method. 
	 * @param month the month to be set for the log entry. 
	 */
	public void setMonth(int month) {
		if(month < 0 || month > 12) {
			throw new IllegalArgumentException("Invalid Time Stamp");
		}
		this.month = month;
	}
	
	/**
	 * getDate method. 
	 * @return date of the log entry. 
	 */
	public int getDate() {
		return date;
	}
	
	/**
	 * setDate method. 
	 * @param date the date to be set for the log entry. 
	 */
	public void setDate(int date) {
		if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && date > 31) {
			throw new IllegalArgumentException("Invalid Time Stamp");
		} else if((month == 4 || month == 6 || month == 9 || month == 11) && date > 30) {
			throw new IllegalArgumentException("Invalid Time Stamp");
		} else if((year % 400 == 0) && (month == 2) && date > 29) {
			throw new IllegalArgumentException("Invalid Time Stamp");
		} else if((year % 400 != 0) && (month == 2) && date > 28) {
			throw new IllegalArgumentException("Invalid Time Stamp");
		} else if(date < 0) {
			throw new IllegalArgumentException("Invalid Time Stamp");
		}
		this.date = date;
	}
	
	/**
	 * getYear method. 
	 * @return the year of the log entry. 
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * setYear method. 
	 * @param year the year to be set for the log entry. 
	 */
	public void setYear(int year) {
		if(year < 0) {
			throw new IllegalArgumentException("Invalid Time Stamp");
		}
		this.year = year;
	}
	
	/**
	 * getHours method. 
	 * @return the hours of the entry. 
	 */
	public int getHours() {
		return hours;
	}
	
	/**
	 * setHours method. 
	 * @param hours the hours ot be set for the log entry. 
	 */
	public void setHours(int hours) {
		if(hours < 0 || hours > 12) {
			throw new IllegalArgumentException("Invalid Time Stamp");
		}
		this.hours = hours;
	}
	
	/**
	 * getMins method. 
	 * @return the mins of the log entry. 
	 */
	public int getMins() {
		return mins;
	}
	
	/**
	 * setMins method. 
	 * @param mins the mins to be set for the log entry. 
	 */
	public void setMins(int mins) {
		if(mins < 0 || mins > 60) {
			throw new IllegalArgumentException("Invalid Time Stamp");
		}
		this.mins = mins;
	}
	
	/**
	 * getTimeOfDay method. 
	 * @return the timeOfDay of the log entry. 
	 */
	public String getTimeOfDay() {
		return timeOfDay;
	}
	
	/**
	 * setTimeOfDay method. 
	 * @param timeOfDay the timeOfDay to set
	 */
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	
	/**
	 * getSecs method. 
	 * @return the secs of the log entry. 
	 */
	public int getSecs() {
		return secs;
	}
	
	/**
	 * setSecs method. 
	 * @param secs the secs to be set for the log entry. 
	 */
	public void setSecs(int secs) {
		if(secs < 0 || secs > 60) {
			throw new IllegalArgumentException("Invalid Time Stamp");
		}
		this.secs = secs;
	}


	/**
	 * getTimeStamp method. 
	 * @return the timeStamp of the log entry. 
	 */
	public String getTimeStamp() {
		return timeStamp;
	}


	/**
	 * setTimeStamp method. 
	 * @param timeStamp the timeStamp to be set for the log entry. 
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	/**
	 * compareTo method. 
	 * compares this timestamp to another. 
	 * @param t the other timestamp.
	 * @return 1 if this time stamp comes after other. -1 if this comes before and 0 if they are same. 
	 */
	@Override
	public int compareTo(TimeStamp t) {
		//12 AM and 12 PM case not solved yet. 
		if(year > t.getYear()) {
			return 1;
		} else if(year < t.getYear()) {
			return -1;
		} else {
			if(month > t.getMonth()) {
				return 1;
			} else if(month < t.getMonth()) {
				return -1;
			} else {
				if(date > t.getDate()) {
					return 1;
				} else if(date < t.getDate()) {
					return -1;
				} else { 
					if(timeOfDay.equals("AM") && t.getTimeOfDay().equals("PM")) {
						return -1;
					} else if(timeOfDay.equals("PM") && t.getTimeOfDay().equals("AM")) {
						return 1;
					} else {
						if(hours == 12 && t.getHours() != 12) {
							return -1;
						} else if(t.getHours() == 12 && hours != 12) {
							return 1;
						} else if(hours > t.getHours()) {
							return 1;
						} else if(hours < t.getHours()) {
							return -1;
						} else {
							if(mins > t.getMins()) {
								return 1;
							} else if(mins < t.getMins()) {
								return -1;
							} else {
								if(secs > t.getSecs()) {
									return 1;
								} else if(secs < t.getSecs()) {
									return -1;
								}
							}
						}
					}
				}
			}
		}
		return 0;
	}
	
	/**
	 * toString method.
	 * @return the string representation of the time stamp. 
	 */
	public String toString() {
		String min = "";
		String sec = "";
		String mon = "";
		String dat = "";
		String yr = "";
		String h = "";
		if(mins < 10) {
			min = "0" + mins;
		} else {
			min += mins;
		}
		if(secs < 10) {
			sec = "0" + secs;
		} else {
			sec += secs;
		}
		
		if(month < 10) {
			mon = "0" + month;
		} else {
			mon += month;
		}
		
		if(date < 10) {
			dat = "0" + date;
		} else {
			dat += date;
		}
		
		if(hours < 10) {
			h = "0" + hours;
		} else {
			h += hours;
		}
		
		if(year < 10) {
			yr = "0" + year;
		} else {
			yr += year;
		}
		return "" + mon + "/" + dat + "/" + yr + " " + h + ":" + min + ":" + sec + timeOfDay;
	}

	/**
	 * hashCode function. 
	 * @return hash code representation of a timestamp. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + date;
		result = prime * result + hours;
		result = prime * result + mins;
		result = prime * result + month;
		result = prime * result + secs;
		result = prime * result + ((timeOfDay == null) ? 0 : timeOfDay.hashCode());
		result = prime * result + year;
		return result;
	}

	/**
	 * equals method. 
	 * @return true if the object is equal to the other object and false if not. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeStamp other = (TimeStamp) obj;
		if (date != other.date)
			return false;
		if (hours != other.hours)
			return false;
		if (mins != other.mins)
			return false;
		if (month != other.month)
			return false;
		if (secs != other.secs)
			return false;
		if (timeOfDay == null) {
			if (other.timeOfDay != null)
				return false;
		} else if (!timeOfDay.equals(other.timeOfDay))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
}
