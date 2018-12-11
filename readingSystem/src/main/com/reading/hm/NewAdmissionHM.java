package com.reading.hm;

import java.util.LinkedHashMap;

import com.reading.db.Student;
import com.reading.ui.NewAdmission;

public class NewAdmissionHM {

	NewAdmission na;
	public NewAdmissionHM(NewAdmission na) {
		LinkedHashMap<String,Object> props = new LinkedHashMap<String,Object>();
		
		props.put("FIRSTNAME",na.firstNameTxt.getText());
		props.put("MIDDLENAME",na.middleNameTxt.getText());
		props.put("LASTNAME",na.fatherNameTxt.getText());
		props.put("ADDRESS",na.addressTxt.getText());
		props.put("ADHAR",na.adharTxt.getText());
		props.put("MOBILE",na.mobileNoTxt.getText());
		props.put("ALTERNATEMO",na.alternateMoNoTxt.getText());
		props.put("PARENTMONO",na.parentMoNoTxt.getText());
		props.put("QUALIFICATION",na.qualificationTxt.getText());
		props.put("OCCUPATION",na.occupationTxt.getText());
		props.put("ADMISSIONTYPE",(String) na.admissionTypeTxt.getSelectedItem());
		props.put("SHIFTTYPE",(String) na.shiftTypeCmb.getSelectedItem());
		props.put("FEESPAID",na.feesPaidTxt.getText());
		props.put("REMAININGFEES",na.remainingFeesTxt.getText());
		new Student().save(props);	
	}
	
}
