package com.reading.hm;

import java.sql.ResultSet;
import java.util.LinkedHashMap;

import com.reading.db.Student;

public class DeleteStudentHM {
	ResultSet rs;

	public boolean closeStatus(String id) {
		LinkedHashMap<String,Object>record = new LinkedHashMap<String,Object>();
		try {
			record.put("ID", id);
			record.put("STATUS","CLOSED");
			new Student().update(record);
			
//			record.put("ID",rs.getString(1));
//			record.put("FIRSTNAME",rs.getString(2));
//			record.put("MIDDLENAME",rs.getString(3));
//			record.put("LASTNAME",rs.getString(4));
//			record.put("ADDRESS",rs.getString(5));
//			record.put("ADHAR",rs.getString(6));
//			record.put("MOBILE",rs.getString(7));
//			record.put("ALTERNATEMO",rs.getString(8));
//			record.put("PARENTMONO",rs.getString(9));
//			record.put("QUALIFICATION",rs.getString(10));
//			record.put("OCCUPATION",rs.getString(11));
//			record.put("ADMISSIONTYPE",rs.getString(12));
//			record.put("SHIFTTYPE",rs.getString(13));
//			record.put("FEESPAID",rs.getString(14));
//			record.put("REMAININGFEES",rs.getString(14));
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
