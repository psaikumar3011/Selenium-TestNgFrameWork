package com.organization.Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.organization.utilities.mainXlutils;

public class demo {
	
	@DataProvider(name = "userDetails")
	public String[][] getXlData() throws IOException {

		String path = "F:\\New folder\\Project\\src\\test\\java\\com\\organization\\TestData\\TestDataBook.xlsx";
		int rowCount = mainXlutils.getRowCount(path, "UserDetails");
		int colcount = mainXlutils.getCellCount(path, "UserDetails", 1);
		System.out.println(rowCount+" rowcount");
		System.out.println(colcount+" rowcount");
		String loginData[][] = new String[rowCount][colcount];

		for (int i = 0; i <=rowCount-1; i++) {
			for (int j = 0; j < colcount; j++) {
				loginData[i][j] = mainXlutils.getCellData(path, "UserDetails", i, j);
			}
		}

		return loginData;
	}
	@Test(dataProvider="userDetails")
	public void runCase(String user,String pass) {
	
		System.out.println(user);
		System.out.println(pass);
		
	}
}
