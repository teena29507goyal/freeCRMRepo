package com.qa.cifAdminTest;

import com.qa.cifAdminPages.HomePage;
import com.qa.cifAdminPages.loginPage;
import com.qa.testBase.TestBaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginPageTest extends TestBaseClass {

    loginPage login;
    HomePage homePage;

    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeSuite
    public void setUp() throws IOException {
        Initilization();
        login = new loginPage();
    }

    @Test(priority = 1)
    public void validateLogo() throws InterruptedException {
        Thread.sleep(3000);
        boolean flag = login.pageLogoValidate();
        Assert.assertTrue(flag, "PASSED");
        System.out.println("validateLogo PASSED");
    }

    @Test(priority = 2)
    public void validateLogin() throws IOException {
        homePage = login.login(prop.getProperty("userName"), prop.getProperty("password"));
        String title = driver.getTitle();
        Assert.assertEquals(title, "Cogmento CRM", "PASSED");
        System.out.println("validateLogin PASSED");
    }

//    @AfterSuite
//    public void tearDown(){
//        driver.quit();
//    }
}
