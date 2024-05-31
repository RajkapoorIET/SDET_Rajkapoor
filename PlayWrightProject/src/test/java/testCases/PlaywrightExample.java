package testCases;

import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightExample {

	@Test
	public void test1() {
		// TODO Auto-generated method stub
		try (Playwright playwright = Playwright.create()) {
			
           // Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");

            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));

            // create a locator
            Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));

            // Expect an attribute "to be strictly equal" to the value.
            assertThat(getStarted).hasAttribute("href", "/docs/intro");
            System.out.println("sssssssssssssssssssssss********************sssssssssssssssss");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get started")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Generating tests")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("How to record a test")).click();
            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Record at CursorDirect link")).click();
            // Click the get started link.
          //  getStarted.click();
            page.navigate("https://www.google.com/");
            page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
            page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("make");
            page.getByText("Make My Trip").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Use precise location")).click();
           // page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Not now")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("MakeMyTrip - #1 Travel")).click();
            page.getByLabel("FromDEL, Delhi Airport India").click();
            page.getByPlaceholder("From").fill("lko");
            page.getByText("Lucknow", new Page.GetByTextOptions().setExact(true)).click();
            page.getByText("17", new Page.GetByTextOptions().setExact(true)).click();
            page.getByLabel("Fri Apr 26").getByText("26").click();
            page.getByText("Search").click();
            assertThat(page.getByRole(AriaRole.NAVIGATION)).containsText("Hotels");
            assertThat(page.getByRole(AriaRole.NAVIGATION)).containsText("Holiday Packages");
            // Expects page to have a heading with the name of Installation.
            //assertThat(page.getByRole(AriaRole.HEADING,
           //    new Page.GetByRoleOptions().setName("Installation"))).isVisible();
        }
	}

}
