package com.reading.hm;

import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.Student;
import com.reading.ui.ShowStudentDetails;

public class UpdateNewValueHM {

	public UpdateNewValueHM(ShowStudentDetails ssd, LinkedHashMap<String, Object> oldDataHm) {

		LinkedHashMap<String, Object> newDataHm = new LinkedHashMap<String, Object>();

		newDataHm.put("ID","101");
		newDataHm.put("FIRSTNAME", ssd.firstNameTxt.getText());
		newDataHm.put("MIDDLENAME", ssd.middleNameTxt.getText());
		newDataHm.put("LASTNAME", ssd.fatherNameTxt.getText());
		newDataHm.put("ADDRESS", ssd.addressTxt.getText());
		newDataHm.put("ADHAR", ssd.adharTxt.getText());
		newDataHm.put("MOBILE", ssd.mobileNoTxt.getText());
		newDataHm.put("ALTERNATEMO", ssd.alternateMoNoTxt.getText());
		newDataHm.put("PARENTMONO", ssd.parentMoNoTxt.getText());
		newDataHm.put("QUALIFICATION", ssd.qualificationTxt.getText());
		newDataHm.put("OCCUPATION", ssd.occupationTxt.getText());
		newDataHm.put("ADMISSIONTYPE", (String) ssd.admissionTypeTxt.getSelectedItem());
		newDataHm.put("SHIFTTYPE", (String) ssd.shiftTypeCmb.getSelectedItem());
//      newDataHm.put("FEESPAID", );
//      newDataHm.put("REMAININGFEES", );
//      newDataHm.put("JOINDATE", );
		
		if(new Student().update(newDataHm)) {
			new ActionTrackerHM("tudent Data Updation done","ID");
			JOptionPane.showMessageDialog(null, "Student updated  successfully !", "Student Updated", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
