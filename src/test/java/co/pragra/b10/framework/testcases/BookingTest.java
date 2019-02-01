package co.pragra.b10.framework.testcases;

import co.pragra.b10.framework.drivermanagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BookingTest {
    WebDriver driver;
  // Implicit
    // Explicit
    // Fluent


    @BeforeSuite
    public void setup(){
        driver = DriverManager.getDriverInstance();
        //driver.get("https://ca.hotels.com/");
    }

    @Test(enabled = false)
    public void checkTitleTest(){
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Booking"));
    }

    @Test(enabled = false)
    public void searchTest(){
        WebElement cityInput = driver.findElement(By.id("qf-0q-destination"));
        cityInput.sendKeys("Toro");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement selectCity  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@class='autosuggest-city']//tr[3]")));

        selectCity.click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.cssSelector("a[data-option-id=opt_BEST_SELLER]")).click();
    }

    @Test
    public void explictWaitTest(){
        driver.get("https://pragra.co/sel.html");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement doubleClick = driver.findElement(By.id("dblclik"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).build().perform();
        driver.switchTo().alert().dismiss();

        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(100));



    }

}
