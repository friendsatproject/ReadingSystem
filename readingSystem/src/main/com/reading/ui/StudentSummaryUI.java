/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reading.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.reading.db.FeesDb;
import com.reading.db.FixedFeesDb;
import com.reading.db.Student;
import com.reading.operaton.FormatFrame;
import com.reading.operaton.SetAllTable;

/**
 *
 * @author Sawant
 */
public class StudentSummaryUI extends javax.swing.JInternalFrame {

	Home home;
	double totalPaid = 0;
	double totalPending = 0;
	double totalToPay = 0;
	double currentStudentPaid = 0;
	String status;

	DefaultTableModel model = new DefaultTableModel();
	HashMap<String, String> fixedFees = new HashMap<String, String>();

	/**
	 * Creates new form StudentSummaryUI
	 */
	public StudentSummaryUI(Home home) {
		this.home = home;
		initComponents();
		new FormatFrame(this);
		tableFormatting();
		int mm = Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));
		mmCmb.setSelectedIndex(mm - 1);
		getFixedFees();
		loadData(mm, LocalDate.now().getYear() + "");

	}

	public void tableFormatting() {
		table.setModel(model);
		model.addColumn("Sr.No.");
		model.addColumn("Name");
		model.addColumn("Temp. Address");
		model.addColumn("Per. Address");
		model.addColumn("Adhar No");
		model.addColumn("Qualification");
		model.addColumn("Gender");
		model.addColumn("Mobile No.");
		model.addColumn("Mobile No. 2");
		model.addColumn("Parent Mo.No.");
		model.addColumn("Occupation");
		model.addColumn("Admission Type");
		model.addColumn("Shift type");
		model.addColumn("Join Date");
		model.addColumn("Paid Fees");
		model.addColumn("ID");
		model.addColumn("Status");

		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(70);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);
		table.getColumnModel().getColumn(10).setPreferredWidth(150);
		table.getColumnModel().getColumn(11).setPreferredWidth(100);
		table.getColumnModel().getColumn(12).setPreferredWidth(100);
		table.getColumnModel().getColumn(13).setPreferredWidth(100);
		table.getColumnModel().getColumn(14).setPreferredWidth(80);
		table.getColumnModel().getColumn(15).setPreferredWidth(50);

		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setBackground(Color.WHITE);
		table.setDefaultEditor(Object.class, null);
		
//		hide last column
		TableColumnModel tcm = table.getColumnModel();
		tcm.removeColumn(tcm.getColumn(16));
