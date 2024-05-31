package testCases;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Example3 {
	
	@Test
	public void test1() throws InterruptedException {
	try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://www.globalsqa.com/demo-site/datepicker/");
	      page.locator("//li[@id='DropDown DatePicker']").click();
	      page.frameLocator("iframe >> nth=1").locator("#datepicker").click();
	      page.frameLocator("iframe >> nth=1").locator("//select[@class='ui-datepicker-month']").click();
	      page.frameLocator("iframe >> nth=1").locator("//option[@value='6']").click();
	      page.frameLocator("iframe >> nth=1").locator("//option[@value='2014']").click();
	      page.frameLocator("iframe >> nth=1").locator("//a[normalize-space()='22']").click();
		  Thread.sleep(5000);
	      
	}
	}
}
