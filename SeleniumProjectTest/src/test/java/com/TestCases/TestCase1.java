package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AutomationBase.UtilityMethods;
import com.PageObjects.Page1;

public class TestCase1 extends UtilityMethods {
	String chrome;
	private WebDriver driver;
	
	
	@BeforeTest
	public void tearUp() {
		intializeWebDriver(chrome);
	}
	
	@Test(priority = 0)
	public void test1() {
		System.out.println("Driver initiated successfully");
		driver = getDriver();
		System.out.println(driver.getTitle());
	}
	@Test(priority = 1)
	public void test2() {
		Page1 page= new Page1(driver);
		page.dashboardManuItems();
	}
	
	@AfterTest
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
