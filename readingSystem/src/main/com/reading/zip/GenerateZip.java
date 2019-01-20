package com.reading.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JOptionPane;

import com.reading.hm.ActionTrackerHM;
import com.reading.ui.Home;

public class GenerateZip {
	String type;

	public void compress(String dirPath, String type) {
		this.type = type;
		Path sourceDir = Paths.get(System.getProperty("user.home")+"\\reading\\");//static source path
		String zipFileName = dirPath.concat(getZipName());
		try {
			ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
			Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
					try {
						Path targetFile = sourceDir.relativize(file);
						outputStream.putNextEntry(new ZipEntry(targetFile.toString()));
						byte[] bytes = Files.readAllBytes(file);
						outputStream.write(bytes, 0, bytes.length);

						outputStream.closeEntry();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Something went wrong, Please try again !", "Backup Failed",
								JOptionPane.ERROR_MESSAGE);
					}
					return FileVisitResult.CONTINUE;
				}
			});
			outputStream.close();
			checkZipGenerated(dirPath);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Something went wrong, Please try again !", "Backup Failed",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private String getZipName() {
		SimpleDateFormat dt = new SimpleDateFormat("ddMMYYYY");
		return Home.user + "-" + dt.format(new Date()) + ".zip";
	}

	private void checkZipGenerated(String path) {
		String zname = path + "\\" + getZipName();
		if (type.equals("manual")) {
			if (new File(zname).exists()) {
				new ActionTrackerHM("Backup@" + zname, Home.user);
				JOptionPane.showMessageDialog(null, "Backup generated at : " + zname, "Backup Created",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

//    public static void main(String args[]) {
//    	GenerateZip.compress("C:\\Users\\Sawant\\Desktop\\zipEx\\");
//    }
}