package com.reading.operaton;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Secure {
	public  String secure(String input) {
		String code = null;
		if(null == input) return null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes(), 0, input.length());
			code = new BigInteger(1, digest.digest()).toString(16);
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return code;
	}
}
