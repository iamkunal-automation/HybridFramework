package com.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.PostAddPage;

public class PostAddTest extends TestBase {
	Logger log = Logger.getLogger(PostAddTest.class);

	PostAddPage postadd;
	LoginPage login;
	
	
	
	public PostAddTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		postadd=new PostAddPage();
		login=new LoginPage();
	}
	@Test(priority=1)
	public void postAddButtonClickabilityTest() {
		boolean status=postadd.postAddButtonClickability();
		boolean expected=true;
		Assert.assertEquals(status, expected);
		System.out.println("Post button is clickable");
	}
	
	@Test(priority=2)
	public void requiredFieldVerificationTest() throws InterruptedException {
		login.loginfunctionality();
		boolean status=postadd.requiredFieldVerification();
		boolean expected=true;
		Assert.assertEquals(status, expected);
		System.out.println("required field * marked validation verified");
	}
	
	@Test(priority=3)
	public void requiredFieldValidationTest() throws InterruptedException {
		login.loginfunctionality();
		boolean status=postadd.requiredFieldValidation();
		boolean expected=true;
		Assert.assertEquals(status, expected);
		System.out.println("required field validation verified");
	}
	
	@Test(priority=4)
	public void verfyPostAdPageTest()
	{
		boolean actualHeading=postadd.verifyPostFreeAdPage();
		boolean expectedHeading=true;
		Assert.assertEquals(actualHeading, expectedHeading);
		System.out.println("Free Post Ad page verified successfully");
	}
	
	@Test(priority=5)
	public void postAddTest() throws InterruptedException
	{
		//log.info("posting the ad.");
		postadd.clickonPostAd();
		postadd.loginUnderPostAdd();
		Thread.sleep(5000);
		postadd.clickonPostAd();
		//log.info("filling ad. details");
		postadd.FillAddDetails();
		//log.info("ad. posted successfully");
	}
	
	@Test(priority=6)
	public void categoryCountTest()
	{
		boolean actualcount=postadd.countCategoryonPostAddPage();
		boolean expectedcount=true;
		Assert.assertEquals(actualcount, expectedcount);
		System.out.println("category count is as per requirement");
	}
	
	@Test(priority=7)
	public void uploadImageTest() throws InterruptedException
	{
		postadd.loginfunctionality();
		postadd.fillUploadImage();
		boolean actualmessage=postadd.verifyUploadImage();
		boolean expectedmessage=true;
		Assert.assertEquals(actualmessage, expectedmessage);
		System.out.println("uploaded image verified successfully");
	}
	
	@Test(priority=8)
	public void VerifydeleteAdTest() throws InterruptedException
	{
		postadd.deleteAd();
		boolean actualStatus=postadd.verifyDeleteAd();
		boolean expectedStatus=true;
		Assert.assertEquals(actualStatus, expectedStatus);
		System.out.println("ad deleted successfully");
	}
	
	@Test(priority=9)
	public void SubCategoryCorresspondingCategoryTest() throws InterruptedException {
		login.loginfunctionality();
		int actual=postadd.countSubcategory();
		System.out.println("actual subcategory is : "+actual);
		int expected=7;
		System.out.println("expected subcategory is : "+expected);
		Assert.assertEquals(actual, expected);
		System.out.println("Sub categories displayed corresponding to categories");
	}
	
	@Test(priority=10)
	public void tabFunctionalityOfPostAdFormTest() throws InterruptedException {
		login.loginfunctionality();
		boolean actual=postadd.tabFunctionalityOfPostAdForm();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("tab functionality working fine");
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
