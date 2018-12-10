package com.reading.operaton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class FormatFrame {

    JInternalFrame frame;
    double width;
    double height;

    public FormatFrame(JInternalFrame frame) {
        this.frame = frame;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.getWidth();
        height = screenSize.getHeight();

        BasicInternalFrameUI bi = (BasicInternalFrameUI) frame.getUI();
        bi.setNorthPane(null);

        frame.setBounds(0, 0, (int) width - 195, (int) height - 70);

        frame.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        frame.getContentPane().setBackground(Color.white);

    }

    public void formatAddNewExpence() {
        frame.setBounds(0, 0, (int) width - 195, (int) height - 370);
    }
    public void formatTable(JTable table){
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setBackground(Color.white);
    }
}
