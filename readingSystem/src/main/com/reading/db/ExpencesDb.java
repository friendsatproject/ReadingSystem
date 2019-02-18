package com.reading.db;

import java.sql.Connection;
import java.util.LinkedHashMap;

public class ExpencesDb extends DBQuerys{
	String tableName="EXPENCES";
	Connection con=null;
	LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>(){{
		put("ID","char(20) primary key");
		put("EXPENCETYPE","char(50)");
		put("AMOUNT","char(5)");
		put("DATE","char(12)");
		put("DESCRIPTION","char(50)");
		put("USER","char(20)");
		
	}};
	public ExpencesDb(){
		con=new DBConnection().getConnection();
		set(hm,tableName,con);
	}
//	public static void main(String args[]) {
//		System.out.println(new ExpencesDb().createTable());
//	}
}
