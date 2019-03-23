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
import com.qa.pages.SearchPage;

public class SearchPageTest extends TestBase {

	SearchPage search;
	SearchPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		search=new SearchPage();
	}
	
	
	@Test(priority=1)
	public void searchWithEmptyKeywordTest() {
		boolean actual=search.verifySearchWithEmptyKeyword();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("OK pop up  verified with empty keyword");
	}

	@Test(priority=2)
	public void searchButtonClickabilityTest() {
		boolean actual=search.searchButtonClickability();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Search button is clickable");
	}
	
	@Test(priority=3)
	public void NoResultFoundOnSearchTest() {
		String actual=search.verifyNoResultFoundSearch();
		String expected="No Results Found!";
		Assert.assertEquals(actual, expected);
		System.out.println("No Result Found Message Verified");
	}
	
	@Test(priority=4)
	public void verifySearchResultTest() {
		boolean actual=search.verifySearchResult();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("search result verified");
	}
	
	@Test(priority=5)
	public void placeholderTest() {
		String actual=search.verifyPlaceHolder();
		System.out.println(actual);
		String expected="I'm looking for...";
		Assert.assertEquals(actual, expected);
		System.out.println("placeholder verified");
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
