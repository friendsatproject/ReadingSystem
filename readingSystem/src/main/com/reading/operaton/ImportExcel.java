package com.reading.operaton;

import java.io.File;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.reading.db.FeesDb;
import com.reading.db.Student;

public class ImportExcel {

	String path;// = "C:\\Users\\Sawant\\Desktop\\Old Record File.xlsx";
	ResultSet rs;

	public ImportExcel(String path, JTextArea console) {
		this.path = path;
		console.setBorder(BorderFactory.createEmptyBorder(0, 1, 1, 1));
		LinkedHashMap<String, Object> record = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> fees = new LinkedHashMap<String, Object>();
		HashMap<String, String> oldData = new HashMap<String, String>();
		int duplicateCount = 0;
		try {
			rs = new Student().getData();
			while (rs.next()) {
				oldData.put(rs.getString(1).trim(), rs.getString(2).trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			File file = new File(path);
//			FileInputStream is = new FileInputStream(file);

//			Workbook wb = new XSSFWorkbook(is);
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			Row row;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				String neme = row.getCell(1).getStringCellValue().trim();

				boolean matched = false;
				for (String key : oldData.keySet()) {
					if (neme.equalsIgnoreCase(oldData.get(key))) {
						matched = true;
						duplicateCount++;
					}
				}
				if (!matched) {
					record.put("ID", "SP" + row.getCell(0).getStringCellValue());
					record.put("NAME", row.getCell(1).getStringCellValue());
					record.put("TADDRESS", row.getCell(2).getStringCellValue());
					record.put("PADDRESS", "");
					record.put("ADHAR", "");
					record.put("QUALIFICATION", "");
					record.put("GENDER", "Other");
					record.put("MOBILE", "");// .getStringCellValue());
					record.put("ALTERNATEMO", "");
					record.put("PARENTMONO", "");
					record.put("OCCUPATION", "");
					record.put("ADMISSIONTYPE", "For One Month");
					record.put("SHIFTTYPE", row.getCell(4).getStringCellValue());
					record.put("JOINDATE", getFormatedvalue(row.getCell(5)));
					record.put("STATUS", "ACTIVE");

					fees.put("ID", "SP" + row.getCell(0).getStringCellValue());
					fees.put("DATE", getFormatedvalue(row.getCell(5)));
					fees.put("AMOUNT", getStringAmount(row.getCell(8)));
					fees.put("RECEIVER", row.getCell(7).getStringCellValue());
					fees.put("MONTH", record.get("JOINDATE").toString().substring(3,5));

					new Student().save(record);
					new FeesDb().save(fees);

					console.setText(console.getText() + i + ". " + fees.get("ID") + "\n");
//					System.out.println(record + "   " + fees);
				}

			}
			JOptionPane.showMessageDialog(null,
					"Data Imported Successfuly\n" + duplicateCount + " duplicate records skiped", "Data imported",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Something went wrong ", "Data import failed",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public String getFormatedvalue(Cell cell) {
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

	private String getStringAmount(Cell cell) {
		if (cell.getCellType() == CellType.NUMERIC) {
			String value = cell.getNumericCellValue() + "";
			value = value.replace(".0", "");
			return value;
		}else {
			return cell.getStringCellValue() ;
		}
	}

//	public static void main(String args[]) {
//		new ImportExcel();
//	}
}
