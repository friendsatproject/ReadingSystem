package com.reading.operaton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.reading.db.FeesDb;
import com.reading.db.Student;

public class Test {
	public static void main(String args[]) {
		ResultSet rs;
		HashMap<String, String> data=new HashMap<String,String>();
		data.put("ID", "SP112");
		
//		rs = new FeesDb().getData();
		rs = new Student().getData(data);
		try {
			while(rs.next()) {
			
//				System.out.println(rs.getString(1)+"   "+rs.getString(3));//for feesDB
//				for student
				System.out.println(rs.getString(1).trim()+",   "+rs.getString(2).trim()+",   "+rs.getString(3).trim()+",   "+rs.getString(4).trim()
				+",   "+rs.getString(5).trim()+",   "+rs.getString(6).trim()+",   "+rs.getString(7).trim()+",  "+rs.getString(8).trim()+",   "+rs.getString(9).trim()
				+",  "+rs.getString(10).trim()+",   "+rs.getString(11).trim()+",   "+rs.getString(12).trim()+",   "+rs.getString(13).trim()+",   "+rs.getString(14).trim());
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
