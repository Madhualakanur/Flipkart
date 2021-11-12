package com.flipkart.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.ItemPage;
import com.flipkart.qa.pages.ProductdisplayPage;
import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.CheckOutPage;
import com.flipkart.qa.util.TestUtil;


public class ProductDisplayPageTest extends TestBase
{

	LoginPage loginPage;
	HomePage homePage;
	ItemPage ItemPage;
	ProductdisplayPage ProductdisplayPage;
	CheckOutPage CheckOutPage;
	TestUtil TestUtil;
	public ProductDisplayPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException 
	{
		initialisation();
		ItemPage=new ItemPage();
		loginPage= new LoginPage();
		TestUtil = new TestUtil();
		//homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage=loginPage.login();
		ItemPage=homePage.Searchproduct();
		ProductdisplayPage=ItemPage.ClickItem();
	}


	@Test(priority=3)

	public void placeorder() throws IOException, InterruptedException {
		CheckOutPage=ProductdisplayPage.placeorder();
	}
	@AfterMethod
	public void close()
	{
	 driver.quit();
	}
	
}

