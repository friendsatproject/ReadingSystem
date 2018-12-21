package com.reading.operaton;

import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.reading.db.ActionTrackerDb;
import com.reading.db.ExpencesDb;
import com.reading.db.Student;

public class SetAllTable {
	DefaultTableModel model;
	ResultSet rs;
	
//set Active student table
	public void setActiveStudentTable(JTable table) {
		try {
			HashMap<String,String> data = new HashMap<String,String>();
			data.put("STATUS", "ACTIVE");
			 model = (DefaultTableModel) table.getModel();
			rs = new Student().getData(data);
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { ++i, rs.getString(2) + " " + rs.getString(3), rs.getString(5),
						rs.getString(10), rs.getString(7), "Pending", rs.getString(6) });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//set expence table
	public void setExpenceTable(JTable table) {
		try {
			 model = (DefaultTableModel) table.getModel();
			rs = new ExpencesDb().getData();
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] {  rs.getString(1) ,
						rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6)});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//set actiontracker table
	public void setActionTracker(JTable table) {
		try {
			 model = (DefaultTableModel) table.getModel();
			rs = new ActionTrackerDb().getData();
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] {  rs.getString(1) ,
						rs.getString(3), rs.getString(2), rs.getString(4),rs.getString(5)});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
