package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class InputPage {

    private final Page page;
    private final Locator searchTermInput;

    public InputPage(Page page) {
        this.page = page;
        this.searchTermInput = page.locator("//input[@id='userId']");
    }

    public void VerifyInputBox(String text) {
        searchTermInput.fill(text);
        Assert.assertEquals(searchTermInput.innerText().contains(text), true);
    }

}
