package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandlingDragandDrop {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement countryText = driver.findElement(By.xpath("//label[text()='Country:']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", countryText);

        WebElement countryDropDown = driver.findElement(By.id("country"));
        Select country = new Select(countryDropDown);

        //
        //    country.selectByIndex(3);
        //    country.selectByVisibleText("Japan");
        country.selectByValue("uk");
    }
}