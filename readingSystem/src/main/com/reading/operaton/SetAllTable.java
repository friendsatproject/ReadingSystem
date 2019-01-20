package com.reading.operaton;

import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.reading.db.ActionTrackerDb;
import com.reading.db.ExpencesDb;
import com.reading.db.FeesDb;
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
	public void setActiveStudentTable(JTable table,HashMap<String,Integer> totlFeesHm) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		try {
			for(String key:totlFeesHm.keySet()) {
				System.out.println(totlFeesHm.get(key.trim())+" : "+key);
			}
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("STATUS", "ACTIVE");
			model = (DefaultTableModel) table.getModel();
			rs = new Student().getData(data);
			int i = 0;
			
			while (rs.next()) {
				model.addRow(new Object[] { 
						++i,
						rs.getString(1).trim(),
						rs.getString(2).trim(), 
						rs.getString(8).trim(),
						rs.getString(7).trim(),
						rs.getString(6).trim(),
						rs.getString(11).trim(),
						rs.getString(5).trim(),
						rs.getString(4).trim(),
						rs.getString(13).trim(), 
						
						new FindStatus(totlFeesHm.get(rs.getString(1).trim()), rs.getString(12).trim(), rs.getString(14).trim()).getStatus() 
						});
			}
			rs.close();
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
				model.addRow(new Object[] { ++i,rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(),
						rs.getString(5).trim(), rs.getString(6).trim() });
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
				model.addRow(new Object[] {++i, rs.getString(2).trim(), rs.getString(4).trim(), rs.getString(3).trim(), rs.getString(5).trim(),
						rs.getString(6).trim() });
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
				model.addRow(
						new Object[] { rs.getString(1).trim(), rs.getString(2).trim() + " " + rs.getString(3).trim() + " " + rs.getString(4).trim(),
								rs.getString(5).trim(), rs.getString(6).trim(), rs.getString(7).trim(), rs.getString(8).trim(), rs.getString(9).trim(), });
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
				model.addRow(new Object[] { ++i, rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), });
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setFeesStructureToLable() {
		try {
			rs = new FeesDb().getData();
			rs.next();
			// set to lable
			SettingsUI.monthLbl.setText(rs.getString(1));
			SettingsUI.quarterLbl.setText(rs.getString(2));
			SettingsUI.halfYearLbl.setText(rs.getString(3));
			SettingsUI.yearLbl.setText(rs.getString(4));

			// set to text area
			SettingsUI.monthTxt.setText(rs.getString(1));
			SettingsUI.quarterTxt.setText(rs.getString(2));
			SettingsUI.halfYearTxt.setText(rs.getString(3));
			SettingsUI.yearTxt.setText(rs.getString(4));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUserToTable(JTable table) {
		try {
			model = (DefaultTableModel) table.getModel();
			rs = new UsersDb().getData();
			int i = 0;
			while (rs.next()) {
				model.addRow(new Object[] { ++i, rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(),
						rs.getString(5).trim(), rs.getString(6).trim(), rs.getString(7).trim(), rs.getString(8).trim(), rs.getString(9).trim(),
						rs.getString(10).trim(), rs.getString(11).trim(), rs.getString(12).trim(), rs.getString(13).trim() });
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
			sui.uidTxt.setText(rs.getString(1));
			sui.passwordTxt.setText(rs.getString(2));
			sui.nameTxt.setText(rs.getString(3));
			sui.addressTxt.setText(rs.getString(4));
			sui.moNoTxt.setText(rs.getString(5));
			sui.ulternateMoNoTxt.setText(rs.getString(6));
			sui.genderTxt.setText(rs.getString(7));
			sui.adharTxt.setText(rs.getString(8));
			sui.qualificationTxt.setText(rs.getString(9));
			sui.occupationTxt.setText(rs.getString(10));
			sui.joinDateTxt.setText(rs.getString(11));
			sui.sallaryTxt.setText(rs.getString(12));
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
			ssd.nameLbl.setText(rs.getString(2));
			ssd.tAddressLbl.setText(rs.getString(3));
			ssd.pAddressLbl.setText(rs.getString(4));
			ssd.adharLbl.setText(rs.getString(5));
			ssd.qualificationLbl.setText(rs.getString(6));
			ssd.genderLbl.setText(rs.getString(7));
			ssd.monoLbl.setText(rs.getString(8));
			ssd.altMoNoLbl.setText(rs.getString(9));
			ssd.parentMoNoLbl.setText(rs.getString(10));
			ssd.occupationLbl.setText(rs.getString(11));
			ssd.admissionTypeLbl.setText(rs.getString(12));
			ssd.shiftTypeLbl.setText(rs.getString(13));
			ssd.joinDateLbl.setText(rs.getString(14));

			// to textField
			ssd.idTxt.setText(rs.getString(1).trim());
			ssd.nameTxt.setText(rs.getString(2));
			ssd.tempAddress.setText(rs.getString(3));
			ssd.permenentAddress.setText(rs.getString(4));
			ssd.adharTxt.setText(rs.getString(5));
			ssd.qualificationTxt.setText(rs.getString(6));
			StaticMethods.setGender(ssd.maleRdo, ssd.femaleRdo, ssd.otherRdo, rs.getString(7));
			ssd.mobileNoTxt.setText(rs.getString(8));
			ssd.alternateMoNoTxt.setText(rs.getString(9));
			ssd.parentMoNoLbl.setText(rs.getString(10));
			ssd.occupationTxt.setText(rs.getString(11));
			ssd.admissionTypeTxt.setSelectedItem(rs.getString(12));
			ssd.shiftTypeCmb.setSelectedItem(rs.getString(13));
			StaticMethods.setDate(ssd.ddCmb, ssd.mmCmb, ssd.yyyyCmb, rs.getString(14));
			new ProcessImage().getImage(rs.getString(1).trim(), ssd.updateImageLbl, ssd.showImageLbl);// set image
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Integer> getTotalFees() {
		HashMap <String, Integer> hm = new HashMap<String, Integer>();
		try {
			rs = new FeesDb().getData();
			int i = 0;
			while (rs.next()) {
				String id = rs.getString(1).trim();
				if(hm.containsKey(id)){
//					int oldFees = hm.get(id);
					int newFees = hm.get(id) + Integer.parseInt(rs.getString(3).trim());
					hm.put(id, newFees);
				}else {
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
	public  void setHomeInfo() {
		int pending=0;
		int finished=0;
		int active=0;
		int closed=0;
		double curMonthExp;
		String status;
		HashMap <String, Integer> hm = getTotalFees();
		
		try {
			rs=new Student().getData();
			while(rs.next()) {
				
				status=new FindStatus(hm.get(rs.getString(1).trim()), rs.getString(12).trim(), rs.getString(14).trim()).getStatus();
				if(status.equals("PENDING")) {
					pending=pending+1;
				}
				if(status.equals("FINISHED")) {
					finished=finished+1;
				}
				if(rs.getString(15).trim().equals("ACTIVE")) {
					active=active+1;
				}
				if(rs.getString(15).trim().equals("CLOSED")) {
					closed=closed+1;
				}
			}
			Home.finishedLbl.setText(finished+"");
			Home.closedLbl.setText(closed+"");
			Home.activeLbl.setText(active+"");
			Home.pendingLbl.setText(pending+"");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
