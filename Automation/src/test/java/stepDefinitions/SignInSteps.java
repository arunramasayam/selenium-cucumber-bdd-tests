package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.xalts.DriverManager;
import com.xalts.pages.CommonAuthPage;
import com.xalts.pages.CommonMethods;
import com.xalts.pages.Homepage;
import com.xalts.pages.SignIn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps {
    private WebDriver driver;
    private SignIn signIn;
    private DriverManager driverManager;
    private Homepage homepage;
    private CommonAuthPage commonAuthPage;
    private CommonMethods commonMethods;

    public SignInSteps(){
        this.driverManager=new DriverManager();
        this.driver=driverManager.getDriver();
        this.signIn=new SignIn(driver);
        this.homepage=new Homepage(driver);
        this.commonAuthPage=new CommonAuthPage(driver);
        this.commonMethods=new CommonMethods(driver);
    }
    @And("I click on 'Already have an account? click here to join' button")
    public void iClickOnAlreadyHaveAnAccountClickHereToJoinButton() {
        signIn.clickAlreadyHaveAccountBtn();
    }

    @Then("I should see Sign In form")
    public void iShouldBeSeeSignInForm() {
        boolean isSignInBtnDisplayed=homepage.isSignInBtnVisible();
        Assert.assertTrue(isSignInBtnDisplayed,"Redirecting to Sign In form failed");

    }


    @When("^I enter my registered (.*) for sign in and correct (.*)$")
    public void iEnterMyRegisteredEmailForSignInAndCorrectPassword(String emailId, String passwd) {
        boolean isEmailInvalid=commonAuthPage.enterEmail(emailId);
        Assert.assertFalse(isEmailInvalid, "Email is invalid");
        boolean isErrorDisplayed=commonAuthPage.enterPassword(passwd);
        Assert.assertFalse(isErrorDisplayed,"Password strength doesn't meet the criteria");
    }

    @And("I submit the Sign In form")
    public void iSubmitTheSignInForm() {
        homepage.clickSignInBtn();
    }
    
    @Then("^I should see homepage (.*)$")
    public void redirectHomepageUrl(String url){
    	new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(url));
    	String currentUrl=driver.getCurrentUrl();
    	Assert.assertEquals(url, currentUrl,"Sign In failed" );
    }

    @When("^I enter an invalid email (.*) or an invalid password (.*)")
    public void iEnterAnInvalidEmailOrAnInvalidPassword(String invalidEmail, String invalidPasswd) {
        boolean isEmailInvalid=commonAuthPage.enterEmail(invalidEmail);
        boolean isPasswordInvalid=commonAuthPage.enterPassword(invalidPasswd);
        Assert.assertTrue(isEmailInvalid || isPasswordInvalid, "Expected either invalid email or password, but both were valid");
    }

    @Then("the Sign In button should remain disabled")
    public void theSignInButtonShouldRemainDisabled() {
        boolean isSignBtnDisabled=signIn.isSignBtnDisabled();
        Assert.assertTrue(isSignBtnDisabled, "Expected Sign In button disabled, but it is enabled");
    }



    @Then("^I should see a (.*) alert message$")
    public void iShouldSeeAUserNotFoundAlertMessage(String expectedUserNotFoundError) {
        String alertText= commonMethods.getAlertText();
        Assert.assertEquals(expectedUserNotFoundError, alertText, "Expected alert error 'User Not Found but not found");

    }


    @When("^I enter a non-existing (.*) and correct (.*)$")
    public void iEnterANonExistingEmailCorrectPasswd(String nonExistingEmail, String correctPassword) {
        boolean isEmailInvalid=commonAuthPage.enterEmail(nonExistingEmail);
        Assert.assertFalse(isEmailInvalid, "Expected valid non existing user email, but found invalid");
        boolean isPasswordInvalid= commonAuthPage.enterPassword(correctPassword);
        Assert.assertFalse(isPasswordInvalid, "Expected valid password but found invalid");
    }
    
    @When("^I enter an existing (.*) and wrong valid (.*)$")
    public void iEnterWrongPasswd(String emaild, String wrongPasswd) {
    	boolean isEmailInvalid=commonAuthPage.enterEmail(emaild);
    	Assert.assertFalse(isEmailInvalid, "Expected existing user email, but found invalid");
        boolean isPasswordInvalid= commonAuthPage.enterPassword(wrongPasswd);
        Assert.assertFalse(isPasswordInvalid, "Expected valid wrong password but found invalid");
    	
    }
    
    @Then("^I should see an (.*) alert message$")
    public void iShouldSeeIncorrectEmailPasswordAlertMsg(String expectedIncorrectEmailPasswordError) {
    	String alertMsgFound=commonMethods.getAlertText();
    	Assert.assertEquals(expectedIncorrectEmailPasswordError, alertMsgFound, "Expected alert error 'Incorrect E-Mail or Password', but not found");
    }
    
  
}
