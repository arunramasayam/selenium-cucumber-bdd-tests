package com.xalts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {


    private static WebDriver driver;



    public WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }


    //Initalizing the chrome driver
    @SuppressWarnings("deprecation")
    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //Setting implicit wait time
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


    //Closing the driver
    public void quitDriver() {
        if(driver!=null) {
            driver.quit();
            driver=null;
        }
    }

}
