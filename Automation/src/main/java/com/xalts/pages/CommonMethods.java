package com.xalts.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonMethods {
	WebDriver driver;
    WebDriverWait wait;

    public CommonMethods(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getAlertText(){
    	
        String alertText="";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alertText = alert.getText();
            alert.accept();
        }
        catch (TimeoutException e) {
            System.out.println(" Timeout: No 'User not found' alert appeared.");
        }
        catch (NoAlertPresentException e) {
            System.out.println("No alert found on the page.");
        }
        catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        return alertText;

    }

}
