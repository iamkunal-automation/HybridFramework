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
import com.qa.pages.EnquiryPage;
import com.qa.pages.LoginPage;

public class EnquiryPageTest extends TestBase 
{
	EnquiryPage enquiry;
	LoginPage login;
     public EnquiryPageTest() {
    	 super();
     }
     
     @BeforeMethod
     public void setUp() {
    	 initialization();
    	 enquiry=new EnquiryPage();
    	 login=new LoginPage();
     }
     
     @Test(priority=1)
     public void EnquirySectionTest() throws InterruptedException {
    	 login.loginfunctionality();
    	boolean actual= enquiry.verifyEnquirySection();
    	boolean expected=true;
    	Assert.assertEquals(actual, expected);
    	System.out.println("Enquiry section verified");
     }
     
     @Test(priority=2)
     public void textboxPlaceholderTest() throws InterruptedException {
    	 login.loginfunctionality();
    	 boolean actual=enquiry.verifyPlaceHolder();
    	 boolean expected=true;
    	 Assert.assertEquals(actual, expected);
    	 System.out.println("Placeholder verified");
     }
     
     @Test(priority=3)
     public void subjectFieldValidationMessageTest() throws InterruptedException {
    	 login.loginfunctionality();
    	 boolean actual=enquiry.verifySubjectFieldValidation();
    	 boolean expected=true;
    	 Assert.assertEquals(actual, expected);
    	 System.out.println("Subject field validation message verified");
     }
     
     @Test(priority=4)
     public void descriptionFieldValidationMessageTest() throws InterruptedException {
    	 login.loginfunctionality();
    	 boolean actual=enquiry.verifyDescriptionFieldValidation();
    	 boolean expected=true;
    	 Assert.assertEquals(actual, expected);
    	 System.out.println("Description field validation message verified");
     }
     
     @Test(priority=5)
     public void sendEnquiryTest() throws InterruptedException {
    	 login.loginfunctionality();
    	 boolean actual=enquiry.sendEnquiry();
    	 boolean expected=true;
    	 Assert.assertEquals(actual, expected);
    	 System.out.println("Enquiry sent successfully");
     }
     
     @Test(priority=6)
     public void emailidFieldDisabilityTest() throws InterruptedException {
    	 login.loginfunctionality();
    	 boolean actual=enquiry.emailFieldDisabilityVerification();
    	 boolean expected=false;
    	 Assert.assertEquals(actual, expected);
    	 System.out.println("email id field is disable");
     }
     
     @Test(priority=7)
     public void remainingCharacterLengthDescriptionTest() throws InterruptedException {
    	 login.loginfunctionality();
    	 boolean actual=enquiry.verifyCharacterLengthOfCommentBox();
    	 boolean expected=true;
    	 Assert.assertEquals(actual, expected);
    	 System.out.println("maximum character length verified");
     }
     @Test(priority=8)
     public void chooseFileOfEnquirySectiontest() throws InterruptedException {
    	 login.loginfunctionality();
    	 boolean actual=enquiry.verifyChooseFileOfEnquirySection();
    	 boolean expected=true;
    	 Assert.assertEquals(actual, expected);
    	 System.out.println("file uploaded successfully");
    	 
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
