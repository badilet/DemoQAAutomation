package alertsFrameWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class BrowserWindows {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/browser-windows");
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void testNewTab() {
        String currentPage = driver.getWindowHandle();

        for (int i = 0; i < 5; i++) {
            WebElement newTabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
            newTabButton.click();
            driver.switchTo().window(currentPage);
        }

        List<String> tabs = new LinkedList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }
}
