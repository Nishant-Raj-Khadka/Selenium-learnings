package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingProgressBar {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/progress-bar");

        WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate Start button
        WebElement startButton = explicit.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[text()='Start']")
                )
        );

        // Click Start
        startButton.click();

        // Wait until progress reaches 100%
        explicit.until(
                ExpectedConditions.attributeToBe(
                        By.id("progressBar"),
                        "aria-valuenow",
                        "100"
                )
        );

        // Locate Reset button
        WebElement resetButton = explicit.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[text()='Reset']")
                )
        );

        // Click Reset
        resetButton.click();

    }
}