package com.reading.hm;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.FeesDb;
import com.reading.db.SmsDb;
import com.reading.db.Student;
import com.reading.operaton.GenerateId;
import com.reading.operaton.StaticMethods;
import com.reading.operaton.processImage.ProcessImage;
import com.reading.sms.Sms;
import com.reading.ui.Home;
import com.reading.ui.NewAdmission;

public class NewAdmissionHM {

	Thread t = new Thread() {
		public void run() {
			senMessage();
		}
	};

	LinkedHashMap<String, Object> saveSms = new LinkedHashMap<String, Object>();
	HashMap<String, String> hm = new HashMap<String, String>();
	NewAdmission na;

	public NewAdmissionHM(NewAdmission na) {
		this.na=na;
		LinkedHashMap<String, Object> fees = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> props = new LinkedHashMap<String, Object>();
		String id = GenerateId.getStudentId(na.nameTxt.getText(), na.adharTxt.getText());
		String date = StaticMethods.admissionDate(na.ddCmb, na.mmCmb, na.yyyyCmb);
		props.put("ID", id);
		props.put("NAME", na.nameTxt.getText());
		props.put("TADDRESS", na.tempAddress.getText());
		props.put("PADDRESS", na.permenentAddress.getText());
		props.put("ADHAR", na.adharTxt.getText());
		props.put("QUALIFICATION", na.qualificationTxt.getText());
		props.put("GENDER", StaticMethods.gender(na.maleRdo, na.femaleRdo));
		props.put("MOBILE", na.mobileNoTxt.getText());
		props.put("ALTERNATEMO", na.alternateMoNoTxt.getText());
		props.put("PARENTMONO", na.parentMoNoTxt.getText());
		props.put("OCCUPATION", na.occupationTxt.getText());
		props.put("ADMISSIONTYPE", (String) na.admissionTypeTxt.getSelectedItem());
		props.put("SHIFTTYPE", (String) na.shiftTypeCmb.getSelectedItem());
		props.put("JOINDATE", date);
		props.put("STATUS", "ACTIVE");

		fees.put("ID", id);
		fees.put("DATE", date);
		fees.put("AMOUNT", na.feesPaidTxt.getText());
		fees.put("RECEIVER", Home.user);
		fees.put("MONTH", na.mmCmb.getSelectedItem()+"-"+na.yyyyCmb.getSelectedItem());

		try {
			if (new Student().save(props) && new FeesDb().save(fees)) {

				new ProcessImage().saveImage(id);// save image to folder
				Home.nameCmb.addItem(props.get("NAME")+"-"+props.get("ID"));
				Home.activeLbl.setText((Integer.parseInt(Home.activeLbl.getText())+1)+"");
				new ActionTrackerHM("New student registration done", id);
				JOptionPane.showMessageDialog(null, "Student registerd  successfully !", "Student Added",
						JOptionPane.INFORMATION_MESSAGE);
				makeEmptyFields();

				hm.put("MSG", "Welcome " + na.nameTxt.getText() + " At Sucess Park, ID:" + id + " Fees Paid : "
						+ na.feesPaidTxt.getText());
				hm.put("NUMBER", na.mobileNoTxt.getText());

				saveSms.put("ID", id);
				saveSms.put("MSG", "Welcome " + na.nameTxt.getText() + " At Success Park, ID:" + id + " Fees Paid : "
						+ na.feesPaidTxt.getText());
				saveSms.put("NUMBER", na.mobileNoTxt.getText());
				saveSms.put("STATUS", "N");
//				t.start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(na, "Record may available in closed student list", "Error Message",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void senMessage() {

		// send message to student after admission confirm
		if (StaticMethods.isBetweenTime()) {
			new Sms(hm);
		} else {
			new SmsDb().save(saveSms);
		}
	}
	private void makeEmptyFields() {
		na.nameTxt.setText("");
		na.tempAddress.setText("");
		na.permenentAddress.setText("");
		na.adharTxt.setText("");
		na.qualificationTxt.setText("");
		na.mobileNoTxt.setText("");
		na.alternateMoNoTxt.setText("");
		na.parentMoNoTxt.setText("");
		na.occupationTxt.setText("");
		na.feesPaidTxt.setText("");
	}

}
