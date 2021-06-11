import Tools.Browser;
import Tools.Open;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ParentTest {

    Browser browser;
    Open open;

    @BeforeEach
    void setUp() {
        browser = new Browser();
        open = new Open(browser); //needed for static Open class to work
    }

    @AfterEach
    void tearDown() {
        browser.takeScreenShot();
        browser.clearScreenshotCounter();
        browser.driver.quit();
    }

}
