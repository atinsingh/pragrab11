package co.pragra.b10.framework.util;

import co.pragra.b10.framework.config.DriverConfig;
import co.pragra.b10.framework.drivermanagement.DriverManager;
import org.apache.commons.io.FileUtils;
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

    public static void captureScreenShot(Status status, String fileName ,WebDriver driver){
        String directory;
        if(status==Status.PASS){
            directory = DriverConfig.getProperty("passLocation");
        }else {
            directory = DriverConfig.getProperty("failLocation");
        }

        try {
            FileUtils.forceMkdir(new File(directory));
           // Files.createDirectory(directory);

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
    public static String getScreenShotPath(Status status, String fileName){
        if(Status.PASS==status){
            return DriverConfig.getProperty("passLocation")+"/"+fileName;
        }
        return DriverConfig.getProperty("failLocation")+"/"+fileName;
    }
}
