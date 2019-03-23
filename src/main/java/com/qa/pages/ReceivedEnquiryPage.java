package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ReceivedEnquiryPage extends TestBase {
	
	@FindBy(xpath="//div[@class='myaccount']//ul//li[6]")
	WebElement receivedenquiryLink;
	@FindBy(xpath="//div[@class='user_img']")
	WebElement userimage;
	@FindBy(xpath="//table//tbody//a[1]")
	WebElement productLinkOnReceivedEnquiryPage;
	@FindBy(xpath="//a[text()='File Link']")
	WebElement fileLinkOnReceivedEnquiryPage;
	@FindBy(xpath="//td[@data-th='Delete']")
	WebElement deleteLink;
	@FindBy(xpath="//button[text()='Yes']")
	WebElement YESButton;
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement tinyCross;
	
	@FindBy(xpath="//h2[text()=' My Title ']")
	WebElement productname;
	
	
	
	public ReceivedEnquiryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean receivedEnquiryLinkClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		if(receivedenquiryLink.isEnabled()){
			return true;		
		}
		else{
			return false;
		}
	}
	
	public String receivedEnquiryPageVerification() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		receivedenquiryLink.click();
		String title=driver.getTitle();
		return title;
	}
	
	public boolean productLinkClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(5000);
		receivedenquiryLink.click();
		if(productLinkOnReceivedEnquiryPage.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean fileLinkClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(5000);
		receivedenquiryLink.click();
		if(fileLinkOnReceivedEnquiryPage.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean deleteLinkClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(5000);
		receivedenquiryLink.click();
		if(deleteLink.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean verifyProductLinkOnProductPage() throws InterruptedException {
		userimage.click();
		Thread.sleep(5000);
		receivedenquiryLink.click();
		String linkTextOnReceivedEnquiryPage=productLinkOnReceivedEnquiryPage.getText();
		productLinkOnReceivedEnquiryPage.click();
		String productName=productname.getText();
		if(linkTextOnReceivedEnquiryPage.equalsIgnoreCase(productName)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean verifyDeleteReceivedEnquiry() throws InterruptedException {
		userimage.click();
		Thread.sleep(5000);
		receivedenquiryLink.click();
		deleteLink.click();
		WebElement YESButton=driver.findElement(By.xpath("//button[text()='Yes']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", YESButton);
	   	 if(tinyCross.isEnabled()) {
	   		 return true;
	   	 }
	   	 else {
	   		 return false;
	   	 }
	   	 
		
	}

}
