package com.selenium.starter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValues {

	public static void main(String[] args) {

		Properties properties = new Properties();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\globalProperties.properties");
			//System.out.println(fis);
			properties.load(fis);
			System.out.println(properties.getProperty("browser"));
			System.out.println(properties.setProperty("userName", "rahul"));
			fos = new FileOutputStream(System.getProperty("user.dir") + "\\globalProperties.properties");
			properties.store(fos, "Updating user name in properties file.");
		} catch (IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
	}

}
