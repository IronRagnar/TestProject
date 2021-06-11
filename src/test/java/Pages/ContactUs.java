package Pages;

import Tools.Browser;
import Tools.Element;
import Tools.Use;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static Data.TestData.*;

public class ContactUs extends ParentPage{

    private Element nameField = Use.css("#input_1_1");
    private Element companyField = Use.css("#input_1_2");
    private Element emailField = Use.css("#input_1_3");
    private Element phoneField = Use.css("#input_1_4");
    private Element projectField = Use.css("#input_1_5");
    private Element detailField = Use.css("#input_1_6");
    private Element submitButton = Use.css("#gform_submit_button_1");
    private Element validationError = Use.css(".validation_error");

    private String errorText = "There was a problem with your submission. Errors have been highlighted below.";

    public ContactUs(Browser browserObj) {
        this.browser = browserObj;
    }

    @Step
    public ContactUs fillOutFormPositive() {
        find(nameField);
        setText(nameField, NAME);
        setText(companyField, COMPANY);
        setText(emailField, EMAIL);
        setText(phoneField, PHONE);
        selectList(projectField).selectByVisibleText(PROJECT_WEB_APPLICATIONS);
        setText(detailField, DETAILS);
        takeScreenShot();
        //click(submitButton);
        return this;
    }

    @Step
    public ContactUs fillOutFormNegative() {
        find(submitButton);
        click(submitButton);
        find(validationError);
        takeScreenShot();
        Assertions.assertEquals(getText(validationError), errorText);
        return this;
    }

}
