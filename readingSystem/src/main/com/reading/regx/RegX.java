/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reading.regx;

import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sawant
 */
public class RegX {

    Color wrongInputColr = new Color(215, 125, 151);
/* isValidInput() 
    parameter 1 String for regx pattern
    parameter 2 input field
    parameter 3 maximum allowed length for input string*/
    public void isValidInput(String regx, JTextField textFild,int length) {
        String text = textFild.getText();
        if (!text.isEmpty()) {
            if (text.length() <= length) {
                if (Pattern.compile(regx).matcher(text).matches()) {
                    textFild.setBackground(Color.white);
                } else {
                    textFild.setBackground(wrongInputColr);
                }
            }else{
                textFild.setText(text.substring(0,length));
            }
        } else {
            textFild.setBackground(wrongInputColr);
        }

    }
    public void isValidInput(String regx, JTextArea textFild,int length) {
        String text = textFild.getText();
        if (!text.isEmpty()) {
            if (text.length() <= length) {
                if (Pattern.compile(regx).matcher(text).matches()) {
                    textFild.setBackground(Color.white);
                } else {
                    textFild.setBackground(wrongInputColr);
                }
            }else{
                textFild.setText(text.substring(0,length));
            }
        } else {
            textFild.setBackground(wrongInputColr);
        }

    }
}
