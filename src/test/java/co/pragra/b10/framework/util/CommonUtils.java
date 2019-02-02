package co.pragra.b10.framework.util;

import co.pragra.b10.framework.drivermanagement.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static String generateFileNameWithTimeStamp(String testName){
        SimpleDateFormat format = new SimpleDateFormat("ddMMYYYYHHmmss");
        Date date = new Date();
        return  "ScreenSHot_"+ testName +"_" + format.format(date)+".png";
    }

    public static void captureScreenShot(Path directory, String fileName ,WebDriver driver){
        try {
            Files.createDirectory(directory);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File diskFile = new File(directory.toString()+"/"+ fileName);
            com.google.common.io.Files.copy(screenshot,diskFile);
        }catch (Exception ex){
        }

    }
}