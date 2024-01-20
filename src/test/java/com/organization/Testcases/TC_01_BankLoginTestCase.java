package com.organization.Testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.organization.pageobjects.bankLoginPage;
import com.organization.utilities.BaseClass;

public class TC_01_BankLoginTestCase extends BaseClass {
	@Parameters("browser")
	@BeforeClass
	public void LoadPage(String name) {
		getDriver(name);
		logs();
		logger.info("Browser opended");

	}

	@Test
	public void loginTest() {
		loadUrl(url);
		logger.info("Page opended");
		bankLoginPage lp = new bankLoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered username");
		lp.setPassword(pass);
		logger.info("Entered password");
		lp.submitBtn();
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}

	}

	@AfterClass
	public void teardown() {
		closeBrowser();

	}

}
