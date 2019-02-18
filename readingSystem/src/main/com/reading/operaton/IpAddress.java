package com.reading.operaton;

import java.net.*;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import java.net.InetAddress;

public class IpAddress {
	public static void checkIP() {
		try {
			// Returns the instance of InetAddress containing
			// local host name and address
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println("System IP Address : " + (localhost.getHostAddress()).trim());

			// Find public IP address
			String systemipaddress = "";
			try {
				URL url_name = new URL("http://bot.whatismyipaddress.com");

				BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));

				// reads system IPAddress
				systemipaddress = sc.readLine().trim();
			} catch (Exception e) {
				systemipaddress = "Cannot Execute Properly";
			}
			System.out.println(systemipaddress);
			if (!systemipaddress.trim().equalsIgnoreCase(systemipaddress)) {
				int result = JOptionPane.showConfirmDialog(null,
						"Your Lincence Has Been Expierd, Please contact to 'sbs.pimpalwadi@gmail.com' and renew your product !",
						"Licence Expierd", JOptionPane.YES_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					System.exit(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}