package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;
import com.qa.utility.Utils;

public class PostAddPage extends TestBase {
	
	Utils util=new Utils();
	
	// OR : for Login
	@FindBy(id="email")
	WebElement loginemail;
	@FindBy(id="password")
	WebElement loginpassword; 
	@FindBy(xpath="//div[@class='after_login']")
	WebElement afterlogin;
	
	//OR : for Add to cart
	
	@FindBy(xpath="//select[@id='category_id']")
	WebElement categories;
	
	@FindBy(xpath="//select[@name='sub_category_id']")
	WebElement subcategories;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-custom']//button")
	WebElement tinycrossbutton;
	
	@FindBy(xpath="//div[@class='myaccount']//ul//li[1]")
	WebElement currentAds;
	
	@FindBy(xpath="//tbody//tr//td//form")
	WebElement deleteAdtinybutton;
	
	@FindBy(xpath="	//div[@class='swal-button-container']//button[text()='Yes']")
	WebElement deleteYesButton;
	
	@FindBy(xpath="//div[@class='user_img']")
	WebElement userImage;
	
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement deletesuccesstinybutton;
	
	@FindBy(xpath="//div[@class='post_add']/a")
	WebElement addpostbutton;
	
	@FindBy(xpath="//select[@id='state']")
	WebElement state;
	@FindBy(xpath="//input[@id='zip']")
	WebElement zip;
	@FindBy(xpath="//input[@id='address']")
	WebElement address;
	@FindBy(xpath="//input[@id='files']")
	WebElement image;
	@FindBy(xpath="//select[@id='status_dropdown']")
	WebElement status;
	
	@FindBy(xpath="//input[@class='btn btn-primary createbtn']")
	WebElement cretaeAd;
	
	@FindBy(xpath="//input[@class='btn btn-primary createbtn']")
	WebElement price;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//td[@data-th='Actions']//form[@action='http://beta.weeklypaper.org/US/myads/288']
	
	
	
	
	
	
	
	
	
	
	//for initializing  web elements
	public PostAddPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Actions :
	
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
	
	public boolean FillAddDetails() throws InterruptedException
	{
		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
   	 categories.click();
   	 util.selectValueFromDropdown(categories, 1);
   	 util.myWait(10000);
   	// subcategories.click();
   	 //util.selectValueFromDropdown(subcategories, 0);
   	// util.myWait(10000);
   	 title.sendKeys("Lamborgini");
   	 description.sendKeys("My First Ad.");
   	 util.myWait(10000);
   	JavascriptExecutor js = (JavascriptExecutor) driver;
   	js.executeScript("window.scrollBy(0,1000)");
   	 //country.click();
   	 //util.selectValueFromDropdown(country, 0);
   	 util.myWait(10000);
   	 city.sendKeys("Fremont");
   	 util.myWait(3000);
   	 WebElement Createad=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn']"));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Createad);
   	 boolean verifyadpost=tinycrossbutton.isEnabled();
   	 return verifyadpost;
   	 
	}
	
	public void clickonPostAd()
	{
		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
	}
	
