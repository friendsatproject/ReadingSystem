package com.reading.operaton;

import java.net.InetAddress;
import javax.swing.JOptionPane;

public class IpAddress {
	public static void checkIP() {
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			String addr = localhost.getHostAddress().toString().trim();
			System.out.println(addr);
//			if (!((new Secure().secure(addr).equals("3b0272341a4760a5a1f8ad4ddc98f766"))
//					|| (new Secure().secure(addr).equals("f528764d624db129b32c21fbca0cb8d6")))) {
//				JOptionPane.showMessageDialog(null,
//						"Your Service has been blocked \n Please contact to <sbs.pimpalwadi@gmail.com>",
//						"Access Denied !", JOptionPane.ERROR_MESSAGE);
//				System.exit(0);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public static void main(String args[]) {
//		checkIP();
//	}
}