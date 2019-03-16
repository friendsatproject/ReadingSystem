package com.reading.operaton;

import java.net.InetAddress;
import javax.swing.JOptionPane;

public class IpAddress {
	public static void checkIP() {
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			String addr = localhost.getHostAddress().toString().trim();
			if(!(new Secure().secure(addr).equals("b1b6c65c705265f91c8d5990a0fd9caf"))){
				JOptionPane.showMessageDialog(null, "Your Service has been blocked \n Please contact to <sbs.pimpalwadi@gmail.com>", "Access Denied!", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public static void main(String args[]) {
//		checkIP();
//	}
}