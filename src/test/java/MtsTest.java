import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MtsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by");

        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            cookieBtn.click();
        } catch (Exception e) {
            try {
                WebElement cookieBtnXpath = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]")));
                cookieBtnXpath.click();
            } catch (Exception ex) {
                System.out.println("Cookie banner not found");
            }
        }
    }

    @Test
    @Order(1)
    @DisplayName("1. Проверить плейсхолдеры для Услуг связи")
    public void testCommunicationPlaceholders() {
        WebElement phone = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@placeholder, 'Номер телефона')]")));
        assertNotNull(phone);
    }

    @Test
    @Order(2)
    @DisplayName("2. Проверить плейсхолдеры для Домашнего интернета")
    public void testInternetPlaceholders() {
        WebElement phone = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@placeholder, 'Номер подписчика') or @id='internet-phone']")));
        assertNotNull(phone);
    }

    @Test
    @Order(3)
    @DisplayName("3. Проверить плейсхолдеры для Рассрочки")
    public void testInstallmentPlaceholders() {
        WebElement score = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@placeholder, 'Номер счета') or @id='score-instalment']")));
        assertNotNull(score);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
