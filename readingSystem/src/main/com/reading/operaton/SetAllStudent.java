package com.reading.operaton;

import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.reading.db.Student;

public class SetAllStudent {
	DefaultTableModel model;
	ResultSet rs;

//	public HashMap<String,String> data = new HashMap<String,String>();
//	public HashMap<String,String> getAllStudentHM() {
//		try {
//			rs = new Student().getData();
//			while (rs.next()) {
//						data.put("FIRSTNAME", rs.getString(1));
//						data.put("MIDDLENAME", rs.getString(2));
//						data.put("LASTNAME", rs.getString(3));
//						data.put("ADDRESS", rs.getString(4));
//						data.put("ADHAR", rs.getString(5));
//						data.put("MOBILE", rs.getString(6));
//						data.put("ALTERNATEMO", rs.getString(7));
//						data.put("PARENTMONO", rs.getString(8));
//						data.put("QUALIFICATION", rs.getString(9));
//						data.put("OCCUPATION", rs.getString(10));
//						data.put("ADMISSIONTYPE", rs.getString(11));
//						data.put("SHIFTTYPE", rs.getString(12));
//						data.put("FEESPAID", rs.getString(13));
//						data.put("REMAININGFEES", rs.getString(14));
//			}
//		} catch (Exception e) {
//			e.getMessage();
//		}
//		return data;
//	}
	public void setTable(JTable table) {
		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
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
}
