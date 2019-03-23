package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utility.Utils;

public class MyAccountPage extends TestBase
{
	Utils util=new Utils();
	
	//Object Repository :OR
	@FindBy(xpath="//div[@class='myaccount']//ul//li[7]")
	WebElement myAccountLink;
	@FindBy(xpath="//div[@class='user_img']")
	WebElement userimage;
	@FindBy(xpath="//a[text()=' Upgrade Now ']")
	WebElement upgradeNowButton;
	
	@FindBy(xpath="//p[text()=' Kunal Kashyap ']")
	WebElement profileName;
	@FindBy(xpath="//p[text()=' kunal.kashyap@saffrontech.net ']")
	WebElement emailaddress;
	@FindBy(xpath="//p[text()=' India ']")
	WebElement country;
	@FindBy(xpath="//p[text()=' Delhi ']")
	WebElement state;
	@FindBy(xpath="//p[text()=' Saket ']")
	WebElement city;
	@FindBy(xpath="//p[text()=' 110030 ']")
	WebElement zip;
	@FindBy(xpath="//p[text()=' 1990-10-22 ']")
	WebElement birthdate;
	@FindBy(xpath="//p[text()=' Male ']")
	WebElement gender;
	
	@FindBy(xpath="//a[@class='edit_profile']")
	WebElement editButton;
	@FindBy(xpath="//input[@id='image']")
	WebElement uploadimage;
	@FindBy(xpath="//input[@value='Update']")
	WebElement updateAccount;
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement tinycrosupdatebutton;
	
	@FindBy(xpath="//div[@class='subscriptions']//button")
	WebElement upGradeToPayPal;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean MyAccountLinkClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		if(myAccountLink.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String MyAccountPageTitle() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		myAccountLink.click();
		String title=driver.getTitle();
		return title;
	}
	
	public boolean upGradenowButtonClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		myAccountLink.click();
		if(upgradeNowButton.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean fieldDisabilityBeforeEdit() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		myAccountLink.click();
		if(profileName.isEnabled()&&emailaddress.isEnabled()&&country.isEnabled()&&state.isEnabled()&&city.isEnabled()&&zip.isEnabled()&&birthdate.isEnabled()&&gender.isEnabled()) {
			return false;
		}
		else {
			 return true;
		}
		
	}
	
	public boolean updateAccountInfo() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		myAccountLink.click();
		util.scrollPage();
		WebElement editButton =driver.findElement(By.xpath("//a[@class='edit_profile']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", editButton);
	   	 util.scrollPage();
	   	WebElement uploadimage=driver.findElement(By.xpath("//input[@id='image']"));
	   	uploadimage.sendKeys("/home/day/Desktop/banner3.jpg");
	   	WebElement updateAccount =driver.findElement(By.xpath("//input[@value='Update']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", updateAccount);
	   	if(tinycrosupdatebutton.isEnabled()) {
	   		return true;
	   	}
	   	else {
	   		return false;
	   	}

		
	}
	public String upGradeNowPageVerification() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		myAccountLink.click();
		WebElement upgradeNowButton =driver.findElement(By.xpath("//a[text()=' Upgrade Now ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", upgradeNowButton);
	   	 String title=driver.getTitle();
	   	 return title;
	}
	
	public String SwitchToPayPalLogin() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		myAccountLink.click();
		WebElement upgradeNowButton =driver.findElement(By.xpath("//a[text()=' Upgrade Now ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", upgradeNowButton);
	   	 util.scrollPage();
	   	WebElement upGradeToPayPal =driver.findElement(By.xpath("//div[@class='subscriptions']//button"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", upGradeToPayPal);
	   	 String title=driver.getTitle();
	   	 return title;
	   	 
		
	}
	
	public boolean editButtonClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		myAccountLink.click();
		if(editButton.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public boolean SubscriptionTypeButtonClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		myAccountLink.click();
		WebElement upgradeNowButton =driver.findElement(By.xpath("//a[text()=' Upgrade Now ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", upgradeNowButton);
	   	 util.scrollPage();
		if(upGradeToPayPal.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	

}

