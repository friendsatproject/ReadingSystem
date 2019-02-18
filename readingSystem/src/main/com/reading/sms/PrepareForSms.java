package com.reading.sms;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.reading.db.SmsDb;
import com.reading.db.Student;
import com.reading.feesStatus.FindStatus;
import com.reading.operaton.SetAllTable;
import com.reading.operaton.StaticMethods;

public class PrepareForSms {
	HashMap<String, Integer> totlFees;
	HashMap<String, String> sms;
	SetAllTable st = new SetAllTable();
	ResultSet smsrs;

	public PrepareForSms() {
		if (StaticMethods.isBetweenTime()) {
			try {
				totlFees = st.getTotalFees();
//			smsrs = new SmsDb().getData();
				sms = st.getSmsData();
				HashMap<String, String> dataSms = new HashMap<String, String>();
				HashMap<String, String> data = new HashMap<String, String>();
				data.put("STATUS", "ACTIVE");
				ResultSet rs1;
				rs1 = new Student().getData(data);
				String id = "";
				String s;
				while (rs1.next()) {
					id = rs1.getString(1).trim();
					s = new FindStatus(totlFees.get(rs1.getString(1).trim()), rs1.getString(12).trim(),
							rs1.getString(14).trim(), st.getFees(rs1.getString(12).trim(), rs1.getString(13).trim()))
									.getStatus();
					if (s.equals("PENDING")) {
						System.out.println("entered into pending if");
						if (sms.containsKey(id)) {
							dataSms.clear();
							dataSms.put("ID", id);
							smsrs = new SmsDb().getData(dataSms);
							if (smsrs.next()) {
								if (smsrs.getString(4).trim().equals("N")) {
									HashMap<String, String> props = new HashMap<String, String>();
									props.put("msg", smsrs.getString(2).trim());
									props.put("number", smsrs.getString(3).trim());

									System.out.println("Message sent to : " + smsrs.getString(3).trim());
									new Sms(props);
									
									LinkedHashMap<String, Object> updateHm = new LinkedHashMap<String, Object>();
									updateHm.put("ID", id);
									updateHm.put("STATUS", "Y");
									new SmsDb().update(updateHm);
								}
							}
						} else {
							LinkedHashMap<String, Object> saveHm = new LinkedHashMap<String, Object>();
							saveHm.clear();
							saveHm.put("ID", id);
							saveHm.put("MSG", "Dear " + rs1.getString(2).trim()
									+ " your session has been finished, Please pay fees and continue your service, SUCCESS PARK ABHYASIKA");
							saveHm.put("NUMBER", rs1.getString(8).trim());
							saveHm.put("STATUS", "N");
							new SmsDb().save(saveHm);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
