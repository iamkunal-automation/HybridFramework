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
import com.qa.pages.MyAccountPage;

public class MyAccountPageTest extends TestBase {
	MyAccountPage account;
	LoginPage login;
	
	MyAccountPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		account=new MyAccountPage();
		login=new LoginPage();
	}
	
	
	@Test(priority=1)
	public void MyAccountButtonClickabilityTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=account.MyAccountLinkClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("My Account button is clickable");
		
	}
	
	@Test(priority=2)
	public void myAccountPageTitleTest() throws InterruptedException {
		login.loginfunctionality();
		String actual=account.MyAccountPageTitle();
		String expected="WeeklyPaper - My Profile";
		Assert.assertEquals(actual, expected);
		System.out.println("My Account page title verified");
	}
	
	@Test(priority=3)
	public void upGradeNowButtonClickabilityTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=account.upGradenowButtonClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Upgrade Now button is clickable ");
	}

	@Test(priority=4)
	public void editButtonClickabilityTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=account.editButtonClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("edit button is clickable");
	}
	
	@Test(priority=5)
	public void fieldDisabilityTestBeforEdit() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=account.fieldDisabilityBeforeEdit();
		boolean expected=false;
		Assert.assertEquals(actual, expected);
		System.out.println("All the fields are disable before Edit Operation");
	}
	
	@Test(priority=6)
	public void updateAccountInfoTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=account.updateAccountInfo();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("account updated successfully");
	}
	
	@Test(priority=7)
	public void upgradeNowPageTest() throws InterruptedException {
		login.loginfunctionality();
		String actual=account.upGradeNowPageVerification();
		String expected="WeeklyPaper - Subscription Page";
		Assert.assertEquals(actual, expected);
		System.out.println("Upgrade Now Page is successfully displayed.");
	}
	
	@Test(priority=8)
	public void SubscriptioTypeButtonClickabilityTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=account.SubscriptionTypeButtonClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("subscription type button is clickable");
	}
	
	
	@Test(priority=9)
	public void SwitchToPayPalLoginTest() throws InterruptedException {
		login.loginfunctionality();
		String actual=account.SwitchToPayPalLogin();
		String expected="Log in to your PayPal account";
		Assert.assertEquals(actual, expected);
		System.out.println("successfully navigate to Pay pal login page");
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
