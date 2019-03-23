package com.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;

import com.qa.base.TestBase;
import com.qa.pages.RegistrationPage;
import com.qa.utility.ScreenShotListener;

public class SignUpPageTest extends TestBase {
	Logger log = Logger.getLogger(SignUpPageTest.class);

	
	RegistrationPage registration;
	
	public SignUpPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		registration=new RegistrationPage();
	}

	
	@Test(priority=1)
	public void SignUpPopUpTest() throws InterruptedException
	{
		//log.info("Verifying the signUp  pop up  title");
		String actual=registration.verifyPopTitle();
		String expected="Sign Up";
		Assert.assertEquals(actual, expected);
		System.out.println("Sign Up Pop Up verified");
				
	}
	@Test(priority=2)
	public void SignUpFormTest() throws InterruptedException
	{
		//log.info("filling the sign up form");
		registration.fillSignUpForm();
		String actualstring=registration.getSignUpMessage();
		String expectedexpectedstring="A verification link has been sent to your email address.";
		Assert.assertEquals(actualstring, expectedexpectedstring,"message not matched");
        //log.info("sign up operation verified successfully");
		}
	
	@Test(priority=3)
	public void usernameValidationTest() throws InterruptedException
	{
		//log.info("verifying user name validation");
		registration.clickOnEmptyForm();
		Thread.sleep(5000);
		Boolean validation_status=registration.userNameValidation();
		Boolean expectedvalidation=true;
		Assert.assertEquals(validation_status, expectedvalidation);
        //log.info("user name validation verified successfully");	
}
	
	@Test(priority=4)
	public void termsAndConditionsLinkTest() throws InterruptedException {
		String actualTitle=registration.termsAndConditionsLinkVerification();
		String expectedTitle="WeeklyPaper - Terms and conditions";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("TERMS AND CONTIONS LINKS VERIFIED SUCCESSFULLY");
	}
	
	@Test(priority=5)
	public void privacyPolicyLinksTest() throws InterruptedException {
		String actualTitle=registration.privacyPolicyLinksVerification();
		String expectedTitle="WeeklyPaper - Privacy Policy";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("PRIVACY POLICY LINK VERIFIED SUCCESSFULLY");
	}
	
	@Test(priority=6)
	public void signUpWithalreadyRegisteredEmail() throws InterruptedException {
		boolean actualStatus=registration.signupWithAlreradyRegisteredEmail();
		boolean expectedStatus=true;
		Assert.assertEquals(actualStatus, expectedStatus);
		System.out.println("validation verified in case if user enter already registered email while sign up");
	}
	
	@Test(priority=7)
	public void passwordAndConfirmPasswordMismatchTest() throws InterruptedException {
		boolean actual=registration.verifyValidationWhileMismatchPasswordWhileSignUp();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("validation message verified while user entered mismatched password and confirm password");
	}
	
	@Test(priority=8)
	public void checkBoxValidationTest() throws InterruptedException {
		boolean actual=registration.verifycheckBoxValidationWhileSignUp();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("check box validation verified when user doesn't click on ckeckbox while signup");
	}
	@Test(priority=8)
	public void signUpWithTabTest() throws InterruptedException {
		boolean actual=registration.fillSignUpFormWithTab();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Tab Functionality working fine");
	}
	
	@Test(priority=9)
	public void SignUpPlaceholderTest() throws InterruptedException {
		boolean actual=registration.signUpPlaceHolderVerification();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("placeholder verified successfully");
	}
	
	@Test(priority=10)
	public void maximumPasswordLenghtValidationTest() {
		boolean actual=registration.maximumPasswordLengthVerification();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("maximum password length validation verified");
	}
	
	@Test(priority=11)
	public void invalidEmailTest() throws InterruptedException {
		boolean actual=registration.invalidEmailVerification();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("invalid email validation verified");
	}
	
	@Test(priority=12)
	public void checkBoxSelectionTest() throws InterruptedException {
		boolean actual=registration.checkBoxSelectVerification();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("checkbox is by default unselected");
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








