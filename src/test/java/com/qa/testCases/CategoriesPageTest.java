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
import com.qa.pages.CategoriesPage;
import com.qa.pages.LoginPage;

public class CategoriesPageTest extends TestBase {

	LoginPage login;
	CategoriesPage category;
    public CategoriesPageTest() {
   	 super();
    }
    
    @BeforeMethod
    public void setUp() {
   	 initialization();
   	category=new CategoriesPage();
   	 login=new LoginPage();
    }
    
    
    @Test(priority=1)
    public void countCategoryTest() {
    	int actual=category.countCategoryList();
    	int expected=14;
    	Assert.assertEquals(actual, expected);
    	System.out.println("Category list verified");
    }
    
    @Test(priority=2)
    public void categoryMenuClickabilityTest() {
    	boolean actual=category.categoriesMenuClickability();
    	boolean expected=true;
    	Assert.assertEquals(actual, expected);
    	System.out.println("Category Button is clickable");
    }
    
    @Test(priority=3)
    public void verifyCategoryPageTitleTest() throws InterruptedException {
    	String actual=category.verifyCategoryPageTitle();
    	String expected="";
    	Assert.assertEquals(actual, expected);
    	System.out.println("Title verified");
    }
   @Test(priority=4)
	public void countArtBookssubcategories() throws InterruptedException
	{
    	category.countSubCategoryOfArtBooks();
	}
	
	@Test(priority=5)
	public void countAutomotivesubcategories() throws InterruptedException
	{
		category.countSubCategoryOfAutomotive();
	}
	
	@Test(priority=6)
	public void countBoatsAndSkisSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfBoatsAndSkis();
	}
	
	@Test(priority=7)
	public void countClothesAndJewelSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfClothsAndJewel();
	}
	
	@Test(priority=8)
	public void countCommunitySubCategories() throws InterruptedException
	{
		category.countSubCategoryOfCommunity();
	}
	
	@Test(priority=9)
	public void countConsumerElectronicsSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfConsumerElectronics();
	}
	
	@Test(priority=10)
	public void countDiscussionForumsSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfDiscussionForums();
	}
	
	@Test(priority=11)
	public void countJobsSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfJobs();
	}
	
	@Test(priority=12)
	public void countLocalPlacesSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfLocalPlaces();
	}
	
	@Test(priority=13)
	public void countOthersSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfOthers();
	}
	
	@Test(priority=14)
	public void countPetsSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfPets();
	}
	
	@Test(priority=15)
	public void countRealEstateSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfRealEstate();
	}
	
	@Test(priority=16)
	public void countResumesSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfResume();
	}
	
	@Test(priority=17)
	public void countServicesSubcategories() throws InterruptedException
	{
		category.countSubCategoryOfServices();
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
