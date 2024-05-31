package testCases;

import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class Example2 {
	
	
	@Test
	public void tearUp() throws InterruptedException {
		
		try (Playwright pw =Playwright.create()){
			Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			/*page.navigate("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
			page.getByRole(AriaRole.COMBOBOX).selectOption("IND");
		    page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Select country from below drop down list:$"))).locator("a").click();
		*/
			page.navigate("https://devrealm1.dev-int-aws-us.webmethods.io");
			page.waitForLoadState();
			page.locator("//input[@id='username']").fill("wmccpromotion");
			page.locator("//input[@id='password']").fill("C!0udC0nt@!nerQ@2o24");
			page.locator("//input[@id='kc-login']").click();
			//Thread.sleep(10000);
			//assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello WMCC"))).isVisible();
			assertThat(page.getByText("Hello WMCC")).isVisible();
			//page.getByTestId("username").click();
			//Thread.sleep(20000);
			
			
		
		}
		
		
	}
	

}
