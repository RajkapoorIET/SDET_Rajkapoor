package LoginTestcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase2 {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void initializePageFactory() {
		//String pageclass = "LoginPageObjects.Page1";
		try {
			Object t = Class.forName("LoginPageObjects.Page1").newInstance();
			PageFactory.initElements(driver, t);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Page objects intialization failed: "+e.getMessage());
		}
	}
	
	@BeforeTest
	public void tearUp() {
		driver =  new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	@Test
	public void loginAsBankManager() {
		driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).isDisplayed();
		driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//label[normalize-space()='Your Name :']")).isDisplayed();
		driver.findElement(By.xpath("//select[@id='userSelect']")).click();
		
	}
	
	//@AfterTest
	public void teatDown() {
		driver.close();
		driver.quit();
	}
}
