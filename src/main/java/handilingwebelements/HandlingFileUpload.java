package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingFileUpload {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement uploadFileText = driver.findElement(By.xpath("//h2[text()='Upload Files']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", uploadFileText);

        WebElement chooseFileButton = driver.findElement(By.id("singleFileInput"));

        chooseFileButton.sendKeys("C:\\Users\\ACER\\Downloads\\xyzzz.jpeg");  //file chosen

        WebElement fileUploadButton = driver.findElement(By.xpath("//button[text()='Upload Single File']"));

        fileUploadButton.click();
    }
}
