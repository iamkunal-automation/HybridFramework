package com.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.testng.Assert;
import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	Logger log = Logger.getLogger(LoginPageTest.class);
	LoginPage login;
	
	LoginPageTest()
	{
		super();
		
	}
	

	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		login=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException
	{
	  // log.info("verifying user Login");
	   login.loginfunctionality();
       //log.info("after login user verified");
}
	
	@Test(priority=2)
	public void loginpageValidationTest() throws InterruptedException
	{
		//log.info("clicking on empty login form");
		login.clickOnEmptyForm();
		//log.info("asserting the validation message");
		boolean validation=login.verifyValidationMessage();
		boolean expectedValidation=true;
		Assert.assertEquals(validation, expectedValidation);
		//log.info("login page validation verified successfully");
	}
	
	@Test(priority=3)
	public void inValidEmailTest() throws InterruptedException
	{
		//log.info("verifying login page with invalid email id");
		login.invalidemailentry();
		boolean actualvalidation=login.invalidEmail();
		boolean expectedvalidation=true;
		Assert.assertEquals(actualvalidation, expectedvalidation);
        //log.info("email field verified with invalid email data");
}
	
	@Test(priority=4)
	public void loginWithNotMatchedRecoredsTest() throws InterruptedException
	{
		//log.info("verifying login with not matched records");
	    login.notMatchedCredentials();
	    boolean actualvalidation=login.notMatchedCredentialsLogin();
	    boolean expectedvalidation=true;
	    Assert.assertEquals(actualvalidation, expectedvalidation);
        //log.info("validation displayed successfully in case of Not matched recoreds");
}
	
	@Test(priority=5)
	public void forgotPasswordTest() throws InterruptedException
	{
		//log.info("verifying forgot password");
		login.forgotpasswordoperation();
		boolean actualMessage=login.getForgotPasswordMessage();
		boolean expectedMessage=true;
		Assert.assertEquals(actualMessage, expectedMessage);
       // log.info("forgot password message link successfully sent to email.");
}
	
	@Test(priority=6)
	public void ForgotPasswordToLoginPopUpSwitchTest() throws InterruptedException
	{
		//log.info("switching forgot password page to login page");
		login.switchToForgotPasswordPage();
		boolean actualloginpage=login.SwitchToLOginPage();
		boolean expectedloginpage=true;
		Assert.assertEquals(actualloginpage, expectedloginpage);
       // log.info("switch to Login Pop up successfully :");		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
