package com.xalts.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignIn {
    WebDriver driver;
    WebDriverWait wait;

    public SignIn(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));;
    }

    public void clickAlreadyHaveAccountBtn(){
        WebElement alreadyHaveAccountBtnEle=null;
        try {
            alreadyHaveAccountBtnEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Already have an account? Click here to sign in.']")));
            alreadyHaveAccountBtnEle.click();
        }
        catch (TimeoutException e) {
            System.out.println("TimeoutException: Already have an account button was not clickable within the wait time.");
        }
        catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Already have an account button is not available on the page.");
        } catch (Exception e) {  // Generic exception as a fallback
            System.out.println("Unexpected Exception: " + e.getMessage());
        }

    }

    public boolean isSignBtnDisabled(){
        try {
            WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[text()='Sign In' and @disabled]")
            ));
            return !signInButton.isEnabled();
        }
        catch (TimeoutException e) {
            System.out.println("TimeoutException: Sign In button not found within the wait time.");
        }
        catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Sign In button not found on the page.");
        }
        catch (Exception e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
        }
        return false;
    }



}
