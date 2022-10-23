package forms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.time.Duration;

public class PracticeForm {

    @Test
    public void TestPracticeForm() throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");

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