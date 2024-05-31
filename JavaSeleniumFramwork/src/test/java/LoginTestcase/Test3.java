package LoginTestcase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPageObjects.Page1;

public class Test3{
	
	private static WebDriver driver = null;
	private static ChromeOptions ops =null;
	
	@BeforeClass
	public void intializePageFactory() {
		try {
			PageFactory.initElements(driver, Class.forName("LoginPageObjects.Page1"));	
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Page objects intialization failed: "+e.getMessage());
		}
	}
	
	@BeforeTest
	public void tearUp() throws MalformedURLException {
		ops = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444"),ops);
		driver.get("https://www.makemytrip.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test(priority = 0)
	public void Homepage() throws InterruptedException {
		assertEquals(Page1.Buses.getText(), "Buses");
		Page1.Buses.click();
		Thread.sleep(2000);
		
	}
	@Test(priority = 1)
	public void flightSCheck() throws InterruptedException, IOException {
		Page1.Flights.click();
		Thread.sleep(3000);
		Page1.roundTrip.click();
		Thread.sleep(1000);
		screenSot();
		System.out.println(Page1.oneWayTrip.isSelected());
		System.out.println(Page1.RoundTripSeelcted.isSelected());
		Thread.sleep(4000);
		
		Page1.oneWayTrip.click();
		screenSot();
		Page1.fromCity.click();
		Page1.inputfiledfrom.sendKeys("LKO");
		screenSot();
		Page1.fromLocation.click();
		Thread.sleep(3000);
		screenSot();
		Page1.toCity.click();
		Page1.inputfiledTo.sendKeys("blr");
		screenSot();
		Page1.BengaloreCity.click();
		Thread.sleep(2000);
		screenSot();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public static void screenSot() throws IOException {
          //if(driver instanceof FirefoxDriver) {
			
			//Full Page
			//File fullPage = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(fullPage, new File("./screenshot/"+randonNumbervalue()+".jpg"));
			
			
		//}else if(driver instanceof ChromeDriver) {
			
		//	
		File pageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(pageScreenshot, new File("./screenshot/"+randonNumbervalue()+".jpg"));
			
			
		//}
	}
	public static String randonNumbervalue() {
	String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";

    // combine all strings
    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

    // create random string builder
    StringBuilder sb = new StringBuilder();

    // create an object of Random class
    Random random = new Random();

    // specify length of random string
    int length = 10;

    for(int i = 0; i < length; i++) {

      // generate random index number
      int index = random.nextInt(alphaNumeric.length());

      // get character specified by index
      // from the string
      char randomChar = alphaNumeric.charAt(index);

      // append the character to string builder
      sb.append(randomChar);
    }

    return sb.toString();
	}

}
