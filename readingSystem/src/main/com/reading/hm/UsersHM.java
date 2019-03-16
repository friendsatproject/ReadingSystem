package com.reading.hm;

import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.UsersDb;
import com.reading.operaton.Secure;
import com.reading.ui.SettingsUI;

public class UsersHM {
	public UsersHM(SettingsUI sui) {
		String joinDate = sui.dd.getSelectedItem().toString() + sui.mm.getSelectedItem().toString()
				+ sui.yy.getSelectedItem().toString();
		LinkedHashMap<String, Object> props = new LinkedHashMap<String, Object>();
		props.put("ID", sui.uidTxt1.getText());
		props.put("PASSWORD",new Secure().secure( sui.passwordTxt1.getText()));
		props.put("NAME", sui.nameTxt1.getText());
		props.put("ADDRESS", sui.addressTxt1.getText());
		props.put("MOBILE", sui.moNoTxt1.getText());
		props.put("ALTERNATEMO", sui.ulternateMoNoTxt1.getText());
		if (sui.male.isSelected())
			props.put("GENDER", "MALE");
		if (sui.female.isSelected())
			props.put("GENDER", "FEMALE");
		if (sui.other.isSelected())
			props.put("GENDER", "OTHER");
		props.put("ADHAR", sui.adharTxt1.getText());
		props.put("QUALIFICATION", sui.qualificationTxt1.getText());
		props.put("OCCUPATION", sui.occupationTxt1.getText());
		props.put("JOINDATE", joinDate);
		props.put("SALLARY", sui.sallaryTxt1.getText());
		props.put("USERTYPE", sui.userTypeCmb1.getSelectedItem());

		try {

			if (new UsersDb().save(props)) {
				new ActionTrackerHM("New User Created", "ADMIN");
				JOptionPane.showMessageDialog(null, "User has been created Successfully !", "Sawat Balaji",
						JOptionPane.INFORMATION_MESSAGE);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
