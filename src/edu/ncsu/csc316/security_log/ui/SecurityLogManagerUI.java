/**
 * 
 */
package edu.ncsu.csc316.security_log.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.ArrayList;
import edu.ncsu.csc316.security_log.io.LogEntryReader;
import edu.ncsu.csc316.security_log.manager.SecurityLogManager;

/**
 * SecurityLogManagerUI class. 
 * has the main method and uses all the calls for the implementation of the program. 
 * @author Sanchit Razdan
 */
public class SecurityLogManagerUI {
	
	/**
	 * main method. 
	 * @param args0 the String array in the main method. 
	 * @throws FileNotFoundException if the file path is not found in the system. 
	 */
	public static void main(String[] args0) throws FileNotFoundException {
		SecurityLogManager m = new SecurityLogManager(null);
		Scanner inputFile = new Scanner(System.in);
		System.out.print("Enter the file path to be read: ");
		String filePath = inputFile.next();
		@SuppressWarnings("unused")
		LogEntryReader ler = new LogEntryReader();
		@SuppressWarnings("unused")
		ArrayList<LogEntry> logs = ler.processFile(filePath);
		System.out.print("Enter Operation to be performed: ");
		String operation = inputFile.nextLine();
		while(operation != null) {
			if(operation.trim().equalsIgnoreCase("generateoperationalprofile" )) {
				Scanner timeStamp = new Scanner(System.in);
				System.out.print("Enter Start Time: ");
				String start = timeStamp.next();
				System.out.print("Enter End Time: ");
				String end = timeStamp.next();
				System.out.print(m.generateOperationalProfile(start, end));
				timeStamp.close();
			} else if(operation.trim().equalsIgnoreCase("getuserreport" )) {
				Scanner user = new Scanner(System.in);
				System.out.print("User: ");
				String username = user.next();
				String userLogs = m.getUserReport(username);
				System.out.print(userLogs);
				user.close();
			} else if(operation.trim().equalsIgnoreCase("quit")) {
				System.exit(0);
			}
			System.out.print("Enter Operation to be performed: ");
			operation = inputFile.nextLine();
		}
		inputFile.close();
	}

}
