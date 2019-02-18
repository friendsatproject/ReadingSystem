package com.reading.operaton;

import java.util.LinkedHashMap;

import com.reading.db.Student;

public class Add1000Records {

	LinkedHashMap<String, Object> props = new LinkedHashMap<String, Object>();

	public Add1000Records() {
		for (int i = 1; i <= 1000; i++) {
			
//			try {
//				Thread.currentThread().sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			props.put("ID", i);
			props.put("NAME", "Name"+i);
			props.put("TADDRESS", "Taddress"+i);
			props.put("PADDRESS", "paddress "+i);
			props.put("ADHAR", "adhar"+i);
			props.put("QUALIFICATION", "qualification"+i);
			props.put("GENDER", "other");
			props.put("MOBILE", "8989898989");
			props.put("ALTERNATEMO", "4587896589");
			props.put("PARENTMONO", "8956232589");
			props.put("OCCUPATION", "Employee");
			props.put("ADMISSIONTYPE", "For One Month");
			props.put("SHIFTTYPE", "Day");
			props.put("JOINDATE", "12-12-2018");
			props.put("STATUS", "ACTIVE");

			System.out.println(new Student().save(props));
		}

	}
//	public static void main(String args[]) {
//		new Add1000Records();
//	}
}
