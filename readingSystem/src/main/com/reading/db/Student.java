package com.reading.db;

import java.sql.Connection;
import java.util.HashMap;

public class Student extends DBQuerys{
	String tableName="student";
	Connection con=null;
	HashMap hm=new HashMap(){{
		put("name","char(50)");
		put("address","char(50)");
		put("adhar","char(50)");
		put("quialification","char(50)");
		put("join_date","char(50)");
		put("fees_status","char(50)");
	}};
	Student(){
		con=new DBConnection().getConnection();
		set(hm,tableName,con);
	}
}
