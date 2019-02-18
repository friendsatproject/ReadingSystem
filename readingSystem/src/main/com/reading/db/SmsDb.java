package com.reading.db;


import java.sql.Connection;
import java.util.LinkedHashMap;

public class SmsDb extends DBQuerys {
	String tableName = "SMS";
	Connection con = null;
	LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>() {
		{
			put("ID", "char(20) primary key");
			put("MSG", "char(150)");
			put("NUMBER", "char(11)");
			put("STATUS", "char(2)");
		}
	};

	public SmsDb() {
		try {
			con = new DBConnection().getConnection();
			set(hm, tableName, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SmsDb().drop();
////		new SmsDb().createTable();
	}
}