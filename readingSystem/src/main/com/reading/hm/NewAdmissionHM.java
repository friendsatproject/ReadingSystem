package com.reading.hm;

import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.FeesDb;
import com.reading.db.Student;
import com.reading.operaton.GenerateId;
import com.reading.operaton.StaticMethods;
import com.reading.operaton.processImage.ProcessImage;
import com.reading.ui.NewAdmission;

public class NewAdmissionHM {

	NewAdmission na;
	public NewAdmissionHM(NewAdmission na) {
		LinkedHashMap<String,Object> fees = new LinkedHashMap<String,Object>();
		LinkedHashMap<String,Object> props = new LinkedHashMap<String,Object>();
		String id = GenerateId.getStudentId(na.nameTxt.getText(),na.adharTxt.getText());
		String date = StaticMethods.admissionDate(na.ddCmb, na.mmCmb, na.yyyyCmb);
		props.put("ID",id);
		props.put("NAME",na.nameTxt.getText());
		props.put("TADDRESS",na.tempAddress.getText());
		props.put("PADDRESS",na.permenentAddress.getText());
		props.put("ADHAR",na.adharTxt.getText());
		props.put("QUALIFICATION",na.qualificationTxt.getText());
		props.put("GENDER",StaticMethods.gender(na.maleRdo, na.femaleRdo));
		props.put("MOBILE",na.mobileNoTxt.getText());
		props.put("ALTERNATEMO",na.alternateMoNoTxt.getText());
		props.put("PARENTMONO",na.parentMoNoTxt.getText());
		props.put("OCCUPATION",na.occupationTxt.getText());
		props.put("ADMISSIONTYPE",(String) na.admissionTypeTxt.getSelectedItem());
		props.put("SHIFTTYPE",(String) na.shiftTypeCmb.getSelectedItem());
		props.put("JOINDATE",date);
		props.put("STATUS","ACTIVE");
		
		fees.put("ID", id);
		fees.put("DATE",date);
		fees.put("AMOUNT",na.feesPaidTxt.getText());
		fees.put("RECEIVER","USER");
		
		try {
		if(new Student().save(props) && new FeesDb().save(fees)) {
			
			new ProcessImage().saveImage(id);//save image to folder
			
			new ActionTrackerHM("New student registration done",id);
			JOptionPane.showMessageDialog(null, "Student registerd  successfully !", "Student Added", JOptionPane.INFORMATION_MESSAGE);
		}
		}catch(Exception e) {
			e.printStackTrace( );
			JOptionPane.showMessageDialog(na, "Record may available in closed student list", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
