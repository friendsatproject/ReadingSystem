package com.reading.operaton.processImage;

import java.awt.Image;

import javax.imageio.ImageIO;

public class SetImage {
	Image img;
	ClassLoader cl;

	public Image image(String imageName) {
		cl = getClass().getClassLoader();
		try {
			img = ImageIO.read(getClass().getResource("resources/" + "images/"+imageName));
			return img;
		} catch (Exception e) {
//			e.printStackTrace();
		}
		
		try {
			cl.getResource("images/"+imageName).getPath();
			img = ImageIO.read(cl.getResourceAsStream("images/"+imageName));
			return img;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return img;
	}

}
