package com.reading.db;

import java.sql.Connection;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

public class FeesDb extends DBQuerys {
	String tableName = "FEES";
	Connection con = null;
	
	LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>() {
		{
			put("ID", "char(10)");
			put("DATE", "char(10)");
			put("AMOUNT", "char(10)");
			put("RECEIVER", "char(10)");
		}
	};

	public FeesDb() {
		con = new DBConnection().getConnection();
		
		set(hm, tableName, con);
	}
//	public static void main(String[] args) {
//		new FeesDb().drop();
//		if(new FeesDb().createTable()) {
//			JOptionPane.showConfirmDialog(null, "table created");
//		}
//	}
}
