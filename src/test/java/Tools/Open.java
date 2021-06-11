package Tools;

import Pages.HomePage;

public class Open {
    public static Browser browser;

    public Open (Browser browserObj) {
        this.browser = browserObj;
    }

    public static HomePage openHomePage() {
        browser.goTo("https://aionis.io/");
        return new HomePage(browser);
    }
}
