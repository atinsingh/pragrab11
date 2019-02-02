package co.pragra.b10.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LearningPage {

    @FindBy(partialLinkText = "Java Full-Stack")
    private WebElement javaFullStack;

    public LearningPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void clickOnFullStack(){
        this.javaFullStack.click();
    }
}
