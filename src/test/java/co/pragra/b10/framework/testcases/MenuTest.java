package co.pragra.b10.framework.testcases;

import co.pragra.b10.framework.config.DriverConfig;
import co.pragra.b10.framework.drivermanagement.DriverManager;
import co.pragra.b10.framework.listeners.ScreenshotListner;
import co.pragra.b10.framework.pageobjects.ContactUsPage;
import co.pragra.b10.framework.pageobjects.HomePage;
import co.pragra.b10.framework.pageobjects.TopMenu;
import co.pragra.b10.framework.reporting.HTMLReports;
import co.pragra.b10.framework.testdata.ExcelReader;
import co.pragra.b10.framework.util.CommonUtils;
import co.pragra.b10.framework.util.Status;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(ScreenshotListner.class)
public class MenuTest {
    WebDriver driver;

    ExtentTest extentTest;

    @BeforeSuite
    public void prepare(){
        driver = DriverManager.getDriverInstance();
        driver.get("https://pragra.co");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        extentTest = HTMLReports.getInstance().getReports().createTest("MenuTest");
    }

    @Test(enabled = true)
    public void tcAboutUsTest(){
        HomePage homePage = new HomePage(driver);
        TopMenu menu =    homePage.clickOnMenu();
       // AboutUs aboutUs = menu.clickAboutUs();
        extentTest.pass("<b style=\"color:green\"> Passed </b> tcAboutUsTest");
        String captureFile = CommonUtils.generateFileNameWithTimeStamp("tcAboutUsTest");
        CommonUtils.captureScreenShot(Status.PASS,captureFile,driver);
        try{
            extentTest.addScreenCaptureFromPath(CommonUtils.getScreenShotPath(Status.PASS,captureFile));
        }catch (IOException ex){

        }


    }

    @Test(enabled = false, dataProviderClass = ExcelReader.class, dataProvider = "excelData")
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
            CommonUtils.captureScreenShot(Status.PASS,"ABC.jpeg",driver);
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


    @AfterTest
    public void tearDown(){
        DriverConfig.getProperty("himashu");
        HTMLReports.getInstance().getReports().flush();
        driver.quit();
    }
}


