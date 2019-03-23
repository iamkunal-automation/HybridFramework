package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;
import com.qa.utility.Utils;

public class LoginPage extends TestBase {
	
	Utils util=new Utils();
	
	 // OR :
	
		@FindBy(id="email")
		WebElement loginemail;
		@FindBy(id="password")
		WebElement loginpassword; 
		
		@FindBy(xpath="//input[@id='login']")
		WebElement loginsubmit; 
		
		
		
		@FindBy(xpath="//div[@class='after_login']")
		WebElement afterlogin;
		
		@FindBy(xpath="//strong[@id='email-error-login']")
		WebElement usernameValidation;
		
		@FindBy(xpath="//strong[@id='email-error-login']")
		WebElement invalidemailid;
		
		@FindBy(xpath="//div[text()='These credentials do not match our records.']")
		WebElement notMatchedCredentials;
		
		@FindBy(xpath="//a[@id='forgotpass']")
		WebElement forgotpassword;
		
		@FindBy(xpath="//input[@id='email-forgot']")
		WebElement enteremailforgotpassword;
		
		@FindBy(xpath="//input[@id='forgotpassword']")
		WebElement submitforgotpassword;
		
		@FindBy(xpath="//div[@class='msg-forgot']")
		WebElement forgotpasswordmessage;
		
		@FindBy(xpath="//a[@id='backtologin']")
		WebElement forgotToLoginSwitch;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Initialize the web elements
		
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		 // Actions:
		
		 //verify the Login functionality
	     
	     public boolean loginfunctionality() throws InterruptedException
	     {
	    	 util.myWait(2000);
	    	 WebElement loginbutton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[1]"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginbutton);
	    	 util.myWait(2000);
	    	 loginemail.sendKeys("kunal.kashyap@saffrontech.net");
	    	 util.myWait(2000);
	    	 loginpassword.sendKeys("Kunal@123");
	    	 util.myWait(2000);
	    	 
	    	 WebElement loginsubmit=driver.findElement(By.xpath("//input[@id='login']"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginsubmit);
	    	 util.myWait(5000);
	    	 
	    	 //return new HomePage();
	    	 Boolean verifyuser=afterlogin.isDisplayed();
	    	 return verifyuser;
	    	 
	    	 
	     }
	     
	     public void clickOnEmptyForm() throws InterruptedException
	     {
	    	 WebElement loginbutton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[1]"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginbutton);
	    	 WebElement loginsubmit=driver.findElement(By.xpath("//input[@id='login']"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginsubmit);
	    	 util.myWait(5000);
	     }
	     
	     public boolean verifyValidationMessage()
	     {
	    	 String emailvalidation=usernameValidation.getText();
	    	 if(emailvalidation.contains("required"))
	    	 {
	    		 return true;
	    	 }
	    	 else {
	    		 return false;
	    	 }
	     }
	     
	     public boolean invalidEmail()
	     {
	    	 String invalidemail=invalidemailid.getText();
	    	 if(invalidemail.contains("valid Email"))
	    	 {
	    		 return true;
	    	 }
	    	 else {
	    		 return false;
	    	 }
	     }
	     
	     public void invalidemailentry() throws InterruptedException
	     {

	    	 WebElement loginbutton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[1]"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginbutton);
	    	 loginemail.sendKeys("kunal@gmail..com");
	    	 
	    	 WebElement loginsubmit=driver.findElement(By.xpath("//input[@id='login']"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginsubmit);
	    	 util.myWait(5000);
	    	 
	     }
	     
	     public void notMatchedCredentials() throws InterruptedException
	     {
	    	 WebElement loginbutton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[1]"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginbutton);
	    	 loginemail.sendKeys("kunal@gmail.com");
	    	 loginpassword.sendKeys("1234");
	    	 WebElement loginsubmit=driver.findElement(By.xpath("//input[@id='login']"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginsubmit);
	    	 util.myWait(5000);
	    	 
	     }
	     
	     public boolean notMatchedCredentialsLogin()
	     {
	    	 String  validation=notMatchedCredentials.getText();
	    	 if(validation.contains(" do not match"))
	    	 {
	    		 return true;
	    	 }
	    	 else {
	    		 return false;
	    	 }
	     }
	     
	     public void forgotpasswordoperation() throws InterruptedException
	     {
	    	 WebElement loginbutton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[1]"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginbutton);
	    	 Thread.sleep(5000);
	    	 WebElement forgotpassword=driver.findElement(By.xpath("//a[@id='forgotpass']"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", forgotpassword);
	    	 Thread.sleep(5000);
	    	 enteremailforgotpassword.sendKeys("kunal.kashyap@saffrontech.net");
	    	 WebElement submitforgotpassword =driver.findElement(By.xpath("//input[@id='forgotpassword']"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", submitforgotpassword);
	    	 Thread.sleep(5000);
	    	 
	    	 
	     }
	     
	     public boolean getForgotPasswordMessage()
	     {
	    	 String message=forgotpasswordmessage.getText();
	    	 if(message.contains("check your Email"))
	    	 {
	    		 return true;
	    	 }
	    	 else {
	    		 return false;
	    	 }
	     }
	     
	     public  void switchToForgotPasswordPage() throws InterruptedException
	     {
	    	 WebElement loginbutton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[1]"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginbutton);
	    	 Thread.sleep(5000);
	    	 WebElement forgotpassword=driver.findElement(By.xpath("//a[@id='forgotpass']"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", forgotpassword);
	    	 Thread.sleep(5000);
	     }
	     
	     public boolean SwitchToLOginPage() throws InterruptedException
	     {
	    	 WebElement forgotToLoginSwitch=driver.findElement(By.xpath("//a[@id='backtologin']"));
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", forgotToLoginSwitch);
	    	 Thread.sleep(5000);
	    	 if(loginsubmit.isEnabled())
	    	 {
	    		 return true;
	    	 }
	    	 else {
	    		 return false;
	    	 }
	    	 
	     }
	     

}
