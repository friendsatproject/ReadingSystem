package com.reading.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class DBQuerys {
	HashMap hm=new HashMap();
	Connection con=null;
	String tableName;
	public void set(HashMap hm,String tableName,Connection con){
		this.hm=hm;
		this.tableName=tableName;
		this.con=con;
		
	}
	public boolean save(LinkedHashMap<String,Object> lhm) { 
		
		StringBuilder sql=new StringBuilder("insert into "+tableName+"(");
		StringBuilder column=new StringBuilder();
		StringBuilder values=new StringBuilder();
		String prefix="";
		for(String key:lhm.keySet()) {
			column.append(prefix+key);
			values.append(prefix+"'"+lhm.get(key)+"'");
			prefix=",";
		}
		column.append(") values(");
		sql.append(column);
		sql.append(values);
		sql.append(");");
		try {
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update() {
		StringBuilder sql=new StringBuilder("update table "+tableName+" set");
//		update table tname set columnname="" where columnname="" 
		return false;
	}
	public boolean delete() {
		return false;
	}
	public boolean createTable() {
		return false;
	}

}
