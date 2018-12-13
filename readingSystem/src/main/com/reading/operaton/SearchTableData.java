package com.reading.operaton;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class SearchTableData {
	Vector originalTableModel;
	DocumentListener documentListener;
	JTextField text;
	JTable table;

	public SearchTableData(JTextField text,JTable table) {
		this.text=text;
		this.table=table;
		originalTableModel = (Vector) ((DefaultTableModel) table.getModel()).getDataVector().clone();
		text.getDocument().addDocumentListener(documentListener);

	    documentListener = new DocumentListener() {
	        public void changedUpdate(DocumentEvent documentEvent) {
	            search();
	        }

	        public void insertUpdate(DocumentEvent documentEvent) {
	            search();
	        }

	        public void removeUpdate(DocumentEvent documentEvent) {
	            search();
	        }

	        private void search() {
	            searchTableContents(text.getText());
	        }
	    };
	    text.getDocument().addDocumentListener(documentListener);
	    
	}
	public void searchTableContents(String searchString) {
	    DefaultTableModel currtableModel = (DefaultTableModel) table.getModel();
	    //To empty the table before search
	    currtableModel.setRowCount(0);
	    //To search for contents from original table content
	    for (Object rows : originalTableModel) {
	        Vector rowVector = (Vector) rows;
	        for (Object column : rowVector) {
	            if (column.toString().contains(searchString)) {
	                //content found so adding to table
	                currtableModel.addRow(rowVector);
	                break;
	            }
	        }

	    }
	}
}
