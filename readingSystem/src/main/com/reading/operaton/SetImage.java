package com.reading.operaton;

import java.awt.Image;

import javax.imageio.ImageIO;

public class SetImage {
	Image img;
	ClassLoader cl;

	public Image image(String imageName) {
		cl = getClass().getClassLoader();
		try {
			cl.getResource("resources/images/" + imageName).getPath();
			img = ImageIO.read(cl.getResourceAsStream("resources/images/" + imageName));
			return img;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cl.getResource(imageName).getPath();
			img = ImageIO.read(cl.getResourceAsStream(imageName));
			return img;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return img;
	}
}
