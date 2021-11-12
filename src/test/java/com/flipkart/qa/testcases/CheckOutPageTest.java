package com.flipkart.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
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


public class CheckOutPageTest extends TestBase
{

	LoginPage loginPage;
	HomePage homePage;
	ItemPage ItemPage;
	TestUtil TestUtil;
	ProductdisplayPage ProductdisplayPage;
	CheckOutPage CheckOutPage;
	
	public CheckOutPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException 
	{
		initialisation();
		ItemPage=new ItemPage();
		loginPage= new LoginPage();
		TestUtil =new TestUtil();
		//homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage=loginPage.login();
		ItemPage=homePage.Searchproduct();
		ProductdisplayPage=ItemPage.ClickItem();
		CheckOutPage=ProductdisplayPage.placeorder();
	}
	
	@Test(priority=1)
	public void checkout() throws IOException, InterruptedException {
		String message = (String) CheckOutPage.checkout();
		Assert.assertEquals(message,"Not a valid card");
	}
	@AfterMethod
	public void close()
	{
	 driver.quit();
	}
	
}

