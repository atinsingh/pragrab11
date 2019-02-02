package co.pragra.b10.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    WebDriver driver;

    @FindBy(name = "full-name")
    WebElement fullName;
    @FindBy(id = "phone")
    WebElement phone;
    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "type")
    WebElement chooseOption;

    @FindBy(name = "subject")
    WebElement subejct;
    @FindBy(name = "message")
    WebElement msg;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement contactUsBtn;

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ContactUsPage enterName(String name){
        this.fullName.sendKeys(name);
        return this;
    }


    public ContactUsPage enterPhone(String phone){
        this.phone.sendKeys(phone);
        return this;
    }


    public ContactUsPage enterEmaik(String email){
        this.email.sendKeys(email);
        return this;
    }

    public ContactUsPage chooseByIndex(int index){
        Select select = new Select(this.chooseOption);
        select.selectByIndex(index);
        return this;
    }

    public ContactUsPage chooseByValue(String value){
        Select select = new Select(this.chooseOption);
        select.selectByValue(value);
        return this;
    }


    public ContactUsPage enterSubject(String subject){
        this.subejct.sendKeys(subject);
        return this;
    }

    public ContactUsPage enterMsg(String msg){
        this.msg.sendKeys(msg);
        return this;
    }

    public ContactUsPage submitForm(){
        this.contactUsBtn.click();
        return this;
    }









}
