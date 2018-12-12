package com.reading.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class DBQuerys {
	LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>();
	static String primaryKey="";
	Connection con=null;
	String tableName;
	public void set(LinkedHashMap hm,String tableName,Connection con){
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
	public boolean update(LinkedHashMap<String,Object> lhm) {
		StringBuilder sql=new StringBuilder("update table "+tableName+" set");
		primaryKey=(String) lhm.get("id");
		StringBuilder column=new StringBuilder();
		String prefix="";
		for(String key:lhm.keySet()) {
			column.append(prefix+key+"+=");
			column.append("'"+lhm.get(key)+"'");
			prefix=",";
		}
		sql.append(" where id='"+primaryKey+";");
		
		
//		update table tname set columnname="" where columnname="" 
		return false;
	}
	public boolean delete(LinkedHashMap<String,Object> lhm) {
		primaryKey=(String) lhm.get("id");
		StringBuilder sql=new StringBuilder("delete * from "+tableName+" where id='"+primaryKey+"'");
		
		
		return false;
	}
	public boolean createTable() {
		try{
                 StringBuilder sql=new StringBuilder("create table "+tableName+"(");
                 StringBuilder column=new StringBuilder();
                for(String key:hm.keySet()){
                    column.append(key+" "+hm.get(key)+",");
                }
		column.append(")");
                sql.append(column.toString());
		Statement stmt=this.con.createStatement();
                stmt.execute(sql.toString());
                }catch(Exception e){
                    e.printStackTrace();
                }
		return false;
	}
	public ResultSet getData() {
		StringBuilder sql=new StringBuilder("select * from "+tableName);
		try {
			Statement stmt=con.createStatement();
			return stmt.executeQuery(sql.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet getData(HashMap<String,String> data) {
		StringBuilder sql=new StringBuilder("select * from "+tableName+" where ");
		for(String key:data.keySet()) {
			sql.append(key+"='");
			sql.append(data.get(key)+"'");
			
		}
			
		try {
			Statement stmt=con.createStatement();
			return stmt.executeQuery(sql.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
