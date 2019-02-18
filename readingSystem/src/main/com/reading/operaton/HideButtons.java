package com.reading.operaton;

import java.awt.Dimension;

import com.reading.ui.Home;

public class HideButtons {

	public HideButtons() {
//		Home.closeAdmissionBtn.setPreferredSize(new Dimension(0, 0));
//		Home.traceActionBtn.setPreferredSize(new Dimension(0, 0));
//		
//		Home.summaryBtn.setPreferredSize(new Dimension(0, 0));
//		Home.SettingBtn.setPreferredSize(new Dimension(0, 0));
		
		Home.closeAdmissionBtn.setEnabled(false);
		Home.traceActionBtn.setEnabled(false);
		
		Home.summaryBtn.setEnabled(false);
		Home.SettingBtn.setEnabled(false);
		Home.summaryBtn.setEnabled(false);
	}
}
