package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandalingSourceDropDown {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userNameField = driver.findElement(
                By.xpath("//input[@placeholder='Username']")
        );

        WebElement passwordField = driver.findElement(
                By.xpath("//input[@placeholder='Password']")
        );

        WebElement loginButton = driver.findElement(
                By.xpath("//button[text()=' Login ']")
        );

        userNameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();

        WebElement pim = driver.findElement(
                By.xpath("//span[text()='PIM']")
        );

        pim.click();


        //following-sibling (//*[@attribute=”value”]/following-sibling::sibling-tagname[@attribute=”value”])
        // Go one level up to the parent <div>  -->   "/.."
        WebElement jobTitleDropDown = driver.findElement(By.xpath(
                "//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'oxd-select-text')]"
        ));

        jobTitleDropDown.click();

        WebElement automationTester = driver.findElement(By.xpath(
                "(//div[@role='option'])[3]"
        ));

        automationTester.click();
    }
}




