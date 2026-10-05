package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingDynamicTable {

    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.expandtesting.com/dynamic-table");

        // Find all columns
        List<WebElement> numberofColumns = driver.findElements(
                By.xpath("//table[@class='table table-striped']/thead/tr/th")
        );

        System.out.println(
                "The total number of columns are: " + numberofColumns.size()
        );

        // Find all rows
        List<WebElement> numberofRows = driver.findElements(
                By.xpath("//table[@class='table table-striped']/tbody/tr")
        );

        System.out.println(
                "The total number of rows which contain data are: "
                        + numberofRows.size()
        );

        // Loop through all rows
        for (int row = 1; row <= numberofRows.size(); row++) {

            String rowValue = driver.findElement(
                    By.xpath("//table[@class='table table-striped']/tbody/tr[" + row + "]/td[1]")
            ).getText();

            if (rowValue.equals("Chrome")) {

                String cpuLoadValue = driver.findElement(
                        By.xpath("//td[text()='Chrome']/following-sibling::td[contains(text(),'%')]")
                ).getText();

                String yellowColorText = driver.findElement(
                        By.id("chrome-cpu")
                ).getText();

                if (yellowColorText.contains(cpuLoadValue)) {

                    System.out.println(
                            "Both have the same value and it is: " + cpuLoadValue
                    );
                }
            }
        }


    }
}


//windows multiple windows handling
//pagination table
