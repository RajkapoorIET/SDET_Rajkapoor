package testCases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestCase2 {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setDevtools(true));
		      Page page = browser.newPage();
		      page.navigate("https://awspreprodqa.container.webmcloud.com");
		      
		      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		    }
	}
	 

}
