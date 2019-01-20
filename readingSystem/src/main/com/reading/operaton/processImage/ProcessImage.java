package com.reading.operaton.processImage;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.reading.ui.LogIn;

public class ProcessImage {

	String location = LogIn.homePath + "//reading//images//";

	public void saveImage(String id) {
		if (ImageSelector.photoPath != null) {

			File file = new File(ImageSelector.photoPath);
			BufferedImage image = null;

			try {
				image = ImageIO.read(file);
				BufferedImage sizedImage = resize(image, 124, 129);
				ImageIO.write(sizedImage, "jpg", new File(location + "//" + id + ".jpg"));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void getImage(String id, JLabel label1,JLabel label2) {

		try 
		(Stream<Path> filePathStream=Files.walk(Paths.get(location))) {
		    filePathStream.forEach(filePath -> {
		        if (Files.isRegularFile(filePath)) {
//		            System.out.println(filePath);
		        	if(filePath.toString().endsWith(id+".jpg")) {
		        		
		        		Image image = new ImageIcon(filePath.toString()).getImage();
//						Image newImage = image.getScaledInstance(123, 130, Image.SCALE_DEFAULT);
		        		label1.setIcon( new ImageIcon(image));
		        		label2.setIcon( new ImageIcon(image));
		        	}
		        }
		    });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static BufferedImage resize(BufferedImage img, int height, int width) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}
}
