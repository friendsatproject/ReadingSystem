package com.reading.hm;

import java.util.LinkedHashMap;

import com.reading.db.UsersDb;

public class UpdateStudentHM {

	public UpdateStudentHM(LinkedHashMap<String,Object> oldDataHm) {
		
		if(new UsersDb().update(oldDataHm));
		
	}
}
