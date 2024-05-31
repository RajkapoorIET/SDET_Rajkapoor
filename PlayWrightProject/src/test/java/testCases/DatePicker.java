package testCases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DatePicker {
	
	public static void main(String[] args) throws InterruptedException {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://www.globalsqa.com/demo-site/datepicker/");
	     // page.frameLocator("iframe >> nth=0").locator("#datepicker").click();
	      
	     // datePickerinFuture(page);
	      //page.frameLocator("iframe >> nth=0").locator("#datepicker").clear();
	      page.frameLocator("iframe >> nth=0").locator("#datepicker").click();
	      datePickerinpast(page);
	      
	    }
	    
	}
	public static void datePickerinFuture(Page page) throws InterruptedException {
	      for(int i=0;i<20;i++) {
	    	  if(page.frameLocator("iframe >> nth=0").getByText("November 2024").isVisible()){
	    		  Thread.sleep(5000);
	    		  break;
	    	  }
	    	  else {
	    		  page.frameLocator("iframe >> nth=0").locator("//span[@class='ui-icon ui-icon-circle-triangle-e']").click();
	    	  }
	      }
	    		  page.frameLocator("iframe >> nth=0").locator("//a[normalize-space()='22']").click();
	    		  Thread.sleep(5000);
	}
	
	public static void datePickerinpast(Page page) throws InterruptedException {
	      for(int i=0;i<20;i++) {
	    	  if(page.frameLocator("iframe >> nth=0").getByText("November 2022").isVisible()){
	    		  Thread.sleep(5000);
	    		  break;
	    	  }
	    	  else {
	    		  page.frameLocator("iframe >> nth=0").locator("//span[@class='ui-icon ui-icon-circle-triangle-w']").click();
	    	  }
	      }
	    		  page.frameLocator("iframe >> nth=0").locator("//a[normalize-space()='4']").click();
	    		  Thread.sleep(5000);
	}
	
}

