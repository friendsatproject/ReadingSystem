package com.reading.db;

import java.sql.Connection;
import java.util.LinkedHashMap;

public class ActionTrackerDb extends DBQuerys{
	String tableName="ACTIONTRACKER";
	Connection con=null;
	LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>(){{
		put("ID","char(10) primary key");
		put("DATE","char(10)");
		put("ACTION","char(50)");
		put("TIME","char(10)");
		put("USER","char(20)");
		put("REFERENCE","char(15)");
		
	}};
	public ActionTrackerDb(){
		con=new DBConnection().getConnection();
		set(hm,tableName,con);
	}
//	public static void main(String[] args) {
//		new Student().drop();
//		if(new ActionTrackerDb().createTable()) {
//			JOptionPane.showConfirmDialog(null, "table created");
//		}
//	}
}
