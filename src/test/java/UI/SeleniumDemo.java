package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.time.Duration;

public class SeleniumDemo {

    String name = "Adilet Bekboev";
    String email = "badilet@yahoo.com";
    String currentAddress = "Kizil-Suu 2";
    String permanentAddress = "Prospect Mira 125";

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

//        driver.get("https://www.google.com/");
//        driver.findElement(By.name("q")).sendKeys("Apple");
//        driver.findElement(By.className("gNO89b")).click();

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
    public void xpathTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

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

    @Test
    public void practiceFormTest() throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstNameInput.sendKeys("Akdil");

        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastNameInput.sendKeys("Toktosun uulu");

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='userEmail']"));
        emailInput.sendKeys("akdil@gmail.com");

        WebElement genderCheck = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]"));
        genderCheck.click();

        WebElement mobileNumberInput = driver.findElement(By.xpath("//input[@id='userNumber']"));
        mobileNumberInput.sendKeys("0555999000");

//        WebElement dobInput = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
//        dobInput.sendKeys(Keys.BACK_SPACE);
//        dobInput.sendKeys(Keys.BACK_SPACE);
//        dobInput.sendKeys("00");

        WebElement subjectInput = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        subjectInput.sendKeys("ma");
        subjectInput.sendKeys(Keys.ENTER);
        subjectInput.sendKeys("comp");
        subjectInput.sendKeys(Keys.ENTER);

        WebElement hobbiesInput1 = driver.findElement(By.xpath("//label[text()='Sports']"));
        hobbiesInput1.click();
        WebElement hobbiesInput2 = driver.findElement(By.xpath("//label[text()='Reading']"));
        hobbiesInput2.click();
        WebElement hobbiesInput3 = driver.findElement(By.xpath("//label[text()='Music']"));
        hobbiesInput3.click();

        WebElement pictureUpload = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        pictureUpload.sendKeys("//Users/user/Desktop/IMG_2906.jpg");

        JavascriptExecutor zoom = (JavascriptExecutor) driver;
        zoom.executeScript("document.body.style.zoom='75%'");

        WebElement currentAddressInput = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddressInput.sendKeys("Hinnman Avenue 1");

        WebElement selectState = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        selectState.sendKeys("raj");
        selectState.sendKeys(Keys.ENTER);

        WebElement selectCity = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        selectCity.sendKeys("jaip");
        selectCity.sendKeys(Keys.ENTER);

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.sendKeys(Keys.ENTER);

        driver.quit();
    }
}