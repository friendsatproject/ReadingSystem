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
		String joinDate = sui.dd1.getSelectedItem().toString()+
				sui.mm1.getSelectedItem().toString()+
				sui.yy.getSelectedItem().toString();
		props.put("ID", sui.uidTxt.getText());
		props.put("PASSWORD", sui.passwordTxt.getText());
		props.put("NAME", sui.nameTxt.getText());
		props.put("ADDRESS", sui.addressTxt.getText());
		props.put("MOBILE", sui.moNoTxt.getText());
		props.put("ALTERNATEMO", sui.ulternateMoNoTxt.getText());
		if(sui.male1.isSelected())props.put("GENDER", "MALE");
		if(sui.female1.isSelected())props.put("GENDER", "FEMALE");
		if(sui.other1.isSelected())props.put("GENDER", "OTHER");
		props.put("ADHAR", sui.adharTxt.getText());
		props.put("QUALIFICATION", sui.qualificationTxt.getText());
		props.put("OCCUPATION", sui.occupationTxt.getText());
		props.put("JOINDATE", joinDate);
		props.put("SALLARY", sui.sallaryTxt.getText());
		props.put("USERTYPE", sui.userTypeCmb.getSelectedItem());
		
		if(new UsersDb().update(props)) {
			new ActionTrackerHM("User Information Updated",sui.uidTxt.getText());
			JOptionPane.showMessageDialog(null, "User information updated  successfully !", "User Updated", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
