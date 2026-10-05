package handilingwebelements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleHandlingFrames {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.automationtesting.in/Frames.html");

        // First iframe
        WebElement firstIframe = driver.findElement(
                By.xpath("//iframe[@src='MultipleFrames.html']")
        );

        driver.switchTo().frame(firstIframe);

        // Second iframe
        WebElement secondFrame = driver.findElement(
                By.xpath("//iframe[@src='SingleFrame.html']")
        );

        driver.switchTo().frame(secondFrame);

        // Text field
        WebElement textField = driver.findElement(
                By.xpath("//input[@type='text']")
        );

        textField.sendKeys("Broadway Infosys");

        // Back to main page
        driver.switchTo().defaultContent();

        driver.quit();
    }
}