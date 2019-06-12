package com.reading.operaton.processImage;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import com.reading.ui.Home;

public class ImageSelector {
	Home h=new Home ();
	static String photoPath;
	public ImageSelector(JLabel lbl) {
	
		try {
	    	
	        JFileChooser f = new JFileChooser();
			f.setDialogTitle("Select Image");
			f.setApproveButtonText("Select");
			f.setFileSelectionMode(JFileChooser.FILES_ONLY);
			f.showOpenDialog(h);

			
				 photoPath =  f.getSelectedFile().getAbsolutePath();
				Image image = new ImageIcon(photoPath).getImage();
				Image newImage = image.getScaledInstance(123, 130, Image.SCALE_DEFAULT);
				lbl.setIcon( new ImageIcon(newImage)			);
				
			
				
			} catch (Exception e) {
				System.out.println("null pointer exception! user cancelled selection.");
			}
	}
}
