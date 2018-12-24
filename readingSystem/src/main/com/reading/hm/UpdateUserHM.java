package com.reading.hm;

import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.DBQuerys;
import com.reading.db.Student;
import com.reading.db.UsersDb;
import com.reading.ui.SettingsUI;
import com.reading.ui.ShowStudentDetails;

public class UpdateUserHM extends DBQuerys{

	public UpdateUserHM(SettingsUI sui) {

		LinkedHashMap<String, Object> props = new LinkedHashMap<String, Object>();

		props.put("ID", sui.uidTxt.getText());
		props.put("PASSWORD", sui.passwordTxt.getText());
		props.put("NAME", sui.nameTxt.getText());
		props.put("ADDRESS", sui.addressTxt.getText());
		props.put("MOBILE", sui.moNoTxt.getText());
		props.put("ALTERNATEMO", sui.ulternateMoNoTxt.getText());
		props.put("GENDER", sui.genderTxt.getText());
		props.put("ADHAR", sui.adharTxt.getText());
		props.put("QUALIFICATION", sui.qualificationTxt.getText());
		props.put("OCCUPATION", sui.occupationTxt.getText());
		props.put("JOINDATE", sui.joinDateTxt.getText());
		props.put("SALLARY", sui.sallaryTxt.getText());
		props.put("USERTYPE", sui.userTypeCmb.getSelectedItem());
		
		if(new UsersDb().update(props)) {
			new ActionTrackerHM("User Information Updated","ID");
			JOptionPane.showMessageDialog(null, "User information updated  successfully !", "Student Updated", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
