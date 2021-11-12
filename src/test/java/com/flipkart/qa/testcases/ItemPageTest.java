
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
import com.flipkart.qa.pages.ProductdisplayPage;
import com.flipkart.qa.util.TestUtil;

public class ItemPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ItemPage ItemPage;
	ProductdisplayPage ProductdisplayPage;
	TestUtil TestUtil;
	public ItemPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



	@BeforeMethod
	public void setup() throws IOException, InterruptedException 
	{
		initialisation();
		TestUtil =new TestUtil();
		ItemPage=new ItemPage();
		loginPage= new LoginPage();
		//homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage=loginPage.login();
		ItemPage=homePage.Searchproduct();
	}


	@Test(priority=1)
	public void ItemPageTitleTest1() {
		String title = ItemPage.verifyItemPageTitle();
		Assert.assertEquals(title,"POCO M3 ( 64 GB Storage, 6 GB RAM ) Online at Best Price On Flipkart.com");
	}


	@Test(priority=2)

	public void ItemPage() throws IOException, InterruptedException {
		ProductdisplayPage=ItemPage.ClickItem();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}

