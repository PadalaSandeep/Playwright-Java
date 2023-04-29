package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageHolder {

    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    public static Page getPage() {
        return page.get();
    }

    public static void setPage(Page pageObj) {
        PageHolder.page.set(pageObj);
    }

    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return playwright.get();
    }

    public static void setPlaywright(Playwright playwrightObj) {
        PageHolder.playwright.set(playwrightObj);
    }

    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();

    public static Browser getBrowser() {
        return browser.get();
    }

    public static void setBrowser(Browser browserObj) {
        PageHolder.browser.set(browserObj);
    }


}

