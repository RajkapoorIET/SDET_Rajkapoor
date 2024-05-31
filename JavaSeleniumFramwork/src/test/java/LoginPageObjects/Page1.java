package LoginPageObjects;

import javax.security.auth.x500.X500Principal;
import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Page1 {
	

	@FindBy(xpath = "//img[@alt='Make My Trip']")
	public static WebElement HomePagelogo;
	
	@FindBy(xpath = "//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Flights']")
	public static WebElement Flights;
	
	@FindBy(xpath = "//iframe[@id='webklipper-publisher-widget-container-notification-frame']")
	public static WebElement iframe;
	
	@FindBy(xpath = "//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Hotels']")
	public static WebElement Hotels;
	
	@FindBy(xpath = "//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Homestays & Villas']")
	public static WebElement HomestaysANdVillas;
	
	@FindBy(xpath = "//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Holiday Packages']")
	public static WebElement HolidayPackages;
	
	@FindBy(xpath = "//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Trains']")
	public static WebElement Trains;
	
	@FindBy(xpath = "//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Buses']")
	public static WebElement Buses;
	
	@FindBy(xpath = "//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Cabs']")
	public static WebElement Cabs;
	
	@FindBy(xpath = "//li[@data-cy='oneWayTrip']")
	public static WebElement oneWayTrip;
	
	@FindBy(xpath = "//li[@data-cy='roundTrip']")
	public static WebElement roundTrip;
	
	@FindBy(xpath = "//li[@data-cy='mulitiCityTrip']")
	public static WebElement mulitiCityTrip;
	
	@FindBy(xpath = "//li[@class='selected']")
	public static WebElement RoundTripSeelcted;
	
	@FindBy(xpath = "//input[@id='fromCity']")
    public static WebElement fromCity;
	
	@FindBy(xpath = "//p[normalize-space()='Lucknow, India']")
	public static WebElement fromLocation;
	@FindBy(xpath = "//input[@placeholder='From']")
	public static WebElement inputfiledfrom;
	
	@FindBy(xpath = "//input[@placeholder='To']")
	public static WebElement inputfiledTo;
	@FindBy(xpath = "//p[normalize-space()='Bengaluru, India']")
	public static WebElement BengaloreCity;
	
	@FindBy(xpath = "//input[@id='toCity']")
	public static WebElement toCity;
	
	
	
	
	
	
	
	
	
	

}
