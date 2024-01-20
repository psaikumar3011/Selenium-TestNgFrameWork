package com.organization.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.organization.utilities.BaseClass;


public class bankLoginPage {
	
	WebDriver driver;
	
	public bankLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="uid")
	static WebElement userName;
	
	@FindBy(name="password")
	static WebElement password;
	
	@FindBy(xpath="//input[@value='LOGIN']")
	static WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='Logout.php']")
	static WebElement logOutBtn;
	
	
	public static void setUserName(String uName) {
		userName.sendKeys(uName);
	}
	
	public static void setPassword(String Pass) {
		password.sendKeys(Pass);
	}
	
	public static void submitBtn() {
		loginBtn.click();
	}
	
	public static void logOutBtn() {
		logOutBtn.click();
	}
	
	
	
}
