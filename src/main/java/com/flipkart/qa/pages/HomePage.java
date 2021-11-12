package com.flipkart.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath="//div[contains(text(),'madhu')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//div[contains(text(),'Top Offers')]")
	WebElement TopOffers;
	
	@FindBy(xpath="//div[contains(text(),'Grocery')]")
	WebElement Grocery;
	
	@FindBy(xpath="	//input[@title='Search for products, brands and more']\r\n"
			+ "")
	WebElement Searchbar;
	
	@FindBy(xpath="//div[contains(text(),'POCO M3 (Cool Blue, 64 GB)')]")
	WebElement select;
	
	public HomePage() throws IOException
	{
		PageFactory.initElements(driver,this);
		
	}
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ItemPage Searchproduct () throws IOException
	{
		Searchbar.sendKeys("mobiles"+"\n");
		select.click();
		TestUtil.switchToNewTab();
		return new ItemPage();
	}
	
	
}
