package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingRadioElement {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement radioButton = driver.findElement(By.id("male"));

        radioButton.click();

        driver.quit();
    }
}