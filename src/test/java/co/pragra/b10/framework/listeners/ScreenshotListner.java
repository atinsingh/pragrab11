package co.pragra.b10.framework.listeners;

import co.pragra.b10.framework.drivermanagement.DriverManager;
import co.pragra.b10.framework.util.CommonUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class ScreenshotListner implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        Path path = Paths.get("target","screenshots","pass");
        String filename = CommonUtils.generateFileNameWithTimeStamp(iTestResult.getName());
        CommonUtils.captureScreenShot(path,filename,DriverManager.getDriverInstance());


    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Path path = Paths.get("target","screenshots","fail");
        String filename = CommonUtils.generateFileNameWithTimeStamp(iTestResult.getName());
        CommonUtils.captureScreenShot(path,filename,DriverManager.getDriverInstance());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
