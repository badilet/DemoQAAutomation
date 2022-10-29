package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Buttons {

    @Test
    public void clickButtons () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/buttons");

        Actions act = new Actions(driver);

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        act.doubleClick(doubleClickButton).perform();

        driver.quit();
    }


}
