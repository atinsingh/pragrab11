package co.pragra.b10.framework.testcases;

import co.pragra.b10.framework.drivermanagement.DriverManager;
import co.pragra.b10.framework.pageobjects.KijijiDashboard;
import co.pragra.b10.framework.pageobjects.KijijiHome;
import co.pragra.b10.framework.util.CommonUtils;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.poi.util.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;


public class AdPost {
    WebDriver webDriver;
    KijijiDashboard dashboard;

    @BeforeSuite(enabled = true)
    public void prepare(){
      webDriver = DriverManager.getDriverInstance();
      webDriver.get("https://www.kijiji.ca/");
    }

    @BeforeTest(enabled = true)
    public void setLocation(){
        webDriver.findElement(By.linkText("Ontario (M - Z)")).click();
        CommonUtils.sleep(1000);
        webDriver.findElement(By.linkText("Toronto (GTA)")).click();
        CommonUtils.sleep(1000);
        webDriver.findElement(By.linkText("Mississauga / Peel Region")).click();
        CommonUtils.sleep(1000);
        webDriver.findElement(By.id("LocUpdate")).click();
        CommonUtils.sleep(1000);
        webDriver.findElement(By.linkText("Sign In")).click();
        CommonUtils.sleep(1000);
        KijijiHome home = new KijijiHome(webDriver);
        home.setLogin("qa@pragra.ca").setPassword("P@ssw0rd");
        CommonUtils.sleep(3000);
        dashboard = home.login();

        CommonUtils.sleep(3000);

    }



    @Test
    public void postAdd(){

        Fillo fillo = new Fillo();
        try {
            Connection connection = fillo.getConnection("/Users/atinsingh/Downloads/AdvetExcel.xlsx");
            Recordset recordset = connection.executeQuery("select * from QA");
            ArrayList<String> fieldNames = recordset.getFieldNames();
            Map<String, String> postCodeTitleMap = new HashMap<>();
            List<String> images = new ArrayList<>();
            while (recordset.next()){
                postCodeTitleMap.put(recordset.getField("PostCodes"),recordset.getField("Title") ) ;
                if(!recordset.getField("Image").isEmpty()||!recordset.getField("Image").equals("")){
                    images.add(recordset.getField("Image"));
                }

            }


            postCodeTitleMap.forEach((k,v)->{
                try {
                dashboard
                        .clickPostAdv()
                        .addTitle(v+"-"+k)
                        .addDescription(recordset.getField("Description"));
                        for (String img: images){
                            System.out.println(recordset.getField("ImagePath")+"/"+img);
                            dashboard.addImages(recordset.getField("ImagePath")+"/"+img);
                        }

                        dashboard.addPhone(recordset.getField("Phone")).addPostCode(k)
                        .done();


                }catch (Exception ex){

                }
                CommonUtils.sleep(10000);

            });

        } catch (FilloException e) {
            e.printStackTrace();
        }

    }


}
