package playwright.tests;

import com.microsoft.playwright.Page;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.InputPage;
import utils.JsonDataReader;
import utils.PlaywrightObjectsHolder;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InputBoxTest extends BaseTest {


    @Test
    @Description("This test shows how to write directly using playwright native methods in test class")
    public void testSearch() {
        Page page = PlaywrightObjectsHolder.getPage();
        page.navigate("https://www.google.com/");
        page.fill("#searchform input[name='q']", "Playwright");
        page.press("#searchform input[name='q']", "Enter");
        assertEquals(page.title(), "Playwright - Google Search");
    }

    @Test
    @Description("This test shows how to write directly using playwright native methods in test class")
    public void testLogin() {
        Page page = PlaywrightObjectsHolder.getPage();
        page.navigate("https://www.example.com/login");
        page.fill("#username", "myusername");
        page.fill("#password", "mypassword");
        page.click("#login-button");
        assertTrue(page.url().contains("/dashboard"));
    }


    @Test
    @Description("This test uses Page Object model implementation in this Framework")
    public void testInput() {
        Page page = PlaywrightObjectsHolder.getPage();
        page.navigate(JsonDataReader.readJson("test-data/InputBoxTestData.json", "url"));
        inputPage = new InputPage(page);
        inputPage.VerifyInputBox("Sandeep");
    }


}
