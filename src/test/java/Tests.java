import Tools.Open;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Tests extends ParentTest{

    @Test
    @Description("Simulates positive case of filling out Contact Us form")
    @Severity(SeverityLevel.NORMAL)
    void Positive_Test() {
        Open.openHomePage().clickContactUs().fillOutFormPositive();
    }

    @Test
    @Description("Simulates negative case of filling out Contact Us form")
    @Severity(SeverityLevel.NORMAL)
    void Negative_Test() {
        Open.openHomePage().clickContactUs().fillOutFormNegative();
    }
}
