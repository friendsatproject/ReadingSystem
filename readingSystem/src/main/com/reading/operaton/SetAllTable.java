package com.reading.operaton;

import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.reading.db.ActionTrackerDb;
import com.reading.db.ExpencesDb;
import com.reading.db.FeesDb;
import com.reading.db.FixedFeesDb;
import com.reading.db.SmsDb;
import com.reading.db.Student;
import com.reading.db.UsersDb;
import com.reading.feesStatus.FindStatus;
import com.reading.operaton.processImage.ProcessImage;
import com.reading.ui.Home;
import com.reading.ui.SettingsUI;
import com.reading.ui.ShowStudentDetails;

public class SetAllTable {

	DefaultTableModel model;
	ResultSet rs;

//set Active student table
	public void setActiveStudentTable(JTable table, HashMap<String, Integer> totlFeesHm) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		try {
//			for (String key : totlFeesHm.keySet()) {
//				System.out.println(totlFeesHm.get(key.trim()) + " : " + key);
//			}
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("STATUS", "ACTIVE");
			model = (DefaultTableModel) table.getModel();
			ResultSet rs1;
			rs1 = new Student().getData(data);

			int i = 0;

			while (rs1.next()) {
//				System.out.println(rs1.getString(1).trim());
				model.addRow(
						new Object[] { ++i, rs1.getString(1).trim(), rs1.getString(2).trim(), rs1.getString(8).trim(),
								rs1.getString(7).trim(), rs1.getString(6).trim(), rs1.getString(11).trim(),
								rs1.getString(5).trim(), rs1.getString(4).trim(), rs1.getString(13).trim(),

								new FindStatus(totlFeesHm.get(rs1.getString(1).trim()), rs1.getString(12).trim(),
										rs1.getString(14).trim(),

										getFees(rs1.getString(12).trim(), rs1.getString(13).trim())

								).getStatus() });
			}
			rs1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// set expence table
	public void setExpenceTable(JTable table) {
		try {
			model = (DefaultTableModel) table.getModel();
			rs = new ExpencesDb().getData();
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { ++i, rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(),
						rs.getString(4).trim(), rs.getString(5).trim(), rs.getString(6).trim() });
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// set actiontracker table
	public void setActionTracker(JTable table) {
		try {
			model = (DefaultTableModel) table.getModel();
			rs = new ActionTrackerDb().getData();
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { ++i, rs.getString(2).trim(), rs.getString(4).trim(), rs.getString(3).trim(),
						rs.getString(5).trim(), rs.getString(6).trim() });
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setClosedAdmissionsTable(JTable table) {
		try {
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("STATUS", "CLOSED");
			model = (DefaultTableModel) table.getModel();
			rs = new Student().getData(data);
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString(1).trim(),
						rs.getString(2).trim() + " " + rs.getString(3).trim() + " " + rs.getString(4).trim(),
						rs.getString(5).trim(), rs.getString(6).trim(), rs.getString(7).trim(), rs.getString(8).trim(),
						rs.getString(9).trim(), });
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setFeesTable(JTable table, String id) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("ID", id);
		try {
			model = (DefaultTableModel) table.getModel();
			rs = new FeesDb().getData(data);
			int i = 0;
			while (rs.next()) {
				model.addRow(
						new Object[] { ++i, rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), });
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setFeesStructureToLable(SettingsUI s) {
		try {
			rs = new FixedFeesDb().getData();
			while (rs.next()) {
				System.out.println(rs.getString(2).trim());
				if (rs.getString(2).trim().equalsIgnoreCase("D")) {
					// set to label
					s.dmLbl.setText(rs.getString(3).trim());
					s.dtLbl.setText(rs.getString(4).trim());
					s.dsLbl.setText(rs.getString(5).trim());
					s.dyLbl.setText(rs.getString(6).trim());

					// set to text area
					s.dmTxt.setText(rs.getString(3).trim());
					s.dtTxt.setText(rs.getString(4).trim());
					s.dsTxt.setText(rs.getString(5).trim());
					s.dyTxt.setText(rs.getString(6).trim());
				}
				if (rs.getString(2).trim().equalsIgnoreCase("N")) {
					// set to label
					s.nmLbl.setText(rs.getString(3).trim());
					s.ntLbl.setText(rs.getString(4).trim());
					s.nsLbl.setText(rs.getString(5).trim());
					s.nyLbl.setText(rs.getString(6).trim());

					// set to text area
					s.nmTxt.setText(rs.getString(3).trim());
					s.ntTxt.setText(rs.getString(4).trim());
					s.nsTxt.setText(rs.getString(5).trim());
					s.nyTxt.setText(rs.getString(6).trim());
				}
				if (rs.getString(2).trim().equalsIgnoreCase("DN")) {
					// set to label
					s.dnmLbl.setText(rs.getString(3).trim());
					s.dntLbl.setText(rs.getString(4).trim());
					s.dnsLbl.setText(rs.getString(5).trim());
					s.dnyLbl.setText(rs.getString(6).trim());

					// set to text area
					s.dnmTxt.setText(rs.getString(3).trim());
					s.dntTxt.setText(rs.getString(4).trim());
					s.dnsTxt.setText(rs.getString(5).trim());
					s.dnyTxt.setText(rs.getString(6).trim());
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUserToTable(JTable table) {
		try {
			model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			rs = new UsersDb().getData();
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { ++i, rs.getString(1).trim(), "*****", rs.getString(3).trim(),
						rs.getString(4).trim(), rs.getString(5).trim(), rs.getString(6).trim(), rs.getString(7).trim(),
						rs.getString(8).trim(), rs.getString(9).trim(), rs.getString(10).trim(),
						rs.getString(11).trim(), rs.getString(12).trim(), rs.getString(13).trim() });
				// set to dropdownlist
				SettingsUI.selectUserCmb.addItem(rs.getString(1).trim());
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUsetToFields(String id, SettingsUI sui) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("ID", id);
		try {
			rs = new UsersDb().getData(data);
			rs.next();
			sui.uidTxt.setText(rs.getString(1).trim());
			sui.passwordTxt.setText(rs.getString(2).trim());
			sui.nameTxt.setText(rs.getString(3).trim());
			sui.addressTxt.setText(rs.getString(4).trim());
			sui.moNoTxt.setText(rs.getString(5).trim());
			sui.ulternateMoNoTxt.setText(rs.getString(6).trim());
			// set gender
			StaticMethods.setGender(sui.male1, sui.female1, sui.other1, rs.getString(7).trim());

//			String gender = rs.getString(7).trim();
//			if (gender.equals("MALE")) {
//				sui.male1.setSelected(true);
//				sui.female1.setSelected(false);
//				sui.other1.setSelected(false);
//			}
//			if (gender.equals("FEMALE")) {
//				sui.female1.setSelected(true);
//				sui.male1.setSelected(false);
//				sui.other1.setSelected(false);
//			}
//			if (gender.equals("OTHER")) {
//				sui.female1.setSelected(false);
//				sui.male1.setSelected(false);
//				sui.other1.setSelected(true);
//			}
			sui.adharTxt.setText(rs.getString(8).trim());
			sui.qualificationTxt.setText(rs.getString(9).trim());
			sui.occupationTxt.setText(rs.getString(10).trim());
			// set date
			StaticMethods.setDate(sui.dd1, sui.mm1, sui.yy1, rs.getString(11).trim());
//			String date =(rs.getString(11).trim());
//			sui.dd1.setSelectedItem(date.substring(0,2));
//			sui.mm1.setSelectedItem(date.substring(4,6));
//			sui.yy1.setSelectedItem(date.substring(8,11));

			sui.sallaryTxt.setText(rs.getString(12).trim());

			if (rs.getString(13).equals("User")) {
				sui.userTypeCmb.setSelectedIndex(0);
			} else {
				sui.userTypeCmb.setSelectedIndex(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setStudentToFields(String studentId, ShowStudentDetails ssd) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("ID", studentId);
		try {
			rs = new Student().getData(data);
			rs.next();
			// to labale
			ssd.idLbl.setText(rs.getString(1).trim());
			ssd.nameLbl.setText(rs.getString(2).trim());
			ssd.tAddressLbl.setText(rs.getString(3).trim());
			ssd.pAddressLbl.setText(rs.getString(4).trim());
			ssd.adharLbl.setText(rs.getString(5).trim());
			ssd.qualificationLbl.setText(rs.getString(6).trim());
			ssd.genderLbl.setText(rs.getString(7).trim());
			ssd.monoLbl.setText(rs.getString(8).trim());
			ssd.altMoNoLbl.setText(rs.getString(9).trim());
			ssd.parentMoNoLbl.setText(rs.getString(10).trim());
			ssd.occupationLbl.setText(rs.getString(11).trim());
			ssd.admissionTypeLbl.setText(rs.getString(12).trim());
			ssd.shiftTypeLbl.setText(rs.getString(13).trim());
			ssd.joinDateLbl.setText(rs.getString(14).trim());

			// to textField
			ssd.idTxt.setText(rs.getString(1).trim());
			ssd.nameTxt.setText(rs.getString(2).trim());
			ssd.tempAddress.setText(rs.getString(3).trim());
			ssd.permenentAddress.setText(rs.getString(4).trim());
			ssd.adharTxt.setText(rs.getString(5).trim());
			ssd.qualificationTxt.setText(rs.getString(6).trim());
			StaticMethods.setGender(ssd.maleRdo, ssd.femaleRdo, ssd.otherRdo, rs.getString(7).trim());
			ssd.mobileNoTxt.setText(rs.getString(8).trim());
			ssd.alternateMoNoTxt.setText(rs.getString(9).trim());
			ssd.parentMoNoTxt.setText(rs.getString(10).trim());
			ssd.occupationTxt.setText(rs.getString(11).trim());
			ssd.admissionTypeTxt.setSelectedItem(rs.getString(12).trim());
			ssd.shiftTypeCmb.setSelectedItem(rs.getString(13).trim());
			StaticMethods.setDate(ssd.ddCmb, ssd.mmCmb, ssd.yyyyCmb, rs.getString(14).trim());
			new ProcessImage().getImage(rs.getString(1).trim(), ssd.updateImageLbl, ssd.showImageLbl);// set image
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Integer> getTotalFees() {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		try {
			rs = new FeesDb().getData();
			int i = 0;
			while (rs.next()) {
				String id = rs.getString(1).trim();
				System.out.println(id);
				
				if (hm.containsKey(id)) {
//					int oldFees = hm.get(id);
					int newFees = hm.get(id) + Integer.parseInt(rs.getString(3).trim());
					hm.put(id, newFees);
				} else {
					hm.put(rs.getString(1).trim(), Integer.parseInt(rs.getString(3).trim()));
				}

			}
			rs.close();
			return hm;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public void setHomeInfo() {
		int pending = 0;
		int finished = 0;
		int active = 0;
		int closed = 0;
		String name;
		String status;
		Home.nameCmb.removeAllItems();
		HashMap<String, Integer> hm = getTotalFees();
		ResultSet rs2;
		try {
			rs2 = new Student().getData();
			while (rs2.next()) {
				String ac = rs2.getString(15).trim();
				name = rs2.getString(2).trim() + " - " + rs2.getString(1).trim();
				Home.nameCmb.addItem(name);
				System.out.println((rs2.getString(1).trim()));
				status = new FindStatus(hm.get(rs2.getString(1).trim()), rs2.getString(12).trim(),
						rs2.getString(14).trim(), getFees(rs2.getString(12).trim(), rs2.getString(13).trim()))
								.getStatus();
				if (status.equals("PENDING") && ac.equals("ACTIVE")) {
					pending = pending + 1;
				}
//				if (status.equals("PAID")) {
//					finished = finished + 1;
//				}
				if (ac.equals("ACTIVE")) {
					active = active + 1;
				}
				if (ac.equals("CLOSED")) {
					closed = closed + 1;
				}
			}

			Home.closedLbl.setText(closed + "");
			Home.activeLbl.setText(active + "");
			Home.pendingLbl.setText(pending + "");
			rs2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean feesIsInTable() {// this decides fees have to update or save in fixed fees db
		try {
			int i = 0;
			rs = new FixedFeesDb().getData();
			while (rs.next()) {
				i++;
			}
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getFees(String period, String shift) {// fees from FisedFees table for new admission
		HashMap<String, String> data = new HashMap<String, String>();
		int p = 0;
		String s = "";
		switch (period) {
		case "For One Month":
			p = 3;
			break;
		case "For Three Month":
			p = 4;
			break;
		case "For Six Month":
			p = 5;
			break;
		case "For Year":
			p = 6;
		}
		switch (shift) {
		case "Day":
			s = "D";
			break;
		case "Day-Night":
			s = "DN";
			break;
		case "Night":
			s = "N";
			break;
		case "D":
			s = "D";
			break;
		case "DN":
			s = "DN";
			break;
		case "N":
			s = "N";
			break;
		}
		data.put("TYPE", s);
		try {
			rs = new FixedFeesDb().getData(data);
			String value = null;
			while (rs.next()) {

				value = rs.getString(p).trim();
//				System.out.println(value);
			}
			return value;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fees Structure not updated!", "Error Message",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

	public HashMap<String, String> getSmsData() {
		HashMap<String, String> hm1 = new HashMap<String, String>();
		ResultSet rs3;
		try {
			rs3 = new SmsDb().getData();
			
			while (rs3.next()) {
				hm1.put(rs3.getString(1).trim(), rs3.getString(4).trim());

			}
			rs3.close();
			return hm1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
}
