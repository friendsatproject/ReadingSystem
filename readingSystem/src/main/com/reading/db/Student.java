package com.reading.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;

public class Student extends DBQuerys {
	String tableName = "STUDENT";
	Connection con = null;
	LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>() {
		{
			put("ID", "char(20) primary key");
			put("NAME", "char(50)");
			put("TADDRESS", "char(70)");
			put("PADDRESS", "char(70)");

			put("ADHAR", "char(12)");
			put("QUALIFICATION", "char(50)");
			put("GENDER", "char(7)");
			
			put("MOBILE", "char(10)");
			put("ALTERNATEMO", "char(10)");
			put("PARENTMONO", "char(10)");
			
			put("OCCUPATION", "char(20)");

			put("ADMISSIONTYPE", "char(15)");
			put("SHIFTTYPE", "char(10)");

			put("JOINDATE", "char(12)");
			put("STATUS", "char(7)");
		}
	};

	public Student() {
		try {
			con = new DBConnection().getConnection();
			set(hm, tableName, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		new Student().drop();
//		new Student().createTable();
//	}
}
