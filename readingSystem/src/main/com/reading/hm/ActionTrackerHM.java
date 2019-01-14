package com.reading.hm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import com.reading.db.ActionTrackerDb;
import com.reading.ui.Home;

public class ActionTrackerHM {
	 

	LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();

	public ActionTrackerHM(String action,String reference) {
		 
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-YYYY");
		SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss a");

		
		data.put("DATE", dt.format(new Date()));
		data.put("ACTION", action);
		data.put("TIME", tf.format(new Date()));
		data.put("USER", Home.user);
		data.put("REFERENCE", reference);
		
//		if(new ExpencesDb().createTable()) {
//			JOptionPane.showMessageDialog(null, "tableCreated", "", JOptionPane.INFORMATION_MESSAGE);
//		}
		new ActionTrackerDb().save(data);
	}
}
