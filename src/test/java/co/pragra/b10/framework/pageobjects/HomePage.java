package co.pragra.b10.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='side_menu_button']/a")
    WebElement menuIcon;

    @FindBy(className = "icon-basic-lightbulb")
    private WebElement lightBulb;

    @FindBy(xpath = "//a[@itemprop='url']/i[ contains(@class, 'icon-weather-cloud')]")
    private WebElement cloudLink;

    public HomePage(WebDriver driver){
        this.driver  = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnLightBulb(){
        this.lightBulb.click();
    }

    public void clickOnCloudLink(){
        this.cloudLink.click();
    }

    public TopMenu clickOnMenu(){
        this.menuIcon.click();
        return new TopMenu(driver);
    }
}
