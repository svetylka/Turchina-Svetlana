import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MtsPage {
    WebDriver driver;
    WebDriverWait wait;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getCommunicationPlaceholderText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@placeholder, 'Номер телефона')]")
        )).getAttribute("placeholder");
    }

    public String getInternetPlaceholderText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@placeholder, 'Номер подписчика') or @id='internet-phone']")
        )).getAttribute("placeholder");
    }

    public String getInstallmentPlaceholderText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@placeholder, 'Номер счета') or @id='score-instalment']")
        )).getAttribute("placeholder");
    }

    public String getDebtPlaceholderText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@placeholder, 'Номер счета') or @id='score-arrears']")
        )).getAttribute("placeholder");
    }
}
