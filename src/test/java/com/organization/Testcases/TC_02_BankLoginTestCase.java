package com.organization.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.organization.pageobjects.bankLoginPage;
import com.organization.utilities.BaseClass;
import com.organization.utilities.mainXlutils;

public class TC_02_BankLoginTestCase extends BaseClass {
	@Parameters("browser")
	@BeforeClass
	public void LoadPage(String name) {
		getDriver(name);
		logs();

		logger.info("Browser opended");

	}

	@Test(dataProvider = "userDetails")
	public void loginTestTDD(String user, String Passco) {
		loadUrl(url);
		logger.info("Page opended");
		bankLoginPage lp = new bankLoginPage(driver);
		lp.setUserName(user);
		logger.info("Entered username");
		lp.setPassword(Passco);
		logger.info("Entered password");
		lp.submitBtn();
		if (isAlerPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(true);
			lp.logOutBtn();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	@AfterClass
	public void teardown() {
		closeBrowser();

	}

	@DataProvider(name = "userDetails")
	public String[][] getXlData() throws IOException {

		String path = "F:\\New folder\\Project\\src\\test\\java\\com\\organization\\TestData\\TestDataBook.xlsx";
		int rowCount = mainXlutils.getRowCount(path, "UserDetails");
		int colcount = mainXlutils.getCellCount(path, "UserDetails", 1);

		String loginData[][] = new String[rowCount][colcount];

		for (int i = 0; i <=rowCount-1; i++) {
			for (int j = 0; j < colcount; j++) {
				loginData[i][j] = mainXlutils.getCellData(path, "UserDetails", i, j);
			}
		}

		return loginData;
	}
}
