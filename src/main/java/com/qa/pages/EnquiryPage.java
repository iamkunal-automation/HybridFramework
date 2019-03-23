package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utility.Utils;

public class EnquiryPage extends TestBase {
	Utils util=new Utils();
	
	@FindBy(xpath="//a[text()=' Art / Books / Collectables / Music ']")
	WebElement categoryName;
	@FindBy(xpath="//div[@class='list_details']//a")
	WebElement productlink;
	@FindBy(xpath="//h3[text()=' Send your enquiry for this Ad ']")
	WebElement enquirySectionHeading;
	@FindBy(xpath="//input[@id='enq-subject']")
	WebElement enquirySubjectTextBox;
	@FindBy(xpath="//textarea[@id='enq-desc']")
	WebElement enquiryDescriptionTextBox;
	@FindBy(xpath="//input[@class='btn btn-primary createbtn enq-btn']")
	WebElement submitButton;
	@FindBy(xpath="//p[text()='The subject field is required.']")
	WebElement subjectvalidationMessage;
	@FindBy(xpath="//p[text()='The description field is required.']")
	WebElement descriptionvalidationMessage;
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement tinycrossbutton;
	@FindBy(xpath="//input[@name='email' and @value='kunal.kashyap@saffrontech.net ']")
	WebElement emailidfield;
	@FindBy(xpath="//span[text()='0']")
	WebElement remainingcharactermessage;
	@FindBy(xpath="//input[@type='file']")
	WebElement chooseFile;
	
	
	
	
	
	
	
	
	
	
	
	
	public EnquiryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyEnquirySection() throws InterruptedException {
		categoryName.click();
		Thread.sleep(3000);
		productlink.click();
		util.scrollPage();
		String heading=enquirySectionHeading.getText();
		if(heading.contains("Send your enquiry")) {
			return true;
		}
		return false;
		
		
	}
	
	public boolean verifyPlaceHolder() throws InterruptedException {
		categoryName.click();
		Thread.sleep(3000);
		productlink.click();
		util.scrollPage();
		String subjectPlaceholder=enquirySubjectTextBox.getAttribute("placeholder");
		String descriptionPlaceholder=enquiryDescriptionTextBox.getAttribute("placeholder");
		if(subjectPlaceholder.contains("Subject")&& descriptionPlaceholder.contains("Comments")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean verifySubjectFieldValidation() throws InterruptedException {
		categoryName.click();
		Thread.sleep(3000);
		productlink.click();
		util.scrollPage();
		WebElement submitButton=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn enq-btn']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", submitButton);
	   	 Thread.sleep(6000);
	   	 String validation=subjectvalidationMessage.getText();
	   	 if(validation.contains("subject field")) {
	   		 return true;
	   	 }
	   	 else {
	   		 return false;
	   	 }
	}
	
	public boolean verifyDescriptionFieldValidation() throws InterruptedException {
		categoryName.click();
		Thread.sleep(3000);
		productlink.click();
		util.scrollPage();
		enquirySubjectTextBox.sendKeys("My first subject");
		WebElement submitButton=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn enq-btn']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", submitButton);
	   	 Thread.sleep(6000);
	   	String validation=descriptionvalidationMessage.getText(); 
	   	if(validation.contains("description field")) {
	   		return true;
	   	}
	   	else {
	   		return false;
	   	}
	}
	public boolean sendEnquiry() throws InterruptedException
	{
		categoryName.click();
		Thread.sleep(3000);
		productlink.click();
		util.scrollPage();
		enquirySubjectTextBox.sendKeys("My First Subject");
		enquiryDescriptionTextBox.sendKeys("My First Description");
		WebElement submitButton=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn enq-btn']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", submitButton);
	   	 if(tinycrossbutton.isEnabled()) {
	   		 return true;
	   	 }
	   	 else {
	   		 return false;
	   	 }
	   	 
		
	}
	
	public boolean emailFieldDisabilityVerification() throws InterruptedException {
		categoryName.click();
		Thread.sleep(3000);
		productlink.click();
		util.scrollPage();
		Thread.sleep(6000);
		if(emailidfield.isEnabled()) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public boolean verifyCharacterLengthOfCommentBox() throws InterruptedException {
		categoryName.click();
		Thread.sleep(3000);
		productlink.click();
		util.scrollPage();
		enquirySubjectTextBox.sendKeys("Test Subject");
	    enquiryDescriptionTextBox.sendKeys("KunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashyKunalKashy");
	    String remaining=remainingcharactermessage.getText();
	    if(remaining.contains("0")) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	public boolean verifyChooseFileOfEnquirySection() throws InterruptedException {
		categoryName.click();
		Thread.sleep(3000);
		productlink.click();
		util.scrollPage();
		enquirySubjectTextBox.sendKeys("Test Subject");
		enquiryDescriptionTextBox.sendKeys("Kunal Kashyap Kunal Kashyap Kunal Kashyap");
		WebElement chooseFile=driver.findElement(By.xpath("//input[@type='file']"));
		chooseFile.sendKeys("/home/day/Desktop/banner3.jpg");
		Thread.sleep(5000);
		WebElement submitButton=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn enq-btn']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", submitButton);
	   	 if(tinycrossbutton.isEnabled()) {
	   		 return true;
	   	 }
	   	 else {
	   		 return false;
	   	 }
	}
	

}
