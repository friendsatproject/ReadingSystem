package com.reading.operaton;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.reading.db.FeesDb;
import com.reading.db.Student;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class ImportExcel {

	String path;// = "C:\\Users\\Sawant\\Desktop\\Old Record File.xlsx";

	public ImportExcel(String path,JTextArea console) {
                this.path=path;
                console.setBorder(BorderFactory.createEmptyBorder(0,1,1,1));
		LinkedHashMap<String, Object> record = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> fees = new LinkedHashMap<String, Object>();
		try {

			File file = new File(path);
//			FileInputStream is = new FileInputStream(file);

//			Workbook wb = new XSSFWorkbook(is);
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			Row row;
			for (int i = 4; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				record.put("ID", "SP" + row.getCell(0).getStringCellValue());
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
				record.put("JOINDATE", getFormatedDate(row.getCell(5)));
				record.put("STATUS", "ACTIVE");

				fees.put("ID", "SP" + row.getCell(0).getStringCellValue());
				fees.put("DATE", getFormatedDate(row.getCell(5)));
				fees.put("AMOUNT", row.getCell(8).getStringCellValue());
				fees.put("RECEIVER", row.getCell(7).getStringCellValue());

				new Student().save(record);
				new FeesDb().save(fees);
                                
                                console.setText(console.getText()+ fees.get("ID"));
				System.out.println(record + "   " + fees);

			}
			JOptionPane.showMessageDialog(null, "Data Imported Successfuly", "Data imported",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Something went wrong ", "Data import failed",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public String getFormatedDate(Cell cell) {
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		switch (cell.getCellType()) {
		case NUMERIC:
			String d = dt.format(cell.getDateCellValue());
			return d;
			
		case STRING:
			return cell.getStringCellValue();
		}
		return "";
	}

//	public static void main(String args[]) {
//		new ImportExcel();
//	}
}
