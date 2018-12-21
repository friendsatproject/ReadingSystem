package com.reading.operaton;

import java.util.Random;

public class GenerateId {

	public static String getStudentId(String name, String adhar) {
		String id = name.substring(0,1) + adhar.substring(adhar.length() - 2) + getRandomNo();
		return id;
	}

	public static String getExpenceId(String user, String amount) {
		String id = user.substring(0, 4) + amount.substring(0) + getRandomNo();
		return id;
	}

	private static String getRandomNo() {
		int r = new Random().nextInt();
		String ra = r + "";
		ra = ra.substring(2, 6);
		return ra;
	}
}
