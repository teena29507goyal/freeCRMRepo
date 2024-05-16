package com.qa.cifAdminPages;

import com.qa.testBase.TestBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class loginPage extends TestBaseClass {

    //Define Page Factory : Object Repository
    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    WebElement logIn;

    @FindBy(name="email")
    WebElement UserName;

    @FindBy(name="password")
    WebElement Password;

    @FindBy(xpath = "//a[@title='free crm home']")
    WebElement Logo;

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    WebElement loginBtn;


    //Initilize the Object Repository
    public loginPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public boolean pageLogoValidate(){
        Logo.isDisplayed();
        logIn.click();
        return true;
    }

    public HomePage login(String un, String pas) throws IOException {
        UserName.sendKeys(un);
        Password.sendKeys(pas);
        loginBtn.click();

        return new HomePage();
    }

}
