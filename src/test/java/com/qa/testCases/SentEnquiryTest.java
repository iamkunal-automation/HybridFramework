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
import com.qa.pages.SentEnquiryPage;

public class SentEnquiryTest extends TestBase {
	SentEnquiryPage sent;
	LoginPage login;

	public SentEnquiryTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		sent=new SentEnquiryPage();
		login=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void sentEnquiryLinkTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=sent.sentEnquiryLinkClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Sent enquiry link is clickable");
	}
	
	@Test(priority=2)
	public void sentEnquiryPageTitleTest() throws InterruptedException {
		login.loginfunctionality();
		String actual=sent.sentEnquiryPageTitle();
		String expected="WeeklyPaper - Enquiries Sent";
		Assert.assertEquals(actual, expected);
		System.out.println("Sent enquiry page title verified");
	}
	
	@Test(priority=3)
	public void verifyLinkOnSentEnquiryPageTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=sent.verifyEnquiryLinkOnSentEnquiryPage();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("enquiry link is clickable on sent enquiry page.");
	}
	@Test(priority=4)
	public void verifyEnquiredProductTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=sent.verifyEnquiriedProduct();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("enquired product verified");
	}
	
	@Test(priority=5)
	public void deleteSentEnquiryTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=sent.deleteEnquiry();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("sent enquiry deleted successfully");
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
