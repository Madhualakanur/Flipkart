package com.flipkart.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class ProductdisplayPage extends TestBase {
	
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	WebElement placeorder;

	public ProductdisplayPage() throws IOException
	{
		PageFactory.initElements(driver,this);		
	}
	
	public CheckOutPage placeorder() throws IOException
	{
		placeorder.click();
		return new CheckOutPage();
	}

	
	
}
