package com.reading.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateTable extends DBQuerys{
	String tableName = "STUDENT";
	List <String>table=new ArrayList<String>();
	
	public CreateTable(Connection con){
		set(null,null, con);
		try {
			con.getSchema();
			DatabaseMetaData md = con.getMetaData();
			ResultSet rs = md.getTables(con.getCatalog(), null, "%", null);
			while (rs.next()) {
			  table.add(rs.getString(3));
			}
			tableVerify(table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
