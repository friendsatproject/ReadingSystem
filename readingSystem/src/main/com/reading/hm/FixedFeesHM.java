package com.reading.hm;

import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.FeesDb;
import com.reading.db.FixedFeesDb;
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

	public FixedFeesHM() {
		LinkedHashMap<String, Object> props = new LinkedHashMap<String, Object>();
		props.put("MONTHLY", SettingsUI.monthTxt.getText());
		props.put("QUARTERLY", SettingsUI.quarterTxt.getText());
		props.put("HALFYEARLY", SettingsUI.halfYearTxt.getText());
		props.put("YEARLY", SettingsUI.yearTxt.getText());

		try {
			if (new FixedFeesDb().getData().next()) {
				if (new FeesDb().update(props)) {
					new ActionTrackerHM("Fees Structure Updated", "ADMIN");
					JOptionPane.showMessageDialog(null, "Fees Structure Updated successfully !", "Fees Updated",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				if (new FeesDb().save(props)) {
					new ActionTrackerHM("Fees Structure Updated", "ADMIN");
					JOptionPane.showMessageDialog(null, "Fees Structure Updated successfully !", "Fees Updated",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
