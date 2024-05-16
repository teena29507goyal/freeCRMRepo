package com.qa.cifAdminTest;

import com.qa.cifAdminPages.ContactPage;
import com.qa.cifAdminPages.DealPage;
import com.qa.cifAdminPages.HomePage;
import com.qa.cifAdminPages.loginPage;
import com.qa.testBase.TestBaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBaseClass {

    HomePage homePage;
    loginPage loginPage;
    ContactPage contactPage ;
    DealPage dealPage;

    public HomePageTest() throws IOException {
        super();
    }


    @BeforeSuite
    public void setUp() throws IOException {
        Initilization();
        loginPage = new loginPage();
        homePage = new HomePage();
        contactPage = new ContactPage();
        loginPage.pageLogoValidate();
        loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void validateTitleTest() throws InterruptedException {
        Thread.sleep(2000);
        String pageTitle = homePage.validateTitle();
        Assert.assertEquals(pageTitle, "Paytm");
        System.out.println("validateTitleTest PASSED");
    }

    @Test(priority = 2)
    public void verifyUserName() {
        Assert.assertTrue(homePage.verifyUserName());
        System.out.println("UserName Teena Goyal is Displayed");
    }

    @Test(priority = 3)
    public void clickContactLink() throws IOException {
        contactPage = homePage.clickContactsLink();

    }

    @Test(priority = 4)
   public void verifyDealPage() throws IOException {
        dealPage = homePage.clickDealLink();
    }
}