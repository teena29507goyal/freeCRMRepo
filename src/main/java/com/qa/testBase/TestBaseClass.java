package com.qa.testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class TestBaseClass {


     public static Properties prop;
     public static WebDriver driver;

    public TestBaseClass() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("src/main/java/com/qa/config/config.properties");
        try {
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Initilization(){
        String browserName = prop.getProperty("browser");
        System.out.println("my browser is  " + browserName);

        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.navigate().to(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }




}
