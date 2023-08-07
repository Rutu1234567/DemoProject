package org.cap.demo.util;

public class Util {

	private static int accId=0;
	
	public static int generateAccountNo() {
		return accId++;
	}
}
