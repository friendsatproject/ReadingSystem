package com.reading.db;

import java.sql.Connection;
import java.util.LinkedHashMap;

public class ExpencesDb extends DBQuerys{
	String tableName="EXPENCES";
	Connection con=null;
	LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>(){{
		put("ID","char(20) primary key");
		put("EXPENCETYPE","char(50)");
		put("AMOUNT","char(50)");
		put("DATE","char(50)");
		put("DESCRIPTION","char(50)");
		put("USER","char(50)");
		 
	}};
	public ExpencesDb(){
		con=new DBConnection().getConnection();
		set(hm,tableName,con);
	}
}
