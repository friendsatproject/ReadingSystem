package com.reading.operaton;

import javax.swing.JTable;
import javax.swing.JTextField;

public class FindTotalAmount {
	
	public FindTotalAmount(JTable table, JTextField text) {
		int amount=0;
		int[] rows = table.getSelectedRows();
		
		for(int i=0;i<=rows.length-1;i++) {
			amount = amount+Integer.parseInt((String) table.getValueAt(rows[i], 3));
		}
		text.setText(amount+"");
	}
}
