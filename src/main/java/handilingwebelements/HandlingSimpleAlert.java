package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingSimpleAlert {
    WebDriver driver;
    public static void main(String[] args) {
        HandlingSimpleAlert alert = new HandlingSimpleAlert();
        alert.setup();
        // alert.simpleAlert();
        // alert.confirmationAlert();
        alert.promptAlert();


    }

    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");


    }

    public void simpleAlert(){

        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Simple Alert']"));
        alertButton.click();

        driver.switchTo().alert().accept();

    }

    public void confirmationAlert(){

        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[text()='Confirmation Alert']"));
        confirmationAlertButton.click();

        driver.switchTo().alert().dismiss();

    }

    public void promptAlert(){

        WebElement promptAlertButton = driver.findElement(By.xpath("//button[text()='Prompt Alert']"));
        promptAlertButton.click();

        driver.switchTo().alert().sendKeys("Broadway Infosys ");

    }
}