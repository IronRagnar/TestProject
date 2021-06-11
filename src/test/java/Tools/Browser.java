package Tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
    public static WebDriver driver;

    private static int counter = 0;

    public Browser() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--start-fullscreen");
        opts.addArguments("--headless");
        driver = new ChromeDriver(opts);
        driver.manage().window().setSize(new Dimension(1920,1080));

        driver.manage().window().maximize();
    }

    public void browserClick(Element element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element.Query));
        driver.findElement(element.Query).click();
    }

    public String browserGetText(Element element) {
        return driver.findElement(element.Query).getText();
    }

    public void browserSetText(Element element, String keys) {
        driver.findElement(element.Query).sendKeys(keys);
    }

    public Select browserSelectList (Element element) {
        Select s = new Select(driver.findElement(element.Query));
        return s;
    }

    public void browserFind (Element element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(element.Query));
        driver.findElement(element.Query);
    }

    @Attachment(value = "screenshot {counter}", type = "image/png")
    private static byte[] makeScreenShot(int counter) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static byte[] takeScreenShot() {
        counter++;
        return makeScreenShot(counter);
    }

    public boolean elementPresent(Element element) {
        return driver.findElements(element.Query).size() > 0;
    }

    public void clearScreenshotCounter() {
        counter = 0;
    }

    public void goTo (String url){
        driver.get(url);
    }

}
