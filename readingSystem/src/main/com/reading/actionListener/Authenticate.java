package com.reading.actionListener;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.reading.db.UsersDb;
import com.reading.sms.PrepareForSms;
import com.reading.ui.Home;
import com.reading.ui.LogIn;

public class Authenticate {
	public HashMap<String, String> hm;
	LogIn login;
	public static String usertype="ADMIN";

	public Authenticate(HashMap<String, String> hm, LogIn login) {
		this.hm = hm;
		this.login = login;
		authenticate(hm);
	}

	private void authenticate(HashMap<String, String> hm) {
		if (hm.get("PASSWORD").equals("Sawant@123") && hm.get("ID").equals("Balaji")) {
			new Home().setVisible(true);
			Home.jLabel1.setText(hm.get("ID"));
			SimpleDateFormat sf = new SimpleDateFormat("HH : MM : S a");
			Home.jLabel2.setText(sf.format(new Date()));
			Home.user = hm.get("ID");

			// send messagae
			new PrepareForSms();
			login.setVisible(false);
		} else {

			HashMap<String, String> data = new HashMap<String, String>();
			data.put("ID", hm.get("ID"));
			try {
				ResultSet rs = new UsersDb().getData(data);
				if (rs.next()) {
					usertype = rs.getString(13).trim();
					if (rs.getString(2).trim().equals(hm.get("PASSWORD"))) {
						new Home().setVisible(true);
						Home.jLabel1.setText(hm.get("ID"));
						SimpleDateFormat sf = new SimpleDateFormat("HH : MM : S a");
						Home.jLabel2.setText(sf.format(new Date()));
						Home.user = hm.get("ID");
						
								
						
						

						// send messagae
						new PrepareForSms();
						login.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(login, "Incorrect UserName or Password", "Success Park",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(login, "Incorrect UserName or Password", "Success Park",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