	public void loginUnderPostAdd() throws InterruptedException
	{
		loginemail.sendKeys("kunal.kashyap@saffrontech.net");
   	 util.myWait(2000);
   	 loginpassword.sendKeys("Kunal@123");
   	 util.myWait(2000);
   	 
   	 WebElement loginsubmit=driver.findElement(By.xpath("//input[@id='login']"));
   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginsubmit);
	}
	
	public boolean verifyPostFreeAdPage()
	{

		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
	   	 String headingtext=driver.findElement(By.xpath("//h3[text()=' Post Your Free Ads ']")).getText();
	   	 if(headingtext.contains("Free Ads"))
	   	 {
	   		 return true;
	   		 }
	   	 else {
	   		 return false;
	   	 }
	}
	
	public boolean countCategoryonPostAddPage()
	{
		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
	   	 Select select=new Select(driver.findElement(By.xpath("//select[@id='category_id']")));
	   	 List<WebElement> menulist= select.getOptions();
	   	int categorycount= menulist.size();
	   	if(categorycount==15)
	   	{
	   		return true;
	   	}
	   	else {
	   		return false;
	   	}
	   	 
	}
	
	public void fillUploadImage() throws InterruptedException
	{
		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
	   	 categories.click();
	   	 util.selectValueFromDropdown(categories, 1);
	   	 util.myWait(10000);
	   	// subcategories.click();
	   	 //util.selectValueFromDropdown(subcategories, 0);
	   	// util.myWait(10000);
	   	 title.sendKeys("Upload Image test");
	   	 description.sendKeys("My First Image.");
	   	 util.myWait(10000);
	   	JavascriptExecutor js = (JavascriptExecutor) driver;
	   	js.executeScript("window.scrollBy(0,1000)");
	   	 //country.click();
	   	 //util.selectValueFromDropdown(country, 0);
	   	 util.myWait(10000);
	   	 city.sendKeys("Fremont");
	   	 util.myWait(3000);
	   	 WebElement image=driver.findElement(By.xpath("//input[@id='files']"));
	   	 image.sendKeys("/home/day/Desktop/banner3.jpg");
	   	 WebElement Createad=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn']"));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Createad);
	}
	
	public boolean verifyUploadImage()
	{
		String successmessage=driver.findElement(By.xpath("//div[@class='alert alert-success alert-custom']")).getText();
		if(successmessage.contains("Successfully"))
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void deleteAd() throws InterruptedException
	{
		loginfunctionality();
		userImage.click();
		Thread.sleep(3000);
		currentAds.click();
		Thread.sleep(3000);
		deleteAdtinybutton.click();
		Thread.sleep(3000);
		deleteYesButton.click();
	
	}
	
	public boolean verifyDeleteAd()
	{
		if(deletesuccesstinybutton.isEnabled())
		{
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	public boolean postAddButtonClickability() {
		if(addpostbutton.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean requiredFieldVerification() throws InterruptedException {
		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
	   	 Thread.sleep(3000);
		String category=driver.findElement(By.xpath("//label[text()='Category']")).getText();
		String subCategory=driver.findElement(By.xpath("//label[text()='Sub-category']")).getText();
		String title=driver.findElement(By.xpath("//label[text()='Title']")).getText();
		String description=driver.findElement(By.xpath("//label[text()='Description']")).getText();
		String country=driver.findElement(By.xpath("//label[text()='Country']")).getText();
		String city=driver.findElement(By.xpath("//label[text()='City']")).getText();
		String status=driver.findElement(By.xpath("//label[text()='Status']")).getText();
		
		if(category.contains("Category")&&subCategory.contains("-category")&&title.contains("Title")&&description.contains("Description")&&country.contains("Country")&&city.contains("City")&&status.contains("Status")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean requiredFieldValidation() throws InterruptedException {
		
		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
	   	 Thread.sleep(3000);
	        util.scrollPage();
	   	 WebElement Createad=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn']"));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Createad);
		 String  titlevalidation=driver.findElement(By.xpath("//p[text()='Title field is required.']")).getText();
		 title.sendKeys("My First Title");
	   	 Thread.sleep(3000);
	        util.scrollPage();
	        WebElement Createad1=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn']"));
			 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Createad1);
	   	 String categoryValidation=driver.findElement(By.xpath("//p[text()='Category field is required.']")).getText();
	   	 categories.click();
	   	 util.selectValueFromDropdown(categories, 1);
	   	 util.myWait(10000);
	        util.scrollPage();

	        WebElement Createad11=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn']"));
			 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Createad11);
	   	 Thread.sleep(3000);
	   	 String descriptionValidation=driver.findElement(By.xpath("//p[text()='Description field is required.']")).getText();
	   	 description.sendKeys("My First Description");
	        util.scrollPage();

	        WebElement Createad111=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn']"));
			 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Createad111);
	   	 Thread.sleep(3000);
	   	 String cityValidation=driver.findElement(By.xpath("//p[text()='City field is required.']")).getText();
	   	 city.sendKeys("Fremont");
	   	 if(titlevalidation.contains("Title field")&&categoryValidation.contains("Category")&&descriptionValidation.contains("Description")&&cityValidation.contains("City")) {
	   		 return true;
	   	 }
	   	 else {
	   		 return false;
	   	 }
	   	 
	   	 
	   }
	
	public int  countSubcategory() throws InterruptedException {
		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
	   	 Thread.sleep(10000);
	   	categories.click();
	   	 util.selectValueFromDropdown(categories, 1);
	   	 
	   	 Thread.sleep(10000);
	   	 subcategories.click();
		Select select= new Select(subcategories);
		List<WebElement> list=select.getOptions();
		int size=list.size();
		return size;
	}
	
	public boolean tabFunctionalityOfPostAdForm() throws InterruptedException {
		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
	   	 Thread.sleep(10000);
	   	 categories.click();
	   	 util.selectValueFromDropdown(categories, 1);
		categories.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		subcategories.sendKeys(Keys.TAB);
		Thread.sleep(3000);

		title.sendKeys(Keys.TAB);
		Thread.sleep(3000);

		description.sendKeys(Keys.TAB);
		Thread.sleep(5000);

		price.sendKeys(Keys.TAB);
		Thread.sleep(3000);

		country.sendKeys(Keys.TAB);
		Thread.sleep(3000);

		state.sendKeys(Keys.TAB);
		
		city.sendKeys(Keys.TAB);
		Thread.sleep(3000);

		zip.sendKeys(Keys.TAB);
		Thread.sleep(3000);

		address.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		
		status.sendKeys(Keys.TAB);
		Thread.sleep(3000);

		cretaeAd.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		String title=driver.findElement(By.xpath("//p[text()='Title field is required.']")).getText();
		if(title.contains("Title")) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	
	

}
