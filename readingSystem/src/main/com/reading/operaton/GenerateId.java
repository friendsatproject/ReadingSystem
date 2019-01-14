package com.reading.operaton;

import java.util.Random;

public class GenerateId {

	public static String getStudentId(String name, String adhar) {
		String id = name.substring(0,1) + adhar.substring(adhar.length() - 2) + getRandomNo();
		System.out.println("generated id :"+id+":");
		return id.trim();
	}

	public static String getExpenceId(String user, String amount) {
		String id = user.substring(0, 1) + amount.substring(0) + getRandomNo();
		System.out.println("generated id :"+id+":");
		return id;
	}

	private static String getRandomNo() {
		int r = new Random().nextInt(99);
		String ra = r + "";
//		ra = ra.substring(2, 6);
		System.out.println("random no :"+ra+":");
		return ra.trim();
	}
}
