/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reading.regx;

import java.awt.Color;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sawant
 */
public class RegX {

	Color wrongInputColr = new Color(215, 125, 151);

	/*
	 * 
	 * isValidInput(String regx, JTextField textFild, int length) parameter 1 String
	 * for regx pattern parameter 2 input field parameter 3 maximum allowed length
	 * for input string
	 *
	 **/
	public void isValidInput(String regx, JTextField textFild, int length) {
		String text = textFild.getText();
		if (!text.isEmpty()) {
			if (text.length() <= length) {
				if (Pattern.compile(regx).matcher(text).matches()) {
					textFild.setBackground(Color.white);
				} else {
					textFild.setBackground(wrongInputColr);
				}
			} else {
				textFild.setText(text.substring(0, length));
			}
		} else {
			textFild.setBackground(wrongInputColr);
		}
	}

	public void isValidInput(String regx, JTextArea textFild, int length) {
		String text = textFild.getText();
		if (!text.isEmpty()) {
			if (text.length() <= length) {
				if (Pattern.compile(regx).matcher(text).matches()) {
					textFild.setBackground(Color.white);
				} else {
					textFild.setBackground(wrongInputColr);
				}
			} else {
				textFild.setText(text.substring(0, length));
			}
		} else {
			textFild.setBackground(wrongInputColr);
		}
	}

	public boolean validateInput(String regx, JTextField textFild,  String message) {
		String text = textFild.getText();
		if (Pattern.compile(regx).matcher(text).matches()) {
			textFild.setBackground(Color.white);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, message, "Wrong Input", JOptionPane.ERROR_MESSAGE);
			textFild.setBackground(wrongInputColr);
			return false;
		}
	}

	public boolean validateInput(String regx, JTextArea textFild,  String message) {
		String text = textFild.getText();
		if (Pattern.compile(regx).matcher(text).matches()) {
			textFild.setBackground(Color.white);
			return true;
		} else {
			textFild.setBackground(wrongInputColr);
			JOptionPane.showMessageDialog(null, message, "Wrong Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

//	public boolean canNull(String regx, JTextArea textFild, int length ,String message) {
//		String text = textFild.getText();
//		if (text.isEmpty()) {
//			textFild.setBackground(Color.white);
//			return true;
//		} else {
//			if (!text.isEmpty()) {
//				if (Pattern.compile(regx).matcher(text).matches()) {
//					textFild.setBackground(Color.white);
//					return true;
//				} else {
//					textFild.setBackground(wrongInputColr);
//					JOptionPane.showMessageDialog(null,message +"\nin "+textFild.getName() , "Wrong Input", JOptionPane.ERROR_MESSAGE);
//					return false;
//				}
//			} else {
//				JOptionPane.showMessageDialog(null,message +"\nin "+textFild.getName() , "Wrong Input", JOptionPane.ERROR_MESSAGE);
//				textFild.setBackground(wrongInputColr);
//				return false;
//			}
//		}
//	}

//	public boolean canNull(String regx, JTextField textFild, int length) {
//		String text = textFild.getText();
//		if (text.isEmpty()) {
//			textFild.setBackground(Color.white);
//			return true;
//		} else {
//			if (!text.isEmpty()) {
//				if (Pattern.compile(regx).matcher(text).matches()) {
//					textFild.setBackground(Color.white);
//					return true;
//				} else {
//					JOptionPane.showMessageDialog(null,message +"\nin "+textFild.getName() , "Wrong Input", JOptionPane.ERROR_MESSAGE);
//					textFild.setBackground(wrongInputColr);
//					return false;
//				}
//			} else {
//				JOptionPane.showMessageDialog(null,message +"\nin "+textFild.getName() , "Wrong Input", JOptionPane.ERROR_MESSAGE);
//				textFild.setBackground(wrongInputColr);
//				return false;
//			}
//		}
//	}
}
