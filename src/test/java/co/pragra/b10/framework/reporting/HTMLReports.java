package co.pragra.b10.framework.reporting;

import co.pragra.b10.framework.util.CommonUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class HTMLReports     {

    private ExtentHtmlReporter htmlReporter;
    private ExtentReports reports;
    private static HTMLReports instance;

    private HTMLReports(){
        htmlReporter = new ExtentHtmlReporter("dashboard.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
    }

    public static HTMLReports getInstance() {
        if(instance==null){
            instance = new HTMLReports();
        }
        return instance;
    }

    public ExtentReports getReports() {
        return reports;
    }

}
