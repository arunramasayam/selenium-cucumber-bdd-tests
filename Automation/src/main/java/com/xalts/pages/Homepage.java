package com.xalts.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    WebDriver driver;
    WebDriverWait wait;

    public Homepage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public void clickGetStartedBtn() {
        WebElement getStartedBtn = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            getStartedBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Get Started']"))));
            getStartedBtn.click();
        } catch (TimeoutException e) {
            System.out.println("TimeoutException: Get Started button was not clickable within the wait time.");
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Get Started button not found on the page.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("ElementClickInterceptedException: Clicking via JavaScript as fallback.");

            // Check if element is visible before JavaScript click
            if (getStartedBtn.isDisplayed() && getStartedBtn.isEnabled()) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", getStartedBtn);
            } else {
                System.out.println("Element is not visible or enabled, cannot click.");
            }
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred while clicking the Get Started button. " + e.getMessage());
        }

    }

    public boolean isSignOutBtnVisible(){
        WebElement signOutBtn=null;
        try {
            signOutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Sign Out']")));
            return signOutBtn.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
        catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Sign Out button is not available on the page.");
            return false;
        } catch (Exception e) {  // Generic exception as a fallback
            System.out.println("Unexpected Exception: " + e.getMessage());
            return false;
        }

    }


    public void clickSignOutBtn(){
        WebElement signOutBtn=null;
        try {
            signOutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Sign Out']")));
            signOutBtn.click();
        }
        catch (TimeoutException e) {
            System.out.println("TimeoutException: Sign Out button was not clickable within the wait time.");
        }
        catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Sign Out button is not available on the page.");
        } catch (Exception e) {  // Generic exception as a fallback
            System.out.println("Unexpected Exception: " + e.getMessage());
        }

    }

    public boolean isSignInBtnVisible(){
        WebElement signInBtn=null;
        try {
            signInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Sign In']")));
            return signInBtn.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
        catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Sign In button is not available on the page.");
            return false;
        } catch (Exception e) {  // Generic exception as a fallback
            System.out.println("Unexpected Exception: " + e.getMessage());
            return false;
        }

    }
    public void clickSignInBtn(){
        WebElement signInBtn=null;
        try {
            signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Sign In']")));
            signInBtn.click();
        }
        catch (TimeoutException e) {
            System.out.println("TimeoutException: Sign In button was not clickable within the wait time.");
        }
        catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Sign In button is not available on the page.");
        } catch (Exception e) {  // Generic exception as a fallback
            System.out.println("Unexpected Exception: " + e.getMessage());
        }

    }

}
