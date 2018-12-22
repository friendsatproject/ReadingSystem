package com.reading.hm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.Student;
import com.reading.ui.NewAdmission;

public class FeesHM {
	public FeesHM(NewAdmission na) {
		LinkedHashMap<String,Object> props = new LinkedHashMap<String,Object>();
		props.put("ID","id");
		props.put("DATE",new SimpleDateFormat("dd-MM-YYYY").format(new Date()));
		props.put("AMOUNT","amount");
		props.put("RECEIVER","user");
		
		if(new Student().save(props)) {
			new ActionTrackerHM("Fees Updated","id");
			JOptionPane.showMessageDialog(null, "Fees Updated successfully !", "Fees Updated", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
