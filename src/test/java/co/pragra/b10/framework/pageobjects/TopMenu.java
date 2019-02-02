package co.pragra.b10.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenu {

    WebDriver driver;

    @FindBy(css = "#menu-fullscreen-menu li:nth-child(1)")
    private WebElement home;
    @FindBy(css = "#menu-fullscreen-menu li:nth-child(4)")
    private WebElement aboutUs;
    @FindBy(css = "#menu-fullscreen-menu li:nth-child(5)")
    private WebElement contactUs;
    @FindBy(css = "#menu-fullscreen-menu li:nth-child(3)")
    private WebElement searviceS;
    @FindBy(css = "#menu-fullscreen-menu li:nth-child(2)")
    private WebElement pragram;

    public TopMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AboutUs clickAboutUs(){
        this.aboutUs.click();
        return new AboutUs();
    }

    public HomePage clickOnHomeLink(){
        this.home.click();
        return new HomePage(driver);
    }

    public ContactUsPage clickOnContactUs(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(this.contactUs));
        this.contactUs.click();
        return new ContactUsPage(driver);
    }





}
