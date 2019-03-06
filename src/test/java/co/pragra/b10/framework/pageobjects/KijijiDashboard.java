package co.pragra.b10.framework.pageobjects;

import co.pragra.b10.framework.util.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.debugger.Page;

import java.util.concurrent.TimeUnit;

public class KijijiDashboard {
    WebDriver driver;

    //@FindBy(className = "headerButtonPostAd-2493039301")
    WebElement postBtn;

    WebElement advTitle;

    WebElement nextBtn;

    public KijijiDashboard(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public KijijiDashboard clickPostAdv(){
        CommonUtils.sleep(1000);
        this.postBtn = driver.findElement(By.cssSelector(".headerButtonPostAd-2493039301"));
        this.postBtn.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        advTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("AdTitleForm")));
        return this;
    }

    public KijijiDashboard addTitle(String title){
        this.advTitle.sendKeys(title);
        this.postBtn = driver.findElement(By.className("titleButton-581419873"));
        this.postBtn.click();
        CommonUtils.sleep(3000);
        this.driver.findElement(By.xpath("//button[contains(@class, 'categoryButton-3830788057') and .='Community']")).click();
        CommonUtils.sleep(3000);
        this.driver.findElement(By.xpath("//button[contains(@class, 'categoryButton-3830788057') and .='Classes & Lessons']")).click();
        return this;
    }

    public KijijiDashboard addDescription(String desc){
        CommonUtils.sleep(4000);
        this.driver.findElement(By.id("pstad-descrptn")).sendKeys(desc);
        CommonUtils.sleep(1000);
        return this;
    }

    public KijijiDashboard addImages(String pathNname){
        WebElement image = this.driver.findElement(By.cssSelector("input[type=file]"));
        CommonUtils.sleep(2000);
        image.sendKeys(pathNname);
        CommonUtils.sleep(5000);
        return this;
    }

    public KijijiDashboard addPostCode(String code){
        try {
            CommonUtils.sleep(2000);
            WebElement chage = driver.findElement(By.className("changeLocationButton-4267647427"));
            CommonUtils.scollinView(chage);
            CommonUtils.sleep(3000);
            chage.click();
            CommonUtils.sleep(2000);
        }catch (Exception ex){

        }
        WebElement location = driver.findElement(By.id("location"));
        char [] chars = code.toCharArray();
        for(char c: chars){
            location.sendKeys(""+c+"");
            CommonUtils.sleep(800);
        }
        CommonUtils.sleep(5000);
        location.clear();
        for(char c: chars){
            location.sendKeys(""+c+"");
            CommonUtils.sleep(800);
        }
        CommonUtils.sleep(3000);
        driver.findElement(By.cssSelector(".autocompleteSuggestion-1169923906:last-child")).click();
        CommonUtils.sleep(3000);
        driver.findElement(By.cssSelector("label[for=priceType3]")).click();
        CommonUtils.sleep(3000);
        CommonUtils.scollinView(driver.findElement(By.cssSelector("button[name=saveAndCheckout]")));
        driver.findElement(By.cssSelector("button[name=saveAndCheckout]")).click();
        return this;
    }

    public KijijiDashboard addPhone(String phone){
        this.driver.findElement(By.id("PhoneNumber")).sendKeys(phone);
        CommonUtils.sleep(3000);
        return this;
    }

    public void done(){

    }
}
