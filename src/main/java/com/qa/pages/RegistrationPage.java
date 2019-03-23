package com.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class RegistrationPage  extends TestBase{
	
	//Page Factory : OR
	//Sign Up form
	@FindBy(xpath="//div[@class='login mobile_login']/a[2]")
	WebElement signupButton;
	
	@FindBy(xpath="//a[@href='#signup']")
	WebElement popupTitle;
	
	@FindBy(id="name")
	WebElement username;
	
	@FindBy(id="register-email")
	WebElement email;
	
	@FindBy(id="register-pwd")
	WebElement password;
	
	@FindBy(id="register-pwd-confirm")
	WebElement confirmpassword;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	WebElement agree;
	
	@FindBy(xpath="//button[text()=' Create Account ']")
	WebElement createaccount;
	
	@FindBy(xpath="//div[text()='A verification link has been sent to your email address.']")
	WebElement signupmessage;
	
	@FindBy(xpath="//strong[@id='name-error']")
	WebElement usernamevalidation;
	
	@FindBy(xpath="//strong[@id='password-error']")
	WebElement passwordvalidation;
	
	@FindBy(xpath="//strong[@id='email-error']")
	WebElement emailvalidation;
	
	@FindBy(xpath="//strong[@id='password_confirmation-error']")
	WebElement confirmpasswordvalidation;
	
	@FindBy(xpath="//strong[@id='agree-error']")
	WebElement checkboxvalidation;
	
	@FindBy(xpath="//input[@name='agree']/following-sibling::a[2]")
	WebElement termsAndConditionLinks;
	
	@FindBy(xpath="//input[@name='agree']/following-sibling::a[1]")
	WebElement privacyPolicyLinks;
	
	@FindBy(xpath="//strong[text()='The email has already been taken.']")
	WebElement alreadyEmailValidation;
	
	@FindBy(xpath="//strong[text()='The Password and Confirm Password does not match.']")
	WebElement mismatchPasswordWhileSignup;
	
	@FindBy(xpath="//strong[text()='Please Accept Privacy Policy and T&C']")
	WebElement checkboxValidation;
	
	@FindBy(xpath="//strong[text()='Password should not exceed more than 25 characters.']")
	WebElement passwordcharactervalidation;
	
	@FindBy(xpath="//strong[text()='Please enter a valid Email Address.']")
	WebElement invalidemailvalidation;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//initializing the page objects
	
     public RegistrationPage()
     {
    	 PageFactory.initElements(driver, this);
     }
     
     //Actions :
     
     //verify the Sign Up pop up
     public String verifyPopTitle() throws InterruptedException  {
    	 
    	 Thread.sleep(5000);
    	 WebElement signupButton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 Thread.sleep(5000);
    	 return popupTitle.getText();
    	 
     }
     
     //Fill the SignUp Form
     public  void fillSignUpForm() throws InterruptedException
     {
    	 Thread.sleep(5000);
    	 WebElement signupButton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 username.sendKeys("Kunal Kashyap");
    	 email.sendKeys("kunal.kashyap@saffrontech.net");
    	 password.sendKeys("Kunal@123");
    	 confirmpassword.sendKeys("Kunal@123");
    	 agree.click();
    	 //createaccount.click();
    	 WebElement createaccount=driver.findElement(By.xpath("//button[text()=' Create Account ']"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", createaccount);
     }
     
     //fill mismatch password and confirm password while sign up
     
     public void fillMismatchPasswordAndConfirmPassword() throws InterruptedException {
    	 Thread.sleep(5000);
    	 WebElement signupButton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 username.sendKeys("Kashyap Brothers");
    	 email.sendKeys("iamkunal@gmail.com");
    	 password.sendKeys("Kunal@123");
    	 confirmpassword.sendKeys("Kunal@123456");
    	 agree.click();
    	 //createaccount.click();
    	 WebElement createaccount=driver.findElement(By.xpath("//button[text()=' Create Account ']"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", createaccount);
     }
     
     public void fillSignUpWithoutCheckBoxClick() throws InterruptedException {
    	 Thread.sleep(5000);
    	 WebElement signupButton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 username.sendKeys("Kashyap Brothers");
    	 email.sendKeys("iamkunal@gmail.com");
    	 password.sendKeys("Kunal@123456");
    	 confirmpassword.sendKeys("Kunal@123456");
    	 WebElement createaccount=driver.findElement(By.xpath("//button[text()=' Create Account ']"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", createaccount);
     }
     
     public boolean fillSignUpFormWithTab() throws InterruptedException {
    	 Thread.sleep(5000);
    	 WebElement signupButton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 username.sendKeys(Keys.TAB);
    	 Thread.sleep(3000);
    	 email.sendKeys(Keys.TAB);
    	 Thread.sleep(3000);
         password.sendKeys(Keys.TAB);
    	 Thread.sleep(3000);
         confirmpassword.sendKeys(Keys.TAB);
         Thread.sleep(3000);
         agree.sendKeys(Keys.TAB);
    	 Thread.sleep(3000);
         termsAndConditionLinks.sendKeys(Keys.TAB);
    	 Thread.sleep(3000);
    	 privacyPolicyLinks.sendKeys(Keys.TAB);
    	 Thread.sleep(3000);
    	 createaccount.sendKeys(Keys.ENTER);
    	 String validation=checkboxValidation.getText();
    	 if(validation.contains("Accept Privacy Policy and T&C")) {
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
    	 
     }
     
     public void fillSignUpwithInvalidPasswordLength() {
    	 WebElement signupButton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 username.sendKeys("Kashyapaaaaa");
    	 email.sendKeys("iamkunsssal@gmail.com");
    	 password.sendKeys("Kunal@12333333333333333333333333333333333333333333333333333333333333");
    	 confirmpassword.sendKeys("Kunal@123333333333333333333333333333333333333333333333333333333333333");
    	 agree.click();
    	 //createaccount.click();
    	 WebElement createaccount=driver.findElement(By.xpath("//button[text()=' Create Account ']"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", createaccount);
     }
     
     public boolean invalidEmailVerification() throws InterruptedException {
    	 WebElement signupButton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 Thread.sleep(3000);
    	 username.sendKeys("kunalkashyap90008");
    	 email.sendKeys("kunaaaal@gmail....com");
    	 password.sendKeys("Kunal@123");
    	 confirmpassword.sendKeys("Kunal@123");
    	 agree.click();
    	 //createaccount.click();
    	 WebElement createaccount=driver.findElement(By.xpath("//button[text()=' Create Account ']"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", createaccount);
    	 
    	 Thread.sleep(6000);
    	 
    	 String validation=invalidemailvalidation.getText();
    	 if(validation.contains(" enter a valid Email Address")) {
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
     }
     
     //verify the signup successful message
     public String getSignUpMessage()
     {
    	 return signupmessage.getText();
     }
     
     
     public boolean userNameValidation()
     {
    	 
    	 String username=usernamevalidation.getText();
    	 if(username.contains("required"))
    	 {
    		
    		return true;
    		  }
    	 else {
    		 return false;
    	 }
    	 
    	
    	 
    	
    	 
    	 
     }
     
     public void clickOnEmptyForm()
     {
    	 WebElement signupButton =driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 
    	 
    	 WebElement createaccount =driver.findElement(By.xpath("//button[text()=' Create Account ']"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", createaccount);
     }
     
     
     public String termsAndConditionsLinkVerification() throws InterruptedException {
    	 WebElement signupButton =driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 Thread.sleep(5000);
    	 termsAndConditionLinks.click();
    	 String parent = driver.getWindowHandle();

    	  // Set S1 will store number of windows opened by Webdriver
    	  Set<String> s1 = driver.getWindowHandles();

    	  // Now we will iterate using Iterator
    	  Iterator<String> I1 = s1.iterator();

    	  while (I1.hasNext()) {
    	   // Create reference for Window B
    	   String child_window = I1.next();

    	   // Here we will compare if parent window is not equal to child window then we
    	   // will close

    	   if (!parent.equals(child_window)) {
    	    // Move Focus from Window A to Window B. Window B is active now
    	    driver.switchTo().window(child_window);

    	    // Complete the set of actions on Window B .
    	    String title=driver.switchTo().window(child_window).getTitle();
    	    System.out.println("title is :"+title);
    	    return title;
    	 
         
    	 
     }
    	  }
		return parent;
     }
     
     public String privacyPolicyLinksVerification() throws InterruptedException {
    	 WebElement signupButton =driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 Thread.sleep(5000);
    	 privacyPolicyLinks.click();
    	 String parent = driver.getWindowHandle();

    	  // Set S1 will store number of windows opened by Webdriver
    	  Set<String> s1 = driver.getWindowHandles();

    	  // Now we will iterate using Iterator
    	  Iterator<String> I1 = s1.iterator();

    	  while (I1.hasNext()) {
    	   // Create reference for Window B
    	   String child_window = I1.next();

    	   // Here we will compare if parent window is not equal to child window then we
    	   // will close

    	   if (!parent.equals(child_window)) {
    	    // Move Focus from Window A to Window B. Window B is active now
    	    driver.switchTo().window(child_window);

    	    // Complete the set of actions on Window B .
    	    String title=driver.switchTo().window(child_window).getTitle();
    	    System.out.println("title is :"+title);
    	    return title;
    	 
         
    	 
     }
    	  }
		return parent;
     }
     
     public boolean signupWithAlreradyRegisteredEmail() throws InterruptedException {
    	 fillSignUpForm();
    	 String validationMessage=alreadyEmailValidation.getText();
    	 if(validationMessage.contains("email has already")) {
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
    	 
     }
     
     public boolean verifyValidationWhileMismatchPasswordWhileSignUp() throws InterruptedException {
    	 fillMismatchPasswordAndConfirmPassword();
    	  String validationMessage=mismatchPasswordWhileSignup.getText();
          if(validationMessage.contains("Confirm Password does not match.")) {
        	  return true;
          }  
          else {
        	  return false;
          }
     }
     
     
     public boolean verifycheckBoxValidationWhileSignUp() throws InterruptedException {
    	 fillSignUpWithoutCheckBoxClick();
    	 String validationMessage=checkboxValidation.getText();
    	 if(validationMessage.contains("Accept Privacy Policy and T&C")) {
    		 return true;
    	 }
    	 else {
    		return  false;
    	 }
     }
     
     public boolean signUpPlaceHolderVerification() throws InterruptedException {
    	 WebElement signupButton =driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 Thread.sleep(5000);
    	 String username=driver.findElement(By.xpath("//input[@id='name']")).getAttribute("placeholder");
    	 String email=driver.findElement(By.xpath("//input[@id='register-email']")).getAttribute("placeholder");
    	 String password=driver.findElement(By.xpath("//input[@id='register-pwd']")).getAttribute("placeholder");
    	 String confirmpassword=driver.findElement(By.xpath("//input[@id='register-pwd-confirm']")).getAttribute("placeholder");
    	 if(username.contains("Username") && email.contains("Email") && password.contains("Password") && confirmpassword.contains("Confirm Password")) {
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
     }
     
     public boolean maximumPasswordLengthVerification() {
    	 fillSignUpwithInvalidPasswordLength();
    	 String validation=passwordcharactervalidation.getText();
    	 if(validation.contains(" should not exceed more than 25 characters")) {
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
     }
     																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
     public boolean checkBoxSelectVerification() throws InterruptedException {
    	 WebElement signupButton =driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 Thread.sleep(5000);
    	 
    	 if(!agree.isSelected()) {
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
     }
     
     
     
}
     
    
     
     
       
    	 
    	  
    			   
       
    
     
	
	


