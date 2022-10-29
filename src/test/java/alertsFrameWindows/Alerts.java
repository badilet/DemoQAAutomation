package alertsFrameWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/alerts");
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void TestClickButtonToSeeAlert() {
        WebElement clickMeInput1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
        clickMeInput1.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void testPromptBox() {
        WebElement clickMeInput4 = driver.findElement(By.xpath("//button[@id='promtButton']"));
        clickMeInput4.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Adilet");
        alert.accept();
    }

}
