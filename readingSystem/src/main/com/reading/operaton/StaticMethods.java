package com.reading.operaton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class StaticMethods {
	static DefaultComboBoxModel model;

	static public void setDateToCmb(JComboBox ddCmb, JComboBox mmCmb, JComboBox yyyyCmb, JCheckBox currentDateCB) {
		if (currentDateCB.isSelected()) {
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
		} else {
			ddCmb.setEnabled(true);
			mmCmb.setEnabled(true);
			yyyyCmb.setEnabled(true);

			ddCmb.setSelectedIndex(0);
			mmCmb.setSelectedIndex(0);
			yyyyCmb.setSelectedIndex(0);
		}
	}

	public static String admissionDate(JComboBox dd, JComboBox mm, JComboBox yy) {
		return dd.getSelectedItem() + "-" + mm.getSelectedItem() + "-" + yy.getSelectedItem();
	}

	public static String gender(JRadioButton m, JRadioButton f) {
		if (m.isSelected()) {
			return "Male";
		}
		if (f.isSelected()) {
			return "Female";
		} else {
			return "Other";
		}
	}

	public static void setDate(JComboBox dd, JComboBox mm, JComboBox yy, String date) {
		dd.setSelectedItem(date.substring(0, 2));
		mm.setSelectedItem(date.substring(4, 6));
		yy.setSelectedItem(date.substring(8, 11));
	}

	public static void setGender(JRadioButton m, JRadioButton f, JRadioButton o, String gender) {
		if (gender.equalsIgnoreCase("male")) {
			m.setSelected(true);
			f.setSelected(false);
			o.setSelected(false);
		}
		if (gender.equalsIgnoreCase("female")) {
			m.setSelected(false);
			f.setSelected(true);
			o.setSelected(false);
		}
		if (gender.equalsIgnoreCase("other")) {
			m.setSelected(false);
			f.setSelected(false);
			o.setSelected(true);
		}
	}

	public static void setCurrentDateToDropdown(JComboBox d, JComboBox m, JComboBox y) {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sf.format(new Date());

		d.setSelectedItem(date.substring(0, 2));
		m.setSelectedItem(date.substring(3, 5));
		y.setSelectedItem(date.substring(6, 10));
	}

	public static boolean isBetweenTime() {
		boolean result = false;
		String morning = "";
		String evining = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			morning = sdf.format(new Date()) + " 9:00:00";
			evining = sdf.format(new Date()) + " 18:00:00";

			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

			Date m = sf.parse(morning);
			Date e = sf.parse(evining);

			Date current = new Date();
			System.out.println(m);
			System.out.println(e);
			System.out.println(current);
			if (current.after(m) && current.before(e)) {
				result = true;
			}
			return result;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;

	}

//	public static void main(String args[]) {
//		System.out.println(StaticMethods.isBetweenTime());
//	}
}
