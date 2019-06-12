package com.reading.db;

import java.sql.Connection;
import java.util.LinkedHashMap;

public class UsersDb extends DBQuerys{
	String tableName="USER";
	Connection con=null;
	LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>(){{
		put("ID","char(20) primary key");
		put("PASSWORD","char(33)");
		put("NAME","char(150)");
		put("ADDRESS","char(150)");
		put("MOBILE","char(10)");
		put("ALTERNATEMO","char(10)");
		put("GENDER","char(6)");
		put("ADHAR","char(12)");
		put("QUALIFICATION","char(150)");
		put("OCCUPATION","char(120)");
		put("JOINDATE","char(12)");
		put("SALLARY","char(6)");
		put("USERTYPE","char(6)");
	}};
	public UsersDb(){
		con=new DBConnection().getConnection();
		set(hm,tableName,con);
	}
}
