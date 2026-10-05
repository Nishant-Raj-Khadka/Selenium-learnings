package handilingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");

        WebElement firstFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(firstFrame);

        WebElement datePicker = driver.findElement(By.id("datepicker"));
//        datePicker.sendKeys("10/16/2026");
        datePicker.click();

        String day = "15";
        String month = "December";
        String year = "2027";

        while(true){
            String actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            String actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();

            if(actualMonth.equals(month) && actualYear.equals(year)){
                break;
            }else{
                WebElement nextCalendarButton = driver.findElement(By.xpath("//span[text()='Next']"));
                nextCalendarButton.click();
            }
        }

        List<WebElement> noOfDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for(WebElement calendarDay : noOfDays){
            String weekDate = calendarDay.getText();
            if(weekDate.equals(day)){
                calendarDay.click();
            }

        }
    }
}
