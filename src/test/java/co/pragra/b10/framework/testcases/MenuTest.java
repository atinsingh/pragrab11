package co.pragra.b10.framework.testcases;

import co.pragra.b10.framework.drivermanagement.DriverManager;
import co.pragra.b10.framework.pageobjects.AboutUs;
import co.pragra.b10.framework.pageobjects.ContactUsPage;
import co.pragra.b10.framework.pageobjects.HomePage;
import co.pragra.b10.framework.pageobjects.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuTest {
    WebDriver driver;

    @BeforeSuite
    public void prepare(){
        driver = DriverManager.getDriverInstance();
        driver.get("https://pragra.co");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void tcAboutUsTest(){
        HomePage homePage = new HomePage(driver);
        TopMenu menu =    homePage.clickOnMenu();
        AboutUs aboutUs = menu.clickAboutUs();

    }

    @Test
    public void contactTest(){
        HomePage homePage = new HomePage(driver);
        TopMenu topMenu = homePage.clickOnMenu();
        ContactUsPage contactUsPage = topMenu.clickOnContactUs();

        contactUsPage.enterName("Karan")
                .enterEmaik("karan@pragra.co")
                .enterPhone("2836387626")
                .chooseByIndex(2)
                .enterSubject("Testing")
                .enterMsg("This is just a test-please ignore or charge me")
                .submitForm();


    }
}
