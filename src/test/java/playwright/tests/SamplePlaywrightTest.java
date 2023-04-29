package playwright.tests;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import utils.PlaywrightObjectsHolder;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SamplePlaywrightTest extends BaseTest {


    @Test
    public void testSearch() {
        Page page = PlaywrightObjectsHolder.getPage();
        page.navigate("https://www.google.com/");
        page.fill("#searchform input[name='q']", "Playwright");
        page.press("#searchform input[name='q']", "Enter");
        assertEquals(page.title(), "Playwright - Google Search");
    }

    @Test
    public void testLogin() {
        Page page = PlaywrightObjectsHolder.getPage();
        page.navigate("https://www.example.com/login");
        page.fill("#username", "myusername");
        page.fill("#password", "mypassword");
        page.click("#login-button");
        assertTrue(page.url().contains("/dashboard"));
    }


}
