import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
                System.out.println("Баннер куки не появился");
            }
        }
    }

    @Test
    @Order(1)
    @DisplayName("1. Проверить название указанного блока")
    public void testBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Онлайн пополнение')]")));
        assertNotNull(title);
    }

    @Test
    @Order(2)
    @DisplayName("2. Проверить логотипы платёжных систем")
    public void testPaymentLogos() {
        List<WebElement> logos = driver.findElements(By.cssSelector(".pay__partners img"));
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены!");
    }

    @Test
    @Order(3)
    @DisplayName("3. Проверить ссылку 'Подробнее о сервисе'")
    public void testMoreInfoLink() {
        WebElement moreInfoLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
        assertTrue(moreInfoLink.isDisplayed());
    }

    @Test
    @Order(4)
    @DisplayName("4. Проверить работу кнопки 'Продолжить'")
    public void testSubmitForm() {
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        phoneInput.sendKeys("297777777");

        WebElement amountInput = driver.findElement(By.id("connection-sum"));
        amountInput.sendKeys("10");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        assertTrue(submitButton.isEnabled());
        submitButton.click();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
