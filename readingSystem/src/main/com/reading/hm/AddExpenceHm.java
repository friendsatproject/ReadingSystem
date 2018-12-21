package com.reading.hm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.ExpencesDb;
import com.reading.operaton.GenerateId;
import com.reading.ui.Expences;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sawant
 */
public class AddExpenceHm {
	Expences ex;
	LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();

	public AddExpenceHm(Expences ex) {
		this.ex = ex;
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-YYYY");
		String id = GenerateId.getExpenceId("USER", ex.amountTxt.getText());
		data.put("ID", id);
		data.put("EXPENCETYPE", ex.eTypeTxt.getText());
		data.put("AMOUNT", ex.amountTxt.getText());
		data.put("DATE", dt.format(new Date()));
		data.put("DESCRIPTION", ex.descriptionTxt.getText());
		data.put("USER", "User");
		
//		if(new ExpencesDb().createTable()) {
//			JOptionPane.showMessageDialog(null, "tableCreated", "", JOptionPane.INFORMATION_MESSAGE);
//		}
		if(new ExpencesDb().save(data)) {
			new ActionTrackerHM("Expence Added",id)	;	
			JOptionPane.showMessageDialog(null, "Expence saved successfully !", "", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
