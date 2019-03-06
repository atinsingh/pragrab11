package co.pragra.b10.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KijijiHome {

    WebDriver driver;

    @FindBy(id = "LoginEmailOrNickname")
    private WebElement loginId;

    @FindBy(id = "login-password")
    private WebElement loginPasswd;

    @FindBy(id = "SignInButton")
    private WebElement submitBtn;


    public KijijiHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public KijijiHome setLogin(String login){
        this.loginId.sendKeys(login);
        return this;
    }

    public KijijiHome setPassword(String pass){
        this.loginPasswd.sendKeys(pass);
        return this;
    }

    public KijijiDashboard login(){
        this.submitBtn.click();
        return new KijijiDashboard(driver);
    }

}
