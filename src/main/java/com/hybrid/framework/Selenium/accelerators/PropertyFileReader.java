package com.hybrid.framework.Selenium.accelerators;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class PropertyFileReader {
	
	public static Properties propertyFileReader(String path) {
		File file = new File(path);
		Properties prop = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			prop.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Properties file not found");
		}
		return prop;

	}
	//\src\main\resources\data.properties
	
	public static String getProperty(String key) {
		String value = propertyFileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "main" + File.separator + "resources" + File.separator + "data.properties").getProperty(key).trim();
		return value;
	}
}
