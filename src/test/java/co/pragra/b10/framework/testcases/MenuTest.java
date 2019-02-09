package co.pragra.b10.framework.testcases;

import co.pragra.b10.framework.drivermanagement.DriverManager;
import co.pragra.b10.framework.listeners.ScreenshotListner;
import co.pragra.b10.framework.pageobjects.AboutUs;
import co.pragra.b10.framework.pageobjects.ContactUsPage;
import co.pragra.b10.framework.pageobjects.HomePage;
import co.pragra.b10.framework.pageobjects.TopMenu;
import co.pragra.b10.framework.testdata.ExcelReader;
import co.pragra.b10.framework.util.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@Listeners(ScreenshotListner.class)
public class MenuTest {
    WebDriver driver;

    @BeforeSuite
    public void prepare(){
        driver = DriverManager.getDriverInstance();
        driver.get("https://pragra.co");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(enabled = true)
    public void tcAboutUsTest(){
        HomePage homePage = new HomePage(driver);
        TopMenu menu =    homePage.clickOnMenu();
        AboutUs aboutUs = menu.clickAboutUs();

    }

    @Test(dataProviderClass = ExcelReader.class, dataProvider = "excelData")
    public void contactTest(String fullname, String phone,
                            String email,String option,
                            String subject, String msg){
        HomePage homePage = new HomePage(driver);
        TopMenu topMenu = homePage.clickOnMenu();
        ContactUsPage contactUsPage = topMenu.clickOnContactUs();

        contactUsPage.enterName(fullname)
                .enterEmaik(email)
                .enterPhone(phone);

       // CommonUtils.captureScreenShot(Paths.get("target","screenshots","pass"), CommonUtils.generateFileNameWithTimeStamp("Interim_Test") ,driver);

        try{
            contactUsPage.chooseByValue(option)
                    .enterSubject(subject)
                    .enterMsg(msg)
                    .submitForm();

        }catch (Exception ex){
            CommonUtils.captureScreenShot(Paths.get("target,screenshot"),"ABC.jpeg",driver);
        }


    }

//    @Test(dataProviderClass = ExcelReader.class, dataProvider = "excelData")
//    public void testBlank(String fullname, String phone,
//                          String email,String option,
//                          String subject, String msg
//                          ){
//
//        System.out.println(fullname + " "+
//            phone + "  "+ email + " " + option + " "+ subject
//                + " " + msg
//        );
//    }
}


