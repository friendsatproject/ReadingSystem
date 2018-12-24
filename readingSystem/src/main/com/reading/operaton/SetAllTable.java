package com.reading.operaton;

import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.reading.db.ActionTrackerDb;
import com.reading.db.ExpencesDb;
import com.reading.db.FeesDb;
import com.reading.db.Student;
import com.reading.db.UsersDb;
import com.reading.ui.SettingsUI;

public class SetAllTable {
	DefaultTableModel model;
	ResultSet rs;

//set Active student table
	public void setActiveStudentTable(JTable table) {
		try {
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("STATUS", "ACTIVE");
			model = (DefaultTableModel) table.getModel();
			rs = new Student().getData(data);
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString(1), rs.getString(2) + " " + rs.getString(3), rs.getString(5),
						rs.getString(10), rs.getString(7), "Pending", rs.getString(6) });
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// set expence table
	public void setExpenceTable(JTable table) {
		try {
			model = (DefaultTableModel) table.getModel();
			rs = new ExpencesDb().getData();
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6) });
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// set actiontracker table
	public void setActionTracker(JTable table) {
		try {
			model = (DefaultTableModel) table.getModel();
			rs = new ActionTrackerDb().getData();
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString(1), rs.getString(3), rs.getString(2), rs.getString(4),
						rs.getString(5) });
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setClosedAdmissionsTable(JTable table) {
		try {
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("STATUS", "CLOSED");
			model = (DefaultTableModel) table.getModel();
			rs = new Student().getData(data);
			int i = 0;
			while (rs.next()) {
				model.addRow(
						new Object[] { rs.getString(1), rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), });
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setFeesTable(JTable table, String id) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("ID", id);
		try {
			model = (DefaultTableModel) table.getModel();
			rs = new FeesDb().getData(data);
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { ++i, rs.getString(2), rs.getString(3), rs.getString(4), });
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setFeesStructureToLable() {
		try {
			rs = new FeesDb().getData();
			rs.next();
			// set to lable
			SettingsUI.monthLbl.setText(rs.getString(1));
			SettingsUI.quarterLbl.setText(rs.getString(2));
			SettingsUI.halfYearLbl.setText(rs.getString(3));
			SettingsUI.yearLbl.setText(rs.getString(4));

			// set to text area
			SettingsUI.monthTxt.setText(rs.getString(1));
			SettingsUI.quarterTxt.setText(rs.getString(2));
			SettingsUI.halfYearTxt.setText(rs.getString(3));
			SettingsUI.yearTxt.setText(rs.getString(4));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUserToTable(JTable table, JComboBox jcb) {
		try {
			model = (DefaultTableModel) table.getModel();
			rs = new UsersDb().getData();
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { 
						++i, 
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9),
						rs.getString(10), 
						rs.getString(11), 
						rs.getString(12), 
						rs.getString(13)});
				// set to dropdownlist
				SettingsUI.selectUserCmb.addItem(rs.getString(1));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUsetToFields(String id, SettingsUI sui) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("ID", id);
		try {
			rs = new UsersDb().getData(data);
			rs.next();
			sui.uidTxt.setText(rs.getString(1));
			sui.passwordTxt.setText(rs.getString(2));
			sui.nameTxt.setText(rs.getString(3));
			sui.addressTxt.setText(rs.getString(4));
			sui.moNoTxt.setText(rs.getString(5));
			sui.ulternateMoNoTxt.setText(rs.getString(6));
			sui.genderTxt.setText(rs.getString(7));
			sui.adharTxt.setText(rs.getString(8));
			sui.qualificationTxt.setText(rs.getString(9));
			sui.occupationTxt.setText(rs.getString(10));
			sui.joinDateTxt.setText(rs.getString(11));
			sui.sallaryTxt.setText(rs.getString(12));
			if (rs.getString(13).equals("User")) {
				sui.userTypeCmb.setSelectedIndex(0);
			} else {
				sui.userTypeCmb.setSelectedIndex(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
