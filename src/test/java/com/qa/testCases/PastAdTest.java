package com.qa.testCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.PastAdPage;

public class PastAdTest extends TestBase {
	
	PastAdPage past;
	LoginPage login;
	
	public  PastAdTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		past=new PastAdPage();
		login=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void pastAdClickability() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=past.pastAdButtonClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("past ad button is clickable");
	}
	
	@Test(priority=2)
	public void pastAdPageTitletest() throws InterruptedException {
		login.loginfunctionality();
		String actual=past.pastAdPageTitle();
		String expected="WeeklyPaper - My Past Ads";
		Assert.assertEquals(actual, expected);
		System.out.println("past Ad page title verified.");
	}
	
	@Test(priority=3)
	public void noPastAdMessageTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=past.noPastAdMessage();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Message verified in case of no past ad.");
		
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
