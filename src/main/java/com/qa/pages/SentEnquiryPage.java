package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class SentEnquiryPage extends TestBase {

	
	@FindBy(xpath="//div[@class='user_img']")
	WebElement userimage;
	@FindBy(xpath="//div[@class='myaccount']//ul//li[5]")
	WebElement sentEnquiryLink;
	@FindBy(xpath="//table//tbody//tr//a")
	WebElement enquirytableLink;
	
	@FindBy(xpath="//h2[text()=' gfhf ']")
	WebElement enquiredProduct;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	WebElement deleteEnquiry;
	@FindBy(xpath="//button[text()='Yes']")
	WebElement deletePopUp;
	
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement tinyCrossbutton;
	
	
	
	
	
	
	
	
	
	
	
	public SentEnquiryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean sentEnquiryLinkClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		if(sentEnquiryLink.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String sentEnquiryPageTitle() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		sentEnquiryLink.click();
		String title=driver.getTitle();
		return title;
	}
	public boolean verifyEnquiryLinkOnSentEnquiryPage() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		sentEnquiryLink.click();
		if(enquirytableLink.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean verifyEnquiriedProduct() throws InterruptedException {
		
		userimage.click();
		Thread.sleep(3000);
		sentEnquiryLink.click();
		String actualProductName=enquirytableLink.getText();
		enquirytableLink.click();
		String expectedProductName=enquiredProduct.getText();
		if(expectedProductName.equalsIgnoreCase(actualProductName)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean deleteEnquiry() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		sentEnquiryLink.click();
		deleteEnquiry.click();
		WebElement deletePopUp =driver.findElement(By.xpath("//button[text()='Yes']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", deletePopUp);
	   	 if(tinyCrossbutton.isEnabled()) {
	   		 return true;
	   	 }
	   	 else {
	   		 return false;
	   	 }
	}
}
