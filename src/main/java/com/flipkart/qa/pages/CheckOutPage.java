package com.flipkart.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;


public class CheckOutPage extends TestBase {

	
	@FindBy(xpath="//button[text()='Deliver Here']")
	WebElement deliverherebtn;
	
	@FindBy(xpath="//button[text()='CONTINUE']")
	WebElement continuebtn;
	
	@FindBy(xpath="//span[text()='Credit / Debit / ATM Card']")
	WebElement newcardbtn;
	
	@FindBy(xpath="//input[@name='cardNumber']")
	WebElement cardnumber;
	
	@FindBy(xpath="//span[text()='Not a valid card number']")
	WebElement notvalidcarderrormessage;
	

	public CheckOutPage() throws IOException
	{
		PageFactory.initElements(driver,this);		
	}
	
	public String checkout() throws IOException, InterruptedException
	{
	String errorMessage ="no message";
	//Map<String, String> map = TestUtil.getFlipkartTestData();
	deliverherebtn.click();
	continuebtn.click();
	newcardbtn.click();
	Thread.sleep(1000);
	//cardnumber.sendKeys(map.get("Card_Number"));
	cardnumber.sendKeys("0000000000");
	Thread.sleep(1000);
	if(notvalidcarderrormessage.isDisplayed())
	{
		errorMessage = notvalidcarderrormessage.getText();
	}
	return errorMessage;
	}


	
	
}
