package com.qa.cifAdminPages;

import com.qa.testBase.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ContactPage extends TestBaseClass {

    @FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]/span")
    WebElement contactLabel;

    @FindBy(xpath = "//button[contains(text(),'Show Filters')]")
    WebElement showFilter;


    public ContactPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public void verifyContactLabel(){
        Actions action = new Actions(driver);
        action.moveToElement(showFilter).build().perform();
        //showFilter.click();
        Assert.assertTrue(contactLabel.isDisplayed(), "PASSED");
    }

    public void clickRandomCheckBox(){
        Random rand = new Random();
        List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='ui fitted read-only checkbox']"));
        System.out.println("Checkbox size is " + checkbox.size());
        int randomIndex = rand.nextInt(checkbox.size());
        checkbox.get(randomIndex).click();
        System.out.println("u");

    }
}
