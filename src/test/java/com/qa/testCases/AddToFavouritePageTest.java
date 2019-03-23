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
import com.qa.pages.AddToFavouritePage;
import com.qa.pages.LoginPage;


public class AddToFavouritePageTest extends TestBase {
 
	AddToFavouritePage favourite;
	LoginPage login;
	
	public AddToFavouritePageTest() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		favourite=new AddToFavouritePage();
		login=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void favouriteAdLinkClickabilityTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=favourite.favouriteAdLinkClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("favourite ad link is clickable");
		
	}
	
	@Test(priority=2)
	public void favouriteAdPageTitleTest() throws InterruptedException {
		login.loginfunctionality();
		String actual=favourite.favouriteAdPageVerification();
		String expected="WeeklyPaper - My Favourite Ads";
		Assert.assertEquals(actual, expected);
		System.out.println("Favourite ad page verified");
	}
	
	
	@Test(priority=3)
	public void favouriteIconEnableTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=favourite.favouriteIconEnableVerification();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("favourite icon is enabled");
	}
	
	@Test(priority=4)
	public void favouriteVerificationTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=favourite.verifyFavouriteAd();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("favourite ad verified successfully");
	}
	
	@Test(priority=5)
	public void deleteFavouriteAdTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=favourite.verifyDeleteAd();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("favourite ads delete successfully");
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
