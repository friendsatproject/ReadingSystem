package com.reading.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedHashMap;

public class DBConnection {
	public Connection getConnection() {
		try {
			Class.forName ("org.h2.Driver");
			return DriverManager.getConnection ("jdbc:h2:~/test", "sa","sa");
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		LinkedHashMap lhm=new LinkedHashMap();
		lhm.put("ds","dsad");
		lhm.put("ds1","dsad");
		lhm.put("ds2","dsad");
		lhm.put("ds3","dsad");
		lhm.put("ds4","dsad");
		lhm.put("ds5","dsad");
		lhm.put("ds6","dsad");
		
		new Student().save(lhm);
	}
}
