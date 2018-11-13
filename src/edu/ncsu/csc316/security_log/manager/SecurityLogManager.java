package edu.ncsu.csc316.security_log.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.data.OperationalProfile;
import edu.ncsu.csc316.security_log.data.TimeStamp;
import edu.ncsu.csc316.security_log.dictionary.ArrayList;
import edu.ncsu.csc316.security_log.io.LogEntryReader;
import util.Merge;

/**
 * SecurityLogManager class. 
 * Makes the security log and does the main operations. 
 * @author Sanchit Razdan 
 */
public class SecurityLogManager {
	
	/** the logs array based list used in the program to do the operations. */
	private ArrayList<LogEntry> logs;
	
	/**
	 * Constructs a new SecurityLogManager given
	 * the path to the input user activity log file.
	 * 
	 * @param filePath - the path to the user activity log file
	 */
	public SecurityLogManager(String filePath) {
		try {
			LogEntryReader ler = new LogEntryReader();
			logs = ler.processFile(filePath);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found.");
		}
	}
	
	/**
	 * Produces an operational profile of user activity
	 * performed between the given start and end dates (inclusive)
	 * 
	 * @param start - the start date in the format "MM/DD/YYYY HH:MM:SSXM"
	 * @param end - the end date in the format "MM/DD/YYYY HH:MM:SSXM"
	 * @return a string representing the operational profile
	 */
	public String generateOperationalProfile(String start, String end) {
		Merge m = new Merge();
		StringBuffer a = new StringBuffer();
		a.append("OperationalProfile[\n");
		TimeStamp st = new TimeStamp(start);
		TimeStamp en = new TimeStamp(end);
		ArrayList<LogEntry> userLogs = new ArrayList<LogEntry>();
		for(int i = 0; i < logs.size(); i++) {
			if(logs.get(i).getTime().compareTo(st) >= 0 && logs.get(i).getTime().compareTo(en) <= 0 ) {
				userLogs.insert(logs.get(i));
			}
		}
		m.sort(userLogs, 0, userLogs.size() - 1);
		ArrayList<String> functions = new ArrayList<String>();
		ArrayList<Integer> frequencies = new ArrayList<Integer>();
		
		functions.insert(userLogs.get(0).getAction() + " " + userLogs.get(0).getResource());
		frequencies.insert(1);
		
		for(int i = 1; i < userLogs.size(); i++) {
			String an = userLogs.get(i).getAction() + " " + userLogs.get(i).getResource();
			if(functions.lookUp(an) != -1 ) {
				int index = functions.lookUp(an);
				frequencies.set(index, frequencies.get(index) + 1);
			} else {
				functions.insert(an);
				frequencies.insert(1);
			}
		}
		
		double total = 0;
		for(int i = 0; i < frequencies.size(); i++) {
			total += frequencies.get(i);
		}
		
		ArrayList<OperationalProfile> op = new ArrayList<OperationalProfile>();
		for(int i = 0; i < functions.size(); i++) {
			OperationalProfile op1 = new OperationalProfile(functions.get(i), frequencies.get(i));
			op.insert(op1);
		}
		
		m.sort(op, 0, op.size() - 1);
		
		float percent = 0.0f;
		for(int i = 0; i < op.size(); i++) {
			percent = (float) ((op.get(i).getFrequency() / total) * 100);
			String act = op.get(i).getFunction();
			a.append("   ");
			a.append(act);
			a.append(": frequency: ");
			a.append(op.get(i).getFrequency());
			a.append(", percentage: ");
			a.append(String.format("%.1f", percent));
			a.append("%\n");
		}
		a.append("]");
		return a.toString();
		
	}
	
	/**
	 * Produces a list of log entries for a given 
	 * user. The output list is sorted chronologically.
	 * 
	 * @param username - the user for which to generate a report
	 * @return a string representing the user report
	 */
	public String getUserReport(String username) {
		Merge m = new Merge();
		StringBuffer userReport = new StringBuffer();
		userReport.append("Activity Report for " + username + "[\n");
		ArrayList<LogEntry> userLogs = new ArrayList<LogEntry>();
		for(int i = 0; i < logs.size(); i++) {
			if (logs.get(i).getUsername().equals(username)) {
				userLogs.insert(logs.get(i));
			}
		}
		if(userLogs.size() == 0) {
			userReport.append("   No activity was recorded.\n" + "]");
			return userReport.toString();
		}
		 m.sort(userLogs, 0, userLogs.size() - 1);
		for(int i = 0; i < userLogs.size(); i++) {
			TimeStamp time = userLogs.get(i).getTime(); //timestamp
			String action = userLogs.get(i).getAction(); //action
			String resource = userLogs.get(i).getResource(); //resource
			userReport.append("   " + time.toString() + " - " + action + " " + resource + "\n");
		}
		userReport.append("]");
		return userReport.toString();
	}
}
