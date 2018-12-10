package com.reading.hm;

import java.util.LinkedHashMap;

import com.reading.ui.NewAdmission;

public class NewAdmissionHM {

	NewAdmission na;
	public NewAdmissionHM(NewAdmission na) {
		LinkedHashMap<String,String> props = new LinkedHashMap<String,String>();
		
		props.put("firstName",na.firstNameTxt.getText());
		props.put("middleName",na.middleNameTxt.getText());
		props.put("lastName",na.fatherNameTxt.getText());
		props.put("address",na.addressTxt.getText());
		props.put("adhar",na.adharTxt.getText());
		props.put("mobile",na.mobileNoTxt.getText());
		props.put("alternateMo",na.alternateMoNoTxt.getText());
		props.put("parentMoNo",na.parentMoNoTxt.getText());
		props.put("qualification",na.qualificationTxt.getText());
		props.put("occupation",na.occupationTxt.getText());
		props.put("admissionType",(String) na.admissionTypeTxt.getSelectedItem());
		props.put("shiftType",(String) na.shiftTypeCmb.getSelectedItem());
		props.put("feesPaid",na.feesPaidTxt.getText());
		props.put("remainingFees",na.remainingFeesTxt.getText());
	}
}
