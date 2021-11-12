package com.flipkart.qa.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.util.TestUtil;

public class LoginPage extends TestBase
{

	@FindBy(xpath="//*[@class='_2IX_2- VJZDxU']")
	WebElement username;

	@FindBy(xpath ="//*[@class='_2IX_2- _3mctLh VJZDxU']")
	WebElement password;

	@FindBy(xpath ="//*[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement loginbtn;
	
	@FindBy(xpath ="//*[@class='_3wJI0x']")
	WebElement SignUpBtn;
	
	@FindBy(xpath = "//img[@title='Flipkart']")
	WebElement flipkartLogo;

	
public LoginPage()
{
	PageFactory.initElements(driver,this);
}

public String vaidateLoginPageTitle()
{
	return driver.getTitle();
}
public boolean validateImage()
{
	return flipkartLogo.isDisplayed();
}

public HomePage login() throws InterruptedException, IOException
{
	Map<String, String> map = TestUtil.getFlipkartTestData();
	username.sendKeys("9164046599");
	//username.sendKeys(map.get("9164046599"));
	password.sendKeys(map.get("password"));
	loginbtn.click();
	Thread.sleep(2000);
	return new HomePage();
}
}