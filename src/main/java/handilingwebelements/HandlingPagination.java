package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingPagination {

    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");


        List<WebElement> numberofColumns = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th"));
        System.out.println("The total number of columns are: " + numberofColumns.size());


        List<WebElement> paginationButtons = driver.findElements(By.xpath("//ul[@id='pagination']/li/a"));
        System.out.println("The total number of pages are: " + paginationButtons.size());

        // Loop through all pages
        for (int page = 1; page <= paginationButtons.size(); page++) {
            System.out.println("\n" + page );

            // Click the page number
            driver.findElement(By.xpath("//ul[@id='pagination']/li[" + page + "]/a")).click();


            List<WebElement> numberofRows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
            System.out.println("The total number of rows are: " + numberofRows.size());

            // Print data from every row
            for (int row = 1; row <= numberofRows.size(); row++) {
                String id = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + row + "]/td[1]")).getText();
                String name = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + row + "]/td[2]")).getText();
                String price = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + row + "]/td[3]")).getText();
                System.out.println("ID: " + id + "Name: " + name + "Price: " + price);
            }
        }
    }
}