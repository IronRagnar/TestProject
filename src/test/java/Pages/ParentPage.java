package Pages;

import Tools.Browser;
import Tools.Element;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;

public class ParentPage {

    public Browser browser;

    public void setText (Element element, String text) {
        browser.browserSetText(element, text);
    }

    public String getText (Element element) {
        return browser.browserGetText(element);
    }

    public Select selectList (Element element) {
        return browser.browserSelectList(element);
    }

    public void takeScreenShot() {
        browser.takeScreenShot();
    }

    public void click (Element element) {
        browser.browserClick(element);
    }

    public void find (Element element) {
        browser.browserFind(element);
    }

    public void assertElementPresent (Element element) {
        try {
            find(element);
        } catch (Exception e) {
        } finally {
            Assertions.assertEquals(true, browser.elementPresent(element));
        }
    }
}
