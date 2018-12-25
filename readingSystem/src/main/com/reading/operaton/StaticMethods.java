package com.reading.operaton;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public  class StaticMethods {
	static DefaultComboBoxModel model;

	static public void setDateToCmb(JComboBox ddCmb,JComboBox mmCmb,JComboBox yyyyCmb,JCheckBox currentDateCB) {
	    	if(currentDateCB.isSelected()) {
	    		String fullDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	    		model = (DefaultComboBoxModel) ddCmb.getModel();
	    		model.setSelectedItem(fullDate.substring(0, 2));
	    		
	    		model = (DefaultComboBoxModel) mmCmb.getModel();
	    		model.setSelectedItem(fullDate.substring(3, 5));
	    		
	    		model = (DefaultComboBoxModel) yyyyCmb.getModel();
	    		model.setSelectedItem(fullDate.substring(6, 10));
	    		
	    		ddCmb.setEnabled(false);
	    		mmCmb.setEnabled(false);
	    		yyyyCmb.setEnabled(false);
	    	}
	    	else {
	    		ddCmb.setEnabled(true);
	    		mmCmb.setEnabled(true);
	    		yyyyCmb.setEnabled(true);
	    		
	    		ddCmb.setSelectedIndex(0);
	    		mmCmb.setSelectedIndex(0);
	    		yyyyCmb.setSelectedIndex(0);
	    	}
	    }
	public static String admissionDate(JComboBox dd,JComboBox mm,JComboBox yy) {
		return dd.getSelectedItem()+"-"+mm.getSelectedItem()+"-"+yy.getSelectedItem();
	}
	public static String gender(JRadioButton m,JRadioButton f) {
		if(m.isSelected()) {
			return "Male";
		}
		if(f.isSelected()) {
			return "Female";
		}
		else {
			return "Other";
		}
	}
}
