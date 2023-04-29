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
        utils.PageHolder.setPlaywright(playwright);
        browser = utils.PageHolder.getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        utils.PageHolder.setBrowser(browser);
        page = utils.PageHolder.getBrowser().newPage();
        utils.PageHolder.setPage(page);
    }

    @AfterMethod
    public void tearDown() {
        attachScreenshot();
        utils.PageHolder.getPage().close();
        utils.PageHolder.getBrowser().close();
        utils.PageHolder.getPlaywright().close();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        byte[] screenshotBytes = utils.PageHolder.getPage().screenshot(new Page.ScreenshotOptions().setFullPage(true));
        return screenshotBytes;
    }
}
