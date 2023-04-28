package playwright.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Attachment;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SamplePlaywrightTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @AfterMethod
    public void tearDown() {
        attachScreenshot();
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void testSearch() {
        page.navigate("https://www.google.com/");
        page.fill("#searchform input[name='q']", "Playwright");
        page.press("#searchform input[name='q']", "Enter");
        assertEquals(page.title(), "Playwright - Google Search");
    }

    @Test
    public void testLogin() {
        page.navigate("https://www.example.com/login");
        page.fill("#username", "myusername");
        page.fill("#password", "mypassword");
        page.click("#login-button");
        assertTrue(page.url().contains("/dashboard"));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
        return screenshotBytes;
    }
}
