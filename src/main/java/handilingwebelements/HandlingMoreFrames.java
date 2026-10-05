package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingMoreFrames {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.automationtesting.in/Frames.html");

        // Find the Single Iframe
        WebElement singleFrame = driver.findElement(By.id("singleframe"));

        // Switch into iframe of Single Iframe
        driver.switchTo().frame(singleFrame);
        WebElement firsttextBox = driver.findElement(By.xpath("//input[@type='text']"));
        firsttextBox.sendKeys("Broadway Infosys");
        driver.switchTo().defaultContent();

        // Click on "Iframe with in an Iframe" btn
        WebElement nestedIframeButton = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
        nestedIframeButton.click();

        // Switch to the outer iframe "Nested iFrames"
        WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(outerFrame);

        // Switch to the inner iframe "iFrame Demo"
        WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(innerFrame);

        WebElement secondtextBox = driver.findElement(By.xpath("//input[@type='text']"));
        secondtextBox.sendKeys("Nishant");

        // Return to main page
        //driver.switchTo().defaultContent();



    }
}