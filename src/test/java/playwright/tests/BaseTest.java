package playwright.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Attachment;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PlaywrightObjectsHolder;

public class BaseTest {
    public Playwright playwright;
    public Browser browser;
    public Page page;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        PlaywrightObjectsHolder.setPlaywright(playwright);
        browser = PlaywrightObjectsHolder.getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        PlaywrightObjectsHolder.setBrowser(browser);
        page = PlaywrightObjectsHolder.getBrowser().newPage();
        PlaywrightObjectsHolder.setPage(page);
    }

    @AfterMethod
    public void tearDown() {
        attachScreenshot();
        PlaywrightObjectsHolder.getPage().close();
        PlaywrightObjectsHolder.getBrowser().close();
        PlaywrightObjectsHolder.getPlaywright().close();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        byte[] screenshotBytes = PlaywrightObjectsHolder.getPage().screenshot(new Page.ScreenshotOptions().setFullPage(true));
        return screenshotBytes;
    }
}
