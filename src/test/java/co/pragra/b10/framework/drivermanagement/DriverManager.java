package co.pragra.b10.framework.drivermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static DriverManager driverManager;
    private WebDriver driver;


    private DriverManager(){
        System.setProperty("webdriver.chrome.driver","/Users/atinsingh/Downloads/chromedriver");
        this.driver = new ChromeDriver();
    }

    public static WebDriver getDriverInstance(){
        if(driverManager == null){
            driverManager = new DriverManager();
        }
        return  driverManager.driver;
    }
}
