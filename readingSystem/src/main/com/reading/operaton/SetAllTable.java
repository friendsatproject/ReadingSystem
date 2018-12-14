package com.reading.operaton;

import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.reading.db.ExpencesDb;
import com.reading.db.Student;

public class SetAllTable {
	DefaultTableModel model;
	ResultSet rs;

	public void setTable(JTable table) {
		try {
			 model = (DefaultTableModel) table.getModel();
			rs = new Student().getData();
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { ++i, rs.getString(1) + " " + rs.getString(3), rs.getString(5),
						rs.getString(9), rs.getString(6), "Pending" });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
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
}
