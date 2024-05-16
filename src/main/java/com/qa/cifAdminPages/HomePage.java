package com.qa.cifAdminPages;

import com.qa.testBase.TestBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class HomePage extends TestBaseClass {

    Actions action;

    @FindBy(xpath = "//div[@id='main-nav']//a[@class='item' and @href='/contacts']")
    WebElement ContactLink;

    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    WebElement DealLink;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    WebElement TaskLink;

    @FindBy(xpath = "//b[contains(text(),'Paytm')]")
    WebElement HomePageTitle;

    @FindBy(xpath = "//span[contains(text(),'Teena Goyal')]")
    WebElement userNameLabel;


    public HomePage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public String validateTitle(){
       return HomePageTitle.getText();
    }

    public boolean verifyUserName(){
        return userNameLabel.isDisplayed();
    }

    public ContactPage clickContactsLink() throws IOException {
        action = new Actions(driver);
       // action.moveToElement(ContactLink).perform();
        ContactLink.click();
        return new ContactPage();
    }

    public DealPage clickDealLink() throws IOException {
       // action.moveToElement(DealLink).build().perform();
        DealLink.click();
        return new DealPage();
    }

}
