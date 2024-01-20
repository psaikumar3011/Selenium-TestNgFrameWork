package com.organization.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xlUtils {
	public static void main(String[] args) throws IOException {
//		logger.info("Browser opended");
		FileInputStream fis = new FileInputStream("F:\\New folder\\Project\\TestDataBook.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = null;
		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("userDetails")) {
				sheet = workbook.getSheetAt(i);

			}
		}
		int RowNum = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				String cell = row.getCell(j).toString();
				System.out.print("     " + cell);
			}

			System.out.println();
		}

		int NoOfRows = sheet.getPhysicalNumberOfRows();

		for (int i = 1; i < NoOfRows; i++) {
			XSSFRow currenRow = sheet.getRow(i);

			String UserName = currenRow.getCell(1).getStringCellValue();
			String Password = currenRow.getCell(2).getStringCellValue();

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.guru99.com/V1/index.php");
			driver.findElement(By.name("uid")).sendKeys(UserName);
			driver.findElement(By.name("password")).sendKeys(Password);
			driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

			driver.close();

		}

	}

}
