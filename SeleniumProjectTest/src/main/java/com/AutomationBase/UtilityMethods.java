package com.AutomationBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UtilityMethods {
	private WebDriver driver;
	
	public WebDriver intializeWebDriver(String browser) {
		setDriver(new ChromeDriver());
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	

}
