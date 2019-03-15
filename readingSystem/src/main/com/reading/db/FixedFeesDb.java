package com.reading.db;

import com.reading.db.DBConnection;
import com.reading.db.DBQuerys;
import java.sql.Connection;
import java.util.LinkedHashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sawant
 */
public class FixedFeesDb extends DBQuerys {
	String tableName = "FIXEDFEES";
	Connection con = null;
	LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>() {
		{
			put("ID", "char(1)");
			put("TYPE", "char(2)");
			put("MONTHLY", "char(7)");
			put("QUARTERLY", "char(7)");
			put("HALFYEARLY", "char(7)");
			put("YEARLY", "char(7)");
		}
	};

	public FixedFeesDb() {
		con = new DBConnection().getConnection();
		set(hm, tableName, con);
	}

//	public static void main(String[] args) {
////		new FixedFeesDb().drop();
//		System.out.println(new FixedFeesDb().createTable());
//	}
}
