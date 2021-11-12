package com.flipkart.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil TestUtil;

	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup() throws IOException
	{
		initialisation();
		loginPage = new LoginPage();
		TestUtil = new TestUtil();
	}
	@Test 

	public void LoginPageTitletest()
	{
		String title = loginPage.vaidateLoginPageTitle();
		Assert.assertEquals(title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test
	public void LoginPageLogo()
	{
		boolean flag =loginPage.validateImage();
		Assert.assertTrue(flag);
	}

	@Test
	public void LoginTest() throws InterruptedException, IOException
	{
		homePage=loginPage.login();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

