package com.flipkart.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class ItemPage extends TestBase {
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addtocart;
	
	public ItemPage() throws IOException
	{
		PageFactory.initElements(driver,this);		
	}
	
	public String verifyItemPageTitle()
	{
		return driver.getTitle();
	}
	
	public ProductdisplayPage ClickItem() throws IOException, InterruptedException {
		addtocart.click();
		Thread.sleep(2000);
		return new ProductdisplayPage();
		
	}
}
