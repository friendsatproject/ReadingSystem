package com.reading.hm;

import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.FeesDb;
import com.reading.db.FixedFeesDb;
import com.reading.operaton.SetAllTable;
import com.reading.ui.SettingsUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sawant
 */
public class FixedFeesHM {

	boolean d, n, dn;

	public FixedFeesHM(SettingsUI s) {
		LinkedHashMap<String, Object> hmd = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> hmn = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> hmdn = new LinkedHashMap<String, Object>();

		hmd.put("ID", "1");
		hmd.put("TYPE", "D");
		hmd.put("MONTHLY", s.dmTxt.getText());
		hmd.put("QUARTERLY", s.dtTxt.getText());
		hmd.put("HALFYEARLY", s.dsTxt.getText());
		hmd.put("YEARLY", s.dyTxt.getText());

		hmn.put("ID", "2");
		hmn.put("TYPE", "N");
		hmn.put("MONTHLY", s.nmTxt.getText());
		hmn.put("QUARTERLY", s.ntTxt.getText());
		hmn.put("HALFYEARLY", s.nsTxt.getText());
		hmn.put("YEARLY", s.nyTxt.getText());

		hmdn.put("ID", "3");
		hmdn.put("TYPE", "DN");
		hmdn.put("MONTHLY", s.dnmTxt.getText());
		hmdn.put("QUARTERLY", s.dntTxt.getText());
		hmdn.put("HALFYEARLY", s.dnsTxt.getText());
		hmdn.put("YEARLY", s.dnyTxt.getText());

		if (new SetAllTable().feesIsInTable()) {
			n = new FixedFeesDb().update(hmn);
			d = new FixedFeesDb().update(hmd);
			dn = new FixedFeesDb().update(hmdn);
		}else {
			n = new FixedFeesDb().save(hmn);
			d = new FixedFeesDb().save(hmd);
			dn = new FixedFeesDb().save(hmdn);
		}

		try {
			if (d && n && dn) {
				new ActionTrackerHM("Fees Structure Updated", "ADMIN");
				JOptionPane.showMessageDialog(null, "Fees Structure Updated successfully !", "Fees Updated",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
