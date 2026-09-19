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
        driver.get("https://mts.by");

        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            cookieBtn.click();
        } catch (Exception e) {
            try {
                WebElement cookieBtnXpath = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Принять')]")));
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
        MtsPage mtsPage = new MtsPage(driver);
        assertNotNull(mtsPage.getCommunicationPlaceholderText());
    }

    @Test
    @Order(2)
    @DisplayName("2. Проверить плейсхолдеры для Домашнего интернета")
    public void testInternetPlaceholders() {
        MtsPage mtsPage = new MtsPage(driver);
        assertNotNull(mtsPage.getInternetPlaceholderText());
    }

    @Test
    @Order(3)
    @DisplayName("3. Проверить плейсхолдеры для Рассрочки")
    public void testInstallmentPlaceholders() {
        MtsPage mtsPage = new MtsPage(driver);
        assertNotNull(mtsPage.getInstallmentPlaceholderText());
    }

    @Test
    @Order(4)
    @DisplayName("4. Проверить плейсхолдеры для Задолженности")
    public void testDebtPlaceholders() {
        MtsPage mtsPage = new MtsPage(driver);
        assertNotNull(mtsPage.getDebtPlaceholderText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
