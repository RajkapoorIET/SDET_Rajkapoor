package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page1 {
	private WebDriver driver;
	private By job = By.xpath("//div[normalize-space()='Jobs']");
	private By companies = By.xpath("//div[normalize-space()='Companies']");
	private By services = By.xpath("//div[normalize-space()='Services']");
	
	public Page1(WebDriver driver) {
		this.driver= driver;
	}
	
	public void dashboardManuItems() {
		driver.findElement(job).getText();
		driver.findElement(companies).getText();
		driver.findElement(services).getText();
	}
	char c ='A';
	

}
