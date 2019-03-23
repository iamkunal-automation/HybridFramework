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
import com.qa.pages.ReceivedEnquiryPage;

public class ReceivedEnquiryPageTest extends TestBase {

	ReceivedEnquiryPage receive;
	LoginPage login;
	public ReceivedEnquiryPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		receive=new ReceivedEnquiryPage();
		login=new LoginPage();
	}
	
	@Test(priority=1)
	public void receivedLinkClickabilityTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=receive.receivedEnquiryLinkClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("received button is clickable");
	}
	
	@Test(priority=2)
	public void receivedEnquiryPageTitleTest() throws InterruptedException {
		login.loginfunctionality();
		String actual=receive.receivedEnquiryPageVerification();
		String expected="WeeklyPaper - Enquiries Received";
		Assert.assertEquals(actual, expected);
		System.out.println("Received enquiry page title verified");
	}
	
	@Test(priority=3)
	public void productLinkClickabiltyTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=receive.productLinkClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Product link is clickable on Received Enquiry page");
	}
	
	@Test(priority=4)
	public void fileLinkClickabilityTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=receive.fileLinkClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("File Link is clickable");
	}
	
	@Test(priority=5)
	public void deleteLinkClickabilityTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=receive.deleteLinkClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Delete Link is clickable");
	}
	
	@Test(priority=6)
	public void verifyproductLinkOnProductPageTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=receive.verifyProductLinkOnProductPage();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Product successfully verified on product page");
	}
	
	@Test(priority=7)
	public void DeleteReceivedEnquiryTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=receive.verifyDeleteReceivedEnquiry();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Received Enquiry Deleted Successfully");
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
