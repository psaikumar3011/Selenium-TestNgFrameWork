package com.organization.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	static Properties pro;

	
	public ReadConfig(){
		
		File src=new File("F:\\New folder\\Project\\configuration\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			}catch (Exception e) {
				System.out.println("Exception is "+ e.getMessage());
			}
	}
	
	public static String getApplicationURL() {
		String url=pro.getProperty("url");
		return url;
	}
	
	public static String getUserName() {
		String user=pro.getProperty("user");
		return user;
	}
	public static String getPassword() {
		String pwd=pro.getProperty("pwd");
		return pwd;
	}

}
