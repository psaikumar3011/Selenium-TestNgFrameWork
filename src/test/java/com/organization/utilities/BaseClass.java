package com.organization.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class BaseClass extends ReadConfig {

	public static WebDriver driver;
	public String userName = getUserName();
	public String pass = getPassword();
	public String url = getApplicationURL();
	public static Logger logger;

	public static void getDriver(String name) {
		if (name.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (name.equals("IE")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (name.equals("FireFox")) {
			WebDriverManager.edgedriver().setup();
			driver = new FirefoxDriver();
		}
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void logs() {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

	}

	public static boolean isAlerPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
