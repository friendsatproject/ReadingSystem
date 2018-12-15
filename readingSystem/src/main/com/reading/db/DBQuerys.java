package com.reading.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		try {
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
		
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean update(LinkedHashMap<String,Object> lhm) {
		try {
		StringBuilder sql=new StringBuilder("update table "+tableName+" set ");
		primaryKey=(String) lhm.get("ID");
		StringBuilder column=new StringBuilder();
		String prefix="";
		for(String key:lhm.keySet()) {
			column.append(prefix+key+"=");
			column.append("'"+lhm.get(key)+"'");
			prefix=",";
		}
		sql.append(column);
		sql.append(" where id='"+lhm.get("ID")+"';");
		
		System.out.println(sql.toString());
//		update table tname set columnname="" where columnname="" 
		
			Statement stmt=con.createStatement();
			stmt.executeUpdate(sql.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(LinkedHashMap<String,Object> lhm) {
		primaryKey=(String) lhm.get("ID");
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
		return true;
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
	public void drop() {
		try {
			StringBuilder sql=new StringBuilder("drop table "+tableName);
			Statement stmt=con.createStatement();
			stmt.execute(sql.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
