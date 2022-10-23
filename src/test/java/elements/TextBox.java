package elements;

import generalVariables.GeneralVariables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;


import java.time.Duration;

public class TextBox extends GeneralVariables {

    @Test
    public void textBoxComparison() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");

        WebElement nameInput = driver.findElement(By.id("userName"));
        nameInput.sendKeys(name);
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys(email);
        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys(currentAddress);
        WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));
        permanentAddressInput.sendKeys(permanentAddress);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement testName = driver.findElement(By.id("name"));
        Assertions.assertEquals(name, testName.getText().substring(5));
        WebElement testMail = driver.findElement(By.id("email"));
        Assertions.assertEquals(email, testMail.getText().substring(6));
        WebElement testCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        Assertions.assertEquals(currentAddress, testCurrentAddress.getText().substring(17));
        WebElement testPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        Assertions.assertEquals(permanentAddress, testPermanentAddress.getText().substring(20));

        driver.quit();
    }

    @Test
    public void testWithXpath() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputField = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullNameInputField.sendKeys("John");

        WebElement emailInputField = driver.findElement(By.xpath("//input[@id='userEmail']"));
        emailInputField.sendKeys("john@yahoo.com");

        WebElement currentAddressInputField = driver.findElement(By.xpath("(//textarea[@class='form-control'])[1]"));
        currentAddressInputField.sendKeys("Kizil-Suu 1");

        WebElement permAddressInputField = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permAddressInputField.sendKeys("Prospect Mira 2");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        driver.quit();
    }
}