//mouse double click event
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mv) {
				JTable tabl = (JTable) mv.getSource();
				Point point = mv.getPoint();
				int ro = tabl.rowAtPoint(point);
				if (mv.getClickCount() == 2 && tabl.getSelectedRow() != -1) {
					String studId = (String) table.getValueAt(table.getSelectedRow(), 15);
					ShowStudentDetails frame = new ShowStudentDetails(studId);
					new SetAllTable().setStudentToFields(studId, frame);
					home.frame2 = frame;
					home.windo.add(frame);
					frame.setVisible(true);

				}
			}
		});
		// change color of row
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int col) {

				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

				String status = (String) table.getModel().getValueAt(row, 16);
				if ("p".equals(status)) {
					setBackground(new Color(242,176,170));
					setForeground(Color.black);
				} else {
					setBackground(table.getBackground());
					setForeground(table.getForeground());
				}
				return this;
			}
		});
	}

	public void loadData(int mm, String yy) {
		totalPaid = 0;
		totalToPay = 0;
		currentStudentPaid = 0;
		try {
			model.setRowCount(0);
			ResultSet rs = new Student().getData();

			int srno = 1;
			while (rs.next()) {
				if (isInMonth(rs.getString(14).trim(), mm, yy)) {
					model.addRow(new Object[] { srno++, rs.getString(2).trim(), rs.getString(3).trim(),
							rs.getString(4).trim(), rs.getString(5).trim(), rs.getString(6).trim(),
							rs.getString(7).trim(), rs.getString(8).trim(), rs.getString(9).trim(),
							rs.getString(10).trim(), rs.getString(11).trim(), rs.getString(12).trim(),
							rs.getString(13).trim(), rs.getString(14).trim(), "", rs.getString(1).trim() });

					calculateTotalPaid(rs.getString(1).trim(), mm);
					calculatePendingTotal(rs.getString(12).trim(), rs.getString(13).trim(), currentStudentPaid);
					model.setValueAt(currentStudentPaid, srno - 2, 14);
					model.setValueAt(status, srno - 2, 16);
				}
			}
			tpaLbl.setText((totalToPay - totalPaid) + "");
			tpLbl.setText(totalPaid + "");
			etLbl.setText(totalToPay + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void calculatePendingTotal(String period, String shift, double currentStudentPaid) {// fees from FisedFees
																								// table for new
																								// admission,
		// returns fixed fees
		HashMap<String, String> data = new HashMap<String, String>();
		String p = "";
		String s = "";
		switch (period) {
		case "For One Month":
			p = "m";
			break;
		case "For Three Month":
			p = "t";
			break;
		case "For Six Month":
			p = "s";
			break;
		case "For Year":
			p = "y";
		}
		switch (shift) {
		case "Day":
			s = "d";
			break;
		case "Day-Night":
			s = "dn";
			break;
		case "Night":
			s = "n";
			break;
		case "D":
			s = "d";
			break;
		case "DN":
			s = "dn";
			break;
		case "N":
			s = "n";
			break;
		}
//		System.out.println(s + p);
		totalToPay = totalToPay + Double.parseDouble(fixedFees.get(s + p));
//status for color change in table row
		if (Double.parseDouble(fixedFees.get(s + p)) <= currentStudentPaid) {
			status="c";
		}else {
			status="p";
		}
	}

	public void getFixedFees() {
		try {
			ResultSet r = new FixedFeesDb().getData();
			r.next();
			fixedFees.put("dm", r.getString(3).trim());
			fixedFees.put("dt", r.getString(4).trim());
			fixedFees.put("ds", r.getString(5).trim());
			fixedFees.put("dy", r.getString(6).trim());

			r.next();
			fixedFees.put("nm", r.getString(3).trim());
			fixedFees.put("nt", r.getString(4).trim());
			fixedFees.put("ns", r.getString(5).trim());
			fixedFees.put("ny", r.getString(6).trim());

			r.next();
			fixedFees.put("dnm", r.getString(3).trim());
			fixedFees.put("dnt", r.getString(4).trim());
			fixedFees.put("dns", r.getString(5).trim());
			fixedFees.put("dny", r.getString(6).trim());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void calculateTotalPaid(String id, int mm) {
		currentStudentPaid = 0;
		try {
			ResultSet rst;
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.clear();
			hm.put("ID", id);
			rst = new FeesDb().getData(hm);
			while (rst.next()) {
				if (Integer.parseInt(rst.getString(5).trim()) == mm) {
					totalPaid = totalPaid + Double.parseDouble(rst.getString(3).trim());
					currentStudentPaid = currentStudentPaid + Double.parseDouble(rst.getString(3).trim());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isInMonth(String date, int mm, String yy) {
		try {
			Date joinDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
//            String mm = "02";//new SimpleDateFormat("MM").format(new Date());
			Date start = new SimpleDateFormat("dd-MM-yyyy").parse("01-" + mm + "-" + yy);
//			int lastday = LocalDate.of(2019, mm, 1).getMonth().length(Year.of(2019).isLeap());
//			Date end = new SimpleDateFormat("dd-MM-yyyy").parse(lastday + "-" + mm + "-" + yy);
			
			if (joinDate.getMonth() == start.getMonth()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
		jDesktopPane1 = new javax.swing.JDesktopPane();
		jPanel3 = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		mmCmb = new javax.swing.JComboBox();
		searchBtn = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		tpLbl = new javax.swing.JLabel();
		tpaLbl = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		etLbl = new javax.swing.JLabel();

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setText("Search By Month");

		mmCmb.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " Jan - 2019", " Feb - 2019", " Mar - 2019", " Apr - 2019", " May - 2019", " Jun - 2019",
						" Jul - 2019", " Aug - 2019", " Sep - 2019", " Ocg - 2019", " Nov - 2019", "Dec - 2019" }));

		searchBtn.setBackground(new java.awt.Color(255, 255, 255));
		searchBtn.setText("Search");
		searchBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(mmCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 204,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(15, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(mmCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1).addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										30, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		table.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
		table.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		table.setRowHeight(20);
		table.setSelectionBackground(new java.awt.Color(255, 153, 0));
		jScrollPane1.setViewportView(table);

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		jLabel2.setText("Total Paid Fees Amount  :");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		jLabel3.setText("Total Pending Amount    :");

		tpLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		tpLbl.setText("Amount");

		tpaLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		tpaLbl.setText("Amount");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		jLabel4.setText("Expected Paid Amount Total  :");

		etLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		etLbl.setText("Amount");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap(121, Short.MAX_VALUE)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2).addComponent(jLabel3))
						.addGap(23, 23, 23)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(tpLbl).addComponent(tpaLbl))
						.addGap(18, 18, 18).addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(etLbl)
						.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(tpLbl).addComponent(jLabel4).addComponent(etLbl))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(tpaLbl))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel4,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(jScrollPane1));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)));

		javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
		jDesktopPane1.setLayout(jDesktopPane1Layout);
		jDesktopPane1Layout.setHorizontalGroup(
				jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel3,
						javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jDesktopPane1Layout.setVerticalGroup(
				jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel3,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jDesktopPane1));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchBtnActionPerformed
		// TODO add your handling code here:
		int mon = mmCmb.getSelectedIndex() + 1;
		String[] yy = mmCmb.getSelectedItem().toString().split("-");

		loadData(mon, yy[1].trim());
	}// GEN-LAST:event_searchBtnActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel etLbl;
	private javax.swing.JDesktopPane jDesktopPane1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JComboBox mmCmb;
	private javax.swing.JButton searchBtn;
	private javax.swing.JTable table;
	private javax.swing.JLabel tpLbl;
	private javax.swing.JLabel tpaLbl;
	// End of variables declaration//GEN-END:variables
}
