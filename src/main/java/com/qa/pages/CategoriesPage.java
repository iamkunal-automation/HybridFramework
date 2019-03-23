package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;
import com.qa.utility.Utils;

public class CategoriesPage extends TestBase{
	LoginPage login=new LoginPage();
	Utils util=new Utils();

	//categories and their sub categories locators
	
	@FindBy(xpath="//div[@class='mobile_menu']//a[text()=' Categories ']")
	WebElement categoriesbutton;
	
	@FindBy(xpath="//span[text()='Art / Books / Collectables / Music']")
	WebElement ArtBooksCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Art / Books / Collectables / Music']//li")
	WebElement ArtBooksSubCat;
	
	@FindBy(xpath="//span[text()='Automotive']")
	WebElement automotiveCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Automotive']//li")
	WebElement automotiveSubCat;
	
	@FindBy(xpath="//span[text()='Boats & Jet Skis']")
	WebElement boatsAndJetCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Boats & Jet Skis']//li")
	WebElement boatsAndJetSubCat;
	
	@FindBy(xpath="//span[text()='Clothes & Jewelry']")
	WebElement clothsAndJewelCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Clothes & Jewelry']//li")
	WebElement clothsAndJewelSubCat;
	
	@FindBy(xpath="//span[text()='Community']")
	WebElement communityCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Community']//li")
	WebElement communitySubCat;
	
	@FindBy(xpath="//span[text()='Consumer Electronics']")
	WebElement consumerElectronicsCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Consumer Electronics']//li")
	WebElement consumerElectronicsSubCat;
	
	@FindBy(xpath="//span[text()='Discussion Forums']")
	WebElement discussionForumsCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Discussion Forums']//li")
	WebElement discussionForumsSubCat;
	
	@FindBy(xpath="//span[text()='Jobs']")
	WebElement jobsCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Jobs']//li")
	WebElement jobsSubCat;
	
	@FindBy(xpath="//span[text()='Local Places']")
	WebElement LocalPlacesCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Local Places']//li")
	WebElement LocalPlacesSubCat;
	
	
	@FindBy(xpath="//span[text()='Others']")
	WebElement OthersCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Others']//li")
	WebElement OthersSubCat;
	
	
	@FindBy(xpath="//span[text()='Pets']")
	WebElement PetsCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Pets']//li")
	WebElement PetsSubCat;
	
	
	@FindBy(xpath="//span[text()='Real Estate']")
	WebElement RealEstateCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Real Estate']//li")
	WebElement RealEstateSubCat;
	
	
	@FindBy(xpath="//span[text()='Resumes']")
	WebElement ResumesCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Resumes']//li")
	WebElement ResumesSubCat;
	
	@FindBy(xpath="//span[text()='Services']")
	WebElement ServicesCat;
	@FindBy(xpath="//div[@class='sub_categories' and @id='Services']//li")
	WebElement ServicesSubCat;
	
	public CategoriesPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean categoriesMenuClickability() {
		if(categoriesbutton.isEnabled()) {
			return true;
		}
		else {
			 return false;
		}
	}
	public int countCategoryList()
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
   	  List<WebElement> categories=driver.findElements(By.xpath("//div[@class='cat_list']"));
   	 int size= categories.size();
   	  return size;
   	  
	}
	public void countSubCategoryOfArtBooks() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		ArtBooksCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Art / Books / Collectables / Music']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=7;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
		
	}
	
	public void countSubCategoryOfAutomotive() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		automotiveCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Automotive']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=9;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	public void countSubCategoryOfBoatsAndSkis() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		boatsAndJetCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Boats & Jet Skis']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=6;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	public void countSubCategoryOfClothsAndJewel() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		clothsAndJewelCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Clothes & Jewelry']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=9;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	public void countSubCategoryOfCommunity() throws InterruptedException
	{WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
  	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		communityCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Community']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=18;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	public void countSubCategoryOfConsumerElectronics() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		consumerElectronicsCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Consumer Electronics']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=8;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	public void countSubCategoryOfDiscussionForums() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		util.scrollPage();
		discussionForumsCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Discussion Forums']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=53;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	
	public void countSubCategoryOfJobs() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		util.scrollPage();

		jobsCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Jobs']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=40;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	public void countSubCategoryOfLocalPlaces() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		util.scrollPage();

		LocalPlacesCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Local Places']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=4;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	public void countSubCategoryOfOthers() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		util.scrollPage();

		OthersCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Others']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=14;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	
	public void countSubCategoryOfPets() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		util.scrollPage();

		PetsCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Pets']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=8;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	public void countSubCategoryOfRealEstate() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		util.scrollPage();

		RealEstateCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Real Estate']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=12;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	public void countSubCategoryOfResume() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		util.scrollPage();

		ResumesCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Resumes']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=1;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	
	public void countSubCategoryOfServices() throws InterruptedException
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		util.scrollPage();

		ServicesCat.click();
		Thread.sleep(5000);

		List<WebElement> subcategoriesList=driver.findElements(By.xpath("//div[@class='sub_categories' and @id='Services']//li"));
		int actualSize=subcategoriesList.size();
		int expectedSize=31;
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Sub categories list matched as per requirement");
	
	}
	public String verifyCategoryPageTitle() throws InterruptedException {
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
		Thread.sleep(5000);
		String title=driver.getTitle();
		return title;
	}
}
