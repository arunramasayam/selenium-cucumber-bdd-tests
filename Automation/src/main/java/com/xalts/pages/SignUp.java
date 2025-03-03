package com.xalts.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SignUp {
    WebDriver driver;
    WebDriverWait wait;

    public SignUp(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));;
    }

    public boolean enterConfirmPassword(String password){
        WebElement confirmPasswordFieldEle=null;
        try{
            confirmPasswordFieldEle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Confirm Password']/parent::div//input[@type='password']")));
            confirmPasswordFieldEle.clear();
            confirmPasswordFieldEle.sendKeys(password);
            try {
                WebElement errorElement = new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//p[contains(text(), 'Passwords do not match')]")));
                System.out.println("Passwords do not match error: " + errorElement.getText());
                return true;  // Error message found
            } catch (TimeoutException e) {
                return false; // No error message (passwords match)
            }
        }
        catch (TimeoutException e) {
            System.out.println("TimeoutException: Confirm Password field was not found within the wait time.");
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException:Confirm  Password field not found.");
        } catch (Exception e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
        }
        return false;
    }

    public void clickSignUpBtn(){
        WebElement signUpBtnEle=null;
        try{
            signUpBtnEle=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Sign Up']")));
            signUpBtnEle.click();
        }catch (TimeoutException e) {
            System.out.println("TimeoutException: SIGN UP button was not found within the wait time.");
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: SIGN UP button not found.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("ElementClickInterceptedException: SIGN UP button is not clickable at the moment.");
        } catch (Exception e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
        }
    }
    public boolean isSignUpBtnDisabled() {
        try {
            WebElement signUpButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[text()='Sign Up' and @disabled]")
            ));
            return !signUpButton.isEnabled(); // Should return true (disabled)
        } catch (TimeoutException e) {
            System.out.println("TimeoutException: Sign Up button not found.");
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Sign Up button not found.");
        } catch (Exception e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
        }
        return false; // If button is not found, assume it’s enabled (fail the test)
    }
    


}
