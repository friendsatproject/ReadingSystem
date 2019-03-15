/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reading.ui;

import com.reading.hm.NewAdmissionHM;
import com.reading.operaton.FormatFrame;
import com.reading.operaton.SetAllTable;
import com.reading.operaton.StaticMethods;
import com.reading.operaton.processImage.ImageSelector;
import com.reading.regx.RegX;
import javax.swing.JOptionPane;

/**
 *
 * @author Sawant
 */
public class NewAdmission extends javax.swing.JInternalFrame {

    RegX regx = new RegX();

    /**
     * Creates new form NewAdmission
     */
    public NewAdmission() {
        initComponents();
        new FormatFrame(this);
        StaticMethods.setDateToCmb(ddCmb, mmCmb, yyyyCmb, currentDateCB);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        qualificationTxt = new javax.swing.JTextField();
        adharTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mobileNoTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        alternateMoNoTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        parentMoNoTxt = new javax.swing.JTextField();
        maleRdo = new javax.swing.JRadioButton();
        femaleRdo = new javax.swing.JRadioButton();
        otherRdo = new javax.swing.JRadioButton();
        occupationTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tempAddress = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        permenentAddress = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        shiftTypeCmb = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        admissionTypeTxt = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        feesPaidTxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        totalFeesLbl = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        currentDateCB = new javax.swing.JCheckBox();
        ddCmb = new javax.swing.JComboBox();
        mmCmb = new javax.swing.JComboBox();
        yyyyCmb = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        browsImageBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        imageLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        cancelBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        submitBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Name*");

        jLabel3.setText("Temprary Address*");

        jLabel5.setText("Adhar Number");

        jLabel6.setText("Qualification");

        jLabel15.setText("Gender");

        qualificationTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qualificationTxtKeyReleased(evt);
            }
        });

        adharTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adharTxtKeyReleased(evt);
            }
        });

        nameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTxtKeyReleased(evt);
            }
        });

        jLabel4.setText("Mobile Number*");

        mobileNoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobileNoTxtKeyReleased(evt);
            }
        });

        jLabel13.setText("Alternate Mobile Number");

        alternateMoNoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                alternateMoNoTxtKeyReleased(evt);
            }
        });

        jLabel14.setText("Parent's Mobile Number");

        parentMoNoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                parentMoNoTxtKeyReleased(evt);
            }
        });

        maleRdo.setBackground(new java.awt.Color(255, 255, 255));
        maleRdo.setSelected(true);
        maleRdo.setText("Male");
        maleRdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRdoActionPerformed(evt);
            }
        });

        femaleRdo.setBackground(new java.awt.Color(255, 255, 255));
        femaleRdo.setText("Female");
        femaleRdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRdoActionPerformed(evt);
            }
        });

        otherRdo.setBackground(new java.awt.Color(255, 255, 255));
        otherRdo.setText("Other");
        otherRdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherRdoActionPerformed(evt);
            }
        });

        occupationTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                occupationTxtKeyReleased(evt);
            }
        });

        jLabel9.setText("Occupation");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tempAddress.setColumns(20);
        tempAddress.setLineWrap(true);
        tempAddress.setRows(5);
        tempAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tempAddressKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tempAddress);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        permenentAddress.setColumns(20);
        permenentAddress.setLineWrap(true);
        permenentAddress.setRows(5);
        permenentAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                permenentAddressKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(permenentAddress);

        jLabel12.setText("Permenent Address");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Shift Type");

        shiftTypeCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "Day-Night", "Night" }));
        shiftTypeCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftTypeCmbActionPerformed(evt);
            }
        });

        jLabel10.setText("Admission Type");

        admissionTypeTxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "For One Month", "For Three Month", "For Six Month", "For Year" }));
        admissionTypeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admissionTypeTxtActionPerformed(evt);
            }
        });

        jLabel7.setText("Total Fees ");

        jLabel11.setText("Paid Fees*");

        feesPaidTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                feesPaidTxtKeyReleased(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        totalFeesLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        totalFeesLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalFeesLbl.setText("Total Fees");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalFeesLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalFeesLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel16.setText("Join Date");

        currentDateCB.setBackground(new java.awt.Color(255, 255, 255));
        currentDateCB.setSelected(true);
        currentDateCB.setText("Current Date");
        currentDateCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentDateCBActionPerformed(evt);
            }
        });

        ddCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        mmCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        yyyyCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YYYY", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));

        jLabel17.setText("Upload Photo");

        browsImageBtn.setText("Select Photo");
        browsImageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsImageBtnActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(currentDateCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ddCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mmCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yyyyCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(shiftTypeCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admissionTypeTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(feesPaidTxt)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(browsImageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(browsImageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(currentDateCB)
                    .addComponent(ddCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mmCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yyyyCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(shiftTypeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(admissionTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(feesPaidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(adharTxt)
                            .addComponent(qualificationTxt)
                            .addComponent(nameTxt)
                            .addComponent(occupationTxt)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4)
                            .addComponent(jLabel15))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(parentMoNoTxt)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(otherRdo)
                                .addComponent(mobileNoTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(maleRdo)
                                .addGap(59, 59, 59)
                                .addComponent(femaleRdo))
                            .addComponent(alternateMoNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(118, 118, 118)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(adharTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(qualificationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(occupationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(maleRdo)
                    .addComponent(femaleRdo)
                    .addComponent(otherRdo))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mobileNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alternateMoNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parentMoNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(31, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Register New Student");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 874, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maleRdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRdoActionPerformed
        // TODO add your handling code here:
        femaleRdo.setSelected(false);
        otherRdo.setSelected(false);
    }//GEN-LAST:event_maleRdoActionPerformed

    private void femaleRdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRdoActionPerformed
        // TODO add your handling code here:
        maleRdo.setSelected(false);
        otherRdo.setSelected(false);
    }//GEN-LAST:event_femaleRdoActionPerformed

    private void otherRdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherRdoActionPerformed
        // TODO add your handling code here:
        femaleRdo.setSelected(false);
        maleRdo.setSelected(false);
    }//GEN-LAST:event_otherRdoActionPerformed

    private void currentDateCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentDateCBActionPerformed
        // TODO add your handling code here:
        StaticMethods.setDateToCmb(ddCmb, mmCmb, yyyyCmb, currentDateCB);
    }//GEN-LAST:event_currentDateCBActionPerformed

    private void browsImageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsImageBtnActionPerformed
        // TODO add your handling code here:
        new ImageSelector(imageLbl);
    }//GEN-LAST:event_browsImageBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        if (!nameTxt.getText().isEmpty() && !tempAddress.getText().isEmpty() && !mobileNoTxt.getText().isEmpty() && !feesPaidTxt.getText().isEmpty()) {
            new NewAdmissionHM(this);
        }else{
            JOptionPane.showMessageDialog(this, "Name, Address, Mobile Number and Fees Paid are mandatory fields","Success Park",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void shiftTypeCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftTypeCmbActionPerformed
        // TODO add your handling code here:
        totalFeesLbl.setText(new SetAllTable().getFees((String) admissionTypeTxt.getSelectedItem(), (String) shiftTypeCmb.getSelectedItem()));
    }//GEN-LAST:event_shiftTypeCmbActionPerformed

    private void admissionTypeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionTypeTxtActionPerformed
        // TODO add your handling code here:
        totalFeesLbl.setText(new SetAllTable().getFees((String) admissionTypeTxt.getSelectedItem(), (String) shiftTypeCmb.getSelectedItem()));
    }//GEN-LAST:event_admissionTypeTxtActionPerformed

    private void nameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyReleased
        // TODO add your handling code here:
        regx.isValidInput("([a-zA-Z\\s]{3,49})", nameTxt, 49);
    }//GEN-LAST:event_nameTxtKeyReleased

    private void tempAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tempAddressKeyReleased
        // TODO add your handling code here:
        regx.isValidInput("([\\s\\w,.]{0,49})", tempAddress, 149);
    }//GEN-LAST:event_tempAddressKeyReleased

    private void permenentAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_permenentAddressKeyReleased
        // TODO add your handling code here:
        regx.isValidInput("([\\s\\w,.]{0,49})", permenentAddress, 149);
    }//GEN-LAST:event_permenentAddressKeyReleased

    private void adharTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adharTxtKeyReleased
        // TODO add your handling code here:
        regx.isValidInput("([\\d]{12})", adharTxt, 12);
    }//GEN-LAST:event_adharTxtKeyReleased

    private void qualificationTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qualificationTxtKeyReleased
        // TODO add your handling code here:
        regx.isValidInput("([\\s\\w]{0,49})", qualificationTxt, 69);
    }//GEN-LAST:event_qualificationTxtKeyReleased

    private void occupationTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_occupationTxtKeyReleased
        // TODO add your handling code here:
        regx.isValidInput("([\\s\\w]{0,19})", occupationTxt, 69);
    }//GEN-LAST:event_occupationTxtKeyReleased

    private void mobileNoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileNoTxtKeyReleased
        // TODO add your handling code here:
        regx.isValidInput("([\\d]{10})", mobileNoTxt, 10);
    }//GEN-LAST:event_mobileNoTxtKeyReleased

    private void alternateMoNoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alternateMoNoTxtKeyReleased
        // TODO add your handling code here:
        regx.isValidInput("([\\d]{10})", alternateMoNoTxt, 10);
    }//GEN-LAST:event_alternateMoNoTxtKeyReleased

    private void parentMoNoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parentMoNoTxtKeyReleased
        // TODO add your handling code here:
        regx.isValidInput("([\\d]{10})", parentMoNoTxt, 10);
    }//GEN-LAST:event_parentMoNoTxtKeyReleased

    private void feesPaidTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feesPaidTxtKeyReleased
        // TODO add your handling code here:
        regx.isValidInput("([\\d]{0,5})", feesPaidTxt, 5);
    }//GEN-LAST:event_feesPaidTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField adharTxt;
    public javax.swing.JComboBox admissionTypeTxt;
    public javax.swing.JTextField alternateMoNoTxt;
    private javax.swing.JButton browsImageBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JCheckBox currentDateCB;
    public javax.swing.JComboBox ddCmb;
    public javax.swing.JTextField feesPaidTxt;
    public javax.swing.JRadioButton femaleRdo;
    public javax.swing.JLabel imageLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JRadioButton maleRdo;
    public javax.swing.JComboBox mmCmb;
    public javax.swing.JTextField mobileNoTxt;
    public javax.swing.JTextField nameTxt;
    public javax.swing.JTextField occupationTxt;
    public javax.swing.JRadioButton otherRdo;
    public javax.swing.JTextField parentMoNoTxt;
    public javax.swing.JTextArea permenentAddress;
    public javax.swing.JTextField qualificationTxt;
    public javax.swing.JComboBox shiftTypeCmb;
    private javax.swing.JButton submitBtn;
    public javax.swing.JTextArea tempAddress;
    private javax.swing.JLabel totalFeesLbl;
    public javax.swing.JComboBox yyyyCmb;
    // End of variables declaration//GEN-END:variables
}
