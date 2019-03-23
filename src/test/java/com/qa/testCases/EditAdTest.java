package com.qa.testCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.EditAd;
import com.qa.pages.LoginPage;

public class EditAdTest extends TestBase{
	
	Logger log = Logger.getLogger(EditAdTest.class);
     EditAd edit;
     LoginPage login;
	
	public EditAdTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		edit=new EditAd();
		login=new LoginPage();
	}
	
	@Test(priority=1)
	public void editButtonClickabilityTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=edit.editButtonClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Edit button is clickable");
	}
	
	@Test(priority=2)
	public void UpdateAdTest() throws InterruptedException {
		boolean actual=edit.editAd();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("ad updated successfully");
	}
	
	@Test(priority=3)
	public void UpdateAdPageTitleTest() throws InterruptedException {
		String actual=edit.UpdateAdPageTitle();
		String expected="WeeklyPaper - Update Your Ads";
		Assert.assertEquals(actual, expected);
		System.out.println("update page title verified");
	}
	
	@AfterMethod
	public void teardown(ITestResult result){
		 
		if(ITestResult.FAILURE==result.getStatus()){
			try{
			// To create reference of TakesScreenshot
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			// Call method to capture screenshot
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			// Copy files to specific location 
			// result.getName() will return name of test case so that screenshot name will be same as test case name
			FileUtils.copyFile(src, new File("/home/day/eclipse-workspace/WeeklyPaper/Screenshots"+result.getName()+".png"));
			System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
			System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
			}
		driver.quit();
		 }

}
