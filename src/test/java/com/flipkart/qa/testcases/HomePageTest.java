package com.flipkart.qa.testcases;
import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.ItemPage;
import com.flipkart.qa.util.TestUtil;



public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ItemPage ItemPage;
	TestUtil TestUtil;
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialisation();
		TestUtil = new TestUtil();
		loginPage= new LoginPage();
		//homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage=loginPage.login();
	}

	@Test(priority=1)
	public void homePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}

	@Test(priority=2)
	public void verifyUserNameTest()
	{
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}	

	/*@Test(priority=3)

	public void search() throws IOException, InterruptedException 
	{
		ItemPage.search();
		Thread.sleep(2000);
	}*/
	
	@Test(priority=3)

	public void searchproductandSelect() throws IOException, InterruptedException
	{
		ItemPage=homePage.Searchproduct();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}

