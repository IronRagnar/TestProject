package Pages;

import Tools.Browser;
import Tools.Element;
import Tools.Use;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage extends  ParentPage{

    Element contactButton = Use.css("a[href='https://aionis.io/contact-us/']");

    public HomePage(Browser browserObj) {
        this.browser = browserObj;
    }

    @Step
    public ContactUs clickContactUs() {
        find(contactButton);
        takeScreenShot();
        JavascriptExecutor executor = (JavascriptExecutor)browser.driver;
        executor.executeScript("arguments[0].click();", browser.driver.findElement(contactButton.Query));
        return new ContactUs(browser);
    }
}
