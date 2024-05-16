package com.qa.cifAdminTest;

import com.qa.cifAdminPages.ContactPage;
import com.qa.cifAdminPages.HomePage;
import com.qa.cifAdminPages.loginPage;
import com.qa.testBase.TestBaseClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactPageTest extends TestBaseClass {

    HomePage homePage;
    loginPage loginPage;
    ContactPage contactPage ;

    public ContactPageTest() throws IOException {
        super();

    }

    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {
        Initilization();
        loginPage = new loginPage();
        homePage = new HomePage();
        contactPage = new ContactPage();
        loginPage.pageLogoValidate();
        loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
        Thread.sleep(5000);
        contactPage = homePage.clickContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactLabelTest(){
        contactPage.verifyContactLabel();
    }

    @Test(priority = 2)
    public void verifyClickOnRandomCheckbox(){
        contactPage.clickRandomCheckBox();
    }


}
