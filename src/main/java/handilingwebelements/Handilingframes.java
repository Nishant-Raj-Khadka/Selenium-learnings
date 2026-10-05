package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Handilingframes {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1st iframe
        driver.get("https://practice-automation.com/iframes/");
        // driver.switchTo().frame("iframe-1");                 //by-id
        // driver.switchTo().frame("top-iframe");        //by-name
        //WebElement docs = driver.findElement(By.xpath("//a[text()='Docs']"));
        //docs.click();


        //using xpath/element to find iframe
        WebElement firstframe = driver.findElement(By.xpath("//iframe[@name='top-iframe']"));
        driver.switchTo().frame(firstframe);
        WebElement documents = driver.findElement(By.xpath("//a[text()='Docs']"));
        documents.click();

// 2nd page iframe --- need to get out of frame to default content and hop in again to second frame
        // scrolling down to second iframe so that it is visible
        driver.switchTo().defaultContent();
        WebElement meTooText = driver.findElement(By.xpath("//p[text()='Me too!']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", meTooText);




        // driver.switchTo().frame("iframe-2");
        driver.switchTo().frame("bottom-iframe");
        WebElement download = driver.findElement(By.xpath("//span[text()='Downloads']"));
        download.click();

        driver.switchTo().defaultContent();
    }
}
