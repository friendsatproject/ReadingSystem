package com.reading.operaton;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.reading.db.FeesDb;
import com.reading.db.Student;

public class ImportExcel {

	String path="C:\\Users\\Sawant\\Desktop\\ex.xlsx";

	public ImportExcel() {

		LinkedHashMap<String, Object> record = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> fees = new LinkedHashMap<String, Object>();
		try {

			File file = new File(path);
//			FileInputStream is = new FileInputStream(file);
			
			
//			Workbook wb = new XSSFWorkbook(is);
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			Row row;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				record.put("ID", "SP"+row.getCell(0).getStringCellValue());
				record.put("NAME", row.getCell(1).getStringCellValue());
				record.put("TADDRESS", row.getCell(2).getStringCellValue());
				record.put("PADDRESS", row.getCell(2).getStringCellValue());
				
				record.put("ADHAR", "");
				record.put("QUALIFICATION", "");
				record.put("GENDER", "Other");
				
				record.put("MOBILE", row.getCell(3).getStringCellValue());
				
				record.put("ALTERNATEMO", row.getCell(3).getStringCellValue());
				record.put("PARENTMONO", row.getCell(3).getStringCellValue());
				
				record.put("OCCUPATION", "Student");
				record.put("ADMISSIONTYPE", "For One Month");
				record.put("SHIFTTYPE", row.getCell(4).getStringCellValue());
				record.put("JOINDATE", row.getCell(5).getStringCellValue());
				record.put("STATUS", "ACTIVE");
				
				

				fees.put("ID", "SP"+row.getCell(0).getStringCellValue());
				fees.put("DATE", row.getCell(5).getStringCellValue());
				fees.put("AMOUNT", row.getCell(8).getStringCellValue());
				fees.put("RECEIVER", row.getCell(7).getStringCellValue());

				new Student().save(record);
				new FeesDb().save(fees);

			}
			JOptionPane.showMessageDialog(null, "Data Imported Successfuly", "Data imported",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Something went wrong ", "Data import failed",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		new ImportExcel();
	}
}
