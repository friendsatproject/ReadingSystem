package com.reading.hm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import com.reading.db.FeesDb;
import com.reading.ui.Home;
import com.reading.ui.NewAdmission;

public class FeesHM {

    public FeesHM(String amount, String id,String mm) {
        LinkedHashMap<String, Object> props = new LinkedHashMap<String, Object>();
        props.put("ID", id);
        props.put("DATE", new SimpleDateFormat("dd-MM-YYYY").format(new Date()));
        props.put("AMOUNT", amount);
        props.put("RECEIVER", Home.user);
        props.put("MONTH", mm+"");

        if (new FeesDb().save(props)) {
            new ActionTrackerHM("Fees Submited", id);
            JOptionPane.showMessageDialog(null, "Fees Updated successfully !", "Fees Updated", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
