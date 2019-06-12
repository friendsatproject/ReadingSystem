/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reading.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Sawant
 */
public class Sms {
    public Sms(HashMap<String ,String>hm){
//        System.out.println(hm.get("msg"));
//        System.out.println(hm.get("number"));
    	
//         try {
//            // Construct data
//            String apiKey = "apikey=" + "CZO93Uf6t7E-o0Zb0HwUcHqhZM6AnHpeWqr1cnRr3I";
//            String message = "&message=" + hm.get("MSG");
//            String sender = "&sender=" + "";
//            String numbers = "&numbers=" + hm.get("NUMBER");
//
//            // Send data
//            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
//            String data = apiKey + numbers + message + sender;
//            conn.setDoOutput(true);
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
//            conn.getOutputStream().write(data.getBytes("UTF-8"));
//            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            final StringBuffer stringBuffer = new StringBuffer();
//            String line;
//            while ((line = rd.readLine()) != null) {
//                JOptionPane.showMessageDialog(null, "message"+line+"\n","Message Notification",JOptionPane.INFORMATION_MESSAGE);
//            }
//            rd.close();
//
////			return stringBuffer.toString();
//        } catch (Exception e) {
//            System.out.println("Error SMS " + e);
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Message not sent!","Message sending failed",JOptionPane.ERROR_MESSAGE);
////			return "Error "+e;
//        }
    }
}
