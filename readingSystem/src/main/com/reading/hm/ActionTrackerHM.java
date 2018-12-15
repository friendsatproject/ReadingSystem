package com.reading.hm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.ActionTrackerDb;
import com.reading.ui.ActionTracker;

public class ActionTrackerHM {
	ActionTracker at;

	LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();

	public ActionTrackerHM(ActionTracker ex) {
		this.at = at;
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-YYYY");
		SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");

		data.put("ID", "104");
		data.put("DATE", dt.format(new Date()));
		data.put("ACTION", "action");
		data.put("TIME", tf.format(new Date()));
		data.put("USER", "user");
		data.put("REFERENCE", "Reference");
		
//		if(new ExpencesDb().createTable()) {
//			JOptionPane.showMessageDialog(null, "tableCreated", "", JOptionPane.INFORMATION_MESSAGE);
//		}
		if(new ActionTrackerDb().save(data)) {
			JOptionPane.showMessageDialog(null, "Expence saved successfully !", "", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
