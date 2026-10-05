package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandalingStaticTable {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement staticTableText = driver.findElement(
                By.xpath("//h2[text()='Static Web Table']")
        );

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript(
                "arguments[0].scrollIntoView();",
                staticTableText
        );

        // Find all rows
        List<WebElement> numberofRows = driver.findElements(
                By.xpath("//table[@id='productTable']/tbody/tr")
        );

        System.out.println("The total number of rows are: " + numberofRows.size());

        // Find all columns
        List<WebElement> numberofColumns = driver.findElements(
                By.xpath("//table[@id='productTable']/tbody/tr[1]/td")
        );

        System.out.println("The total number of columns are: " + numberofColumns.size());


        // Find all data
        List<WebElement> numberofData = driver.findElements(
                By.xpath("//table[@id='productTable']/tbody/tr/td")
        );

        // Find all data using for loop

        for(WebElement data:numberofData){
            String value = data.getText();
            System.out.println(value);
        }


    }
}