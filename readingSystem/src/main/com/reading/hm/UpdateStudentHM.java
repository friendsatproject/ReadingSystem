package com.reading.hm;

import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.Student;
import com.reading.operaton.StaticMethods;
import com.reading.ui.ShowStudentDetails;

public class UpdateStudentHM {
	
	public UpdateStudentHM(ShowStudentDetails s ) {
		
		LinkedHashMap<String, Object> props = new LinkedHashMap<String, Object>() {
			{
				put("ID", s.idTxt.getText());
				put("NAME", s.nameTxt.getText());
				put("TADDRESS", s.tempAddress.getText());
				put("PADDRESS", s.permenentAddress.getText());

				put("ADHAR", s.adharTxt.getText());
				put("QUALIFICATION", s.qualificationTxt.getText());
				put("GENDER", StaticMethods.gender(s.maleRdo, s.femaleRdo));

				put("MOBILE", s.mobileNoTxt.getText());
				put("ALTERNATEMO", s.alternateMoNoTxt.getText());
				put("PARENTMONO", s.parentMoNoTxt.getText());

				put("OCCUPATION", s.occupationTxt.getText());

				put("ADMISSIONTYPE", s.admissionTypeTxt.getSelectedItem());
				put("SHIFTTYPE", s.shiftTypeCmb.getSelectedItem());

				put("JOINDATE", StaticMethods.admissionDate(s.ddCmb, s.mmCmb, s.yyyyCmb));

			}
		};
		try {
			if (new Student().update(props)) {
				new ActionTrackerHM("Student Information Updated", s.idTxt.getText());
				JOptionPane.showMessageDialog(null, "Student information updated  successfully !", "Student Updated",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
