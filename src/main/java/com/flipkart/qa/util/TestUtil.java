package com.flipkart.qa.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import java.util.HashMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;

import com.flipkart.qa.base.TestBase;

public class TestUtil extends TestBase{

	public TestUtil()
	{
		super();
	}
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=30;
	
	public static XSSFWorkbook workbook = null;
	public static Sheet sheet = null;
	public static Row row = null;
	public static Map<String, String> map = null;
	
	public static void switchToNewTab()
	{
	String currentwindow = driver.getWindowHandle();
	Set<String> allwindows = driver.getWindowHandles();
	 Iterator<String> i = allwindows.iterator();
     while(i.hasNext()) 
     {
    	 String childwindow = i.next();
    	 if (!childwindow.equalsIgnoreCase(currentwindow))
    	 {
    		 driver.switchTo().window(childwindow);
    		 System.out.println("The child window is " +childwindow);
    	 } 
    	 else
    	 {
System.out.println("There are no children");
    	 }
    	 }
}

public static Map<String, String> getFlipkartTestData() throws IOException{
try {
	FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Mallikarjun\\eclipse-workspace\\LearnPOM\\src\\main\\java\\com\\flipkart\\qa\\testdata\\FlipkartTestData.xlsx");
	workbook = new XSSFWorkbook(fileInputStream);
	sheet = workbook.getSheetAt(0);
	row = sheet.getRow(0);
	int colCount = row.getLastCellNum() ;
	
	map=new HashMap<String, String>();
	
	for (int i=0;i<colCount;i++)
	{
		
		map.put(sheet.getRow(0).getCell(i).toString().trim(),sheet.getRow(1).getCell(i).toString().trim());
	}
}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	return map;
}

public static void explicitWaitUntilElementClickable(WebElement element)
{
		System.out.println("inside wait");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
}
}