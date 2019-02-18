/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reading.summary;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.reading.db.ExpencesDb;
import com.reading.db.FeesDb;
import com.reading.db.Student;
import com.reading.ui.SummaryUi;

/**
 *
 * @author Sawant
 */
public class Summary {

	Date toDate;
	Date fromDate, date;

	ResultSet rs;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	int expenceAmt = 0;
	int adminssions = 0;
	int incomeAmt = 0;

	public Summary(String from, String to) {
		try {
			fromDate = formatter.parse(from);
			toDate = formatter.parse(to);
			System.out.println(fromDate + "\n" + toDate);
			getExpenceAmount();
			getTotalAdmissions();
			getIncomeAmt();
			getProfit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getExpenceAmount() {
		String d;
		try {
			rs = new ExpencesDb().getData();
			while (rs.next()) {
				d = rs.getString(4).trim();
				date = formatter.parse(d);
				if (date.before(toDate) && date.after(fromDate)) {
					expenceAmt = expenceAmt + Integer.parseInt(rs.getString(3).trim());
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SummaryUi.expenceAmount.setText(expenceAmt + "");
	}

	public void getTotalAdmissions() {
		String d;
		try {
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("STATUS", "ACTIVE");
			rs = new Student().getData(data);
			while (rs.next()) {
				d = rs.getString(14).trim();
				date = formatter.parse(d);
				if (date.before(toDate) && date.after(fromDate)) {
					adminssions = adminssions + 1;
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SummaryUi.adminssionCount.setText(adminssions + "");
	}

	public void getIncomeAmt() {
		String d;
		try {
			rs = new FeesDb().getData();
			while (rs.next()) {
				d = rs.getString(2).trim();
				date = formatter.parse(d);
				if (date.before(toDate) && date.after(fromDate)) {
					incomeAmt = incomeAmt + Integer.parseInt(rs.getString(3).trim());
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SummaryUi.incomeAmt.setText(incomeAmt + "");
	}

	public void getProfit() {
		SummaryUi.profit.setText(incomeAmt - expenceAmt + "");
	}
}
