package com.xalts.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonAuthPage {
    WebDriver driver;
    WebDriverWait wait;

    public CommonAuthPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean enterEmail(String emailId){
        WebElement emailFieldEle=null;
        try{
            emailFieldEle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='E-Mail']/parent::div//input[@type='text']")));
            emailFieldEle.clear();
            emailFieldEle.sendKeys(emailId);
            String isEmailInvalid=emailFieldEle.getDomAttribute("aria-invalid");
            return "true".equals(isEmailInvalid);
        }
        catch (TimeoutException e) {
            System.out.println("TimeoutException: Email field was not found within the wait time.");
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Email field not found.");
        } catch (Exception e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
        }
        return false;
    }
    public boolean enterPassword(String password){
        WebElement passwordFieldEle=null;
        String errorMessage="";
        try {
            passwordFieldEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Password']/parent::div//input[@type='password']")));
            passwordFieldEle.clear();
            passwordFieldEle.sendKeys(password);
            try {
                WebElement errorElement = new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//p[contains(text(), 'Password must contain')]")));
                //System.out.println("Password validation error: " + errorElement.getText());
                return true;  // Error message found
            } catch (TimeoutException e) {
                return false; // No error message (valid password)
            }
        }
        catch (TimeoutException e) {
            System.out.println("TimeoutException: Password field was not found within the wait time.");
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Password field not found.");
        } catch (Exception e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
        }
        return false;
    }

}
