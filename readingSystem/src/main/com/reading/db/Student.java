package com.reading.db;

import java.sql.Connection;
import java.util.LinkedHashMap;

public class Student extends DBQuerys{
	String tableName="student";
	Connection con=null;
	LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>(){{
		put("FIRSTNAME","char(50)");
		put("MIDDLENAME","char(50)");
		put("LASTNAME","char(50)");
		put("ADDRESS","char(50)");
		put("ADHAR","char(50)");
		put("MOBILE","char(50)");
		put("ALTERNATEMO","char(50)");
		put("PARENTMONO","char(50)");
		put("QUALIFICATION","char(50)");
		put("OCCUPATION","char(50)");
		put("ADMISSIONTYPE","char(50)");
		put("SHIFTTYPE","char(50)");
		put("FEESPAID","char(50)");
		put("REMAININGFEES","char(50)");
		put("JOINDATE","char(20)");
	}};
	public Student(){
		con=new DBConnection().getConnection();
		set(hm,tableName,con);
	}
	public static void main(String[] args) {
		new Student().createTable();
	}
}
