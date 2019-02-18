/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reading.operaton;

import com.reading.ui.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Sawant
 */
public class DateTime implements ActionListener{

    public DateTime(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String date = format.format(new Date());
        Home.dateLbl.setText(date);
        new Timer(1000,this).start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String time = new SimpleDateFormat("hh:mm:ss a").format(new Date());
        Home.timeLbl.setText(time);
    }
    
}
