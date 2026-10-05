package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandlingMouseHover {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement mouseHoverClick = driver.findElement(By.xpath("//h2[text()='Mouse Hover']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", mouseHoverClick);

        WebElement pointMeButton = driver.findElement(By.xpath("//button[text()='Point Me']"));
        WebElement mobileOption = driver.findElement(By.xpath("//a[text()='Mobiles']"));


        Actions act = new Actions(driver);
        act.moveToElement(pointMeButton).build().perform();
        act.moveToElement(mobileOption).build().perform();
    }
}
