package playwright.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Attachment;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public Playwright playwright;
    public Browser browser;
    public Page page;

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

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
        return screenshotBytes;
    }
}
