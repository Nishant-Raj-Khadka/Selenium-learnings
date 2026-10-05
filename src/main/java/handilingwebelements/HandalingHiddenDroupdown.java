package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandalingHiddenDroupdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userNameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()=' Login ']"));

        userNameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();

        WebElement dropDown = driver.findElement(By.className("oxd-userdropdown-tab"));
        dropDown.click();

        WebElement logOutOption = driver.findElement(By.xpath("//a[text()='Logout']"));
        logOutOption.click();
    }
}