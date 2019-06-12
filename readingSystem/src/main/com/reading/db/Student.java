package com.reading.db;

import java.sql.Connection;
import java.util.LinkedHashMap;

public class Student extends DBQuerys {
	String tableName = "STUDENT";
	Connection con = null;
	LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>() {
		{
			put("ID", "char(20) primary key");		//1
			put("NAME", "char(50)");				//2
			put("TADDRESS", "char(150)");			//3
			put("PADDRESS", "char(150)");			//4	
			
			put("ADHAR", "char(12)");				//5
			put("QUALIFICATION", "char(70)");		//6
			put("GENDER", "char(7)");				//7
			
			put("MOBILE", "char(10)");				//8
			put("ALTERNATEMO", "char(10)");			//9
			put("PARENTMONO", "char(10)");			//10
			
			put("OCCUPATION", "char(70)");			//11

			put("ADMISSIONTYPE", "char(15)");		//12
			put("SHIFTTYPE", "char(10)");			//13

			put("JOINDATE", "char(12)");			//14
			put("STATUS", "char(7)");				//15
			
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
////		String path=System.getProperty("System.dir");
////		String str[]= {};
////		new org.hsqldb.server.WebServer().main(str);
////		new Student().drop();
//		new Student().createTable();
//	}
}
