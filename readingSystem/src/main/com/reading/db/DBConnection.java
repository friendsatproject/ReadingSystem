package com.reading.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedHashMap;

public class DBConnection {
	public Connection getConnection() {
		try {
//			Class.forName ("org.h2.Driver");
			
		     Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection c = DriverManager.getConnection("jdbc:hsqldb:http://localhost/sp", "SA", "");
			System.out.println(c);
			
			return c;
//			return DriverManager.getConnection ("jdbc:h2:~/test", "sa","sa");
//			 Class.forName("org.hsqldb.jdbc.JDBCDriver");
//	         return DriverManager.getConnection("jdbc:hsqldb:hsql", "SA", "");
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
//	public static void main(String[] args) {
//		LinkedHashMap lhm=new LinkedHashMap();
//		lhm.put("ds","dsad");
//		lhm.put("ds1","dsad");
//		lhm.put("ds2","dsad");
//		lhm.put("ds3","dsad");
//		lhm.put("ds4","dsad");
//		lhm.put("ds5","dsad");
//		lhm.put("ds6","dsad");
//		
//		new Student().save(lhm);
//	}
}

//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DBConnection {
//   public static void main(String[] args) {
//      Connection con = null;
//      
//      try {
//         //Registering the HSQLDB JDBC driver
////         Class.forName("org.hsqldb.jdbc.JDBCDriver");
//         //Creating the connection with HSQLDB
//         con = DriverManager.getConnection("jdbc:hsqldb:hsql:file:testdb", "SA", "");
//         if (con!= null){
//            System.out.println("Connection created successfully");
//            
//         }else{
//            System.out.println("Problem with creating connection");
//         }
//      
//      }  catch (Exception e) {
//         e.printStackTrace(System.out);
//      }
//   }
//}
