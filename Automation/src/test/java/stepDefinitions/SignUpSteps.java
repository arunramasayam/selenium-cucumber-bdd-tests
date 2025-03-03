package stepDefinitions;

import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.xalts.DriverManager;
import com.xalts.pages.CommonAuthPage;
import com.xalts.pages.CommonMethods;
import com.xalts.pages.Homepage;
import com.xalts.pages.SignUp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SignUpSteps {
    private WebDriver driver;
    private DriverManager driverManager;
    private SignUp signUp;
    private Homepage homepage;
    private CommonAuthPage commonAuthPage;
    private CommonMethods commonMethods;

    public SignUpSteps(){
        this.driverManager=new DriverManager();
        this.driver= driverManager.getDriver();
        this.homepage=new Homepage(driver);
        this.signUp=new SignUp(driver);
        this.commonAuthPage=new CommonAuthPage(driver);
        this.commonMethods=new CommonMethods(driver);
    }

    private String email;
    private String password;



    @And("I enter a valid email for sign up and a strong password")
    public void iEnterAValidEmailAndAStrongPassword() {
        email=generateRandomEmail();
        password=generateRandomPassword();
        System.out.println("...........New User Credentials...........");
        System.out.println("Email:"+email);
        System.out.println("Password:"+password);
        boolean isEmailInvalid=commonAuthPage.enterEmail(email);
        Assert.assertFalse(isEmailInvalid, "Email is invalid");
        boolean isErrorDisplayed=commonAuthPage.enterPassword(password);
        Assert.assertFalse(isErrorDisplayed, "Password strength doesn't meet the criteria");
    }

    // Method to generate a random valid email
    private String generateRandomEmail() {
        return "xalts" + new Random().nextInt(100000) + "@testmail.com";
    }

    // Method to generate a random strong valid password
    private String generateRandomPassword() {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 6); // First 6 characters from UUID
        String specialChar = "@";
        String upperCase = "A";
        String number = "1";
        return uuid + specialChar + upperCase + number; // Ensures all conditions are met
    }


    @And("I confirm the password correctly")
    public void iConfirmThePasswordCorrectly() {
        boolean isConfirmPasswdNotMatch=signUp.enterConfirmPassword(password);
        Assert.assertFalse(isConfirmPasswdNotMatch, "Expected confirm password to match, but didn't match" );
    }

    @And("I click on the Sign Up button")
    public void iClickOnTheSignUpButton() {
        signUp.clickSignUpBtn();
    }

    @Then("I should see the 'Sign Out' button")
    public void verifySignUp() {
        boolean isSignOutBtnDisplayed= homepage.isSignOutBtnVisible();
        Assert.assertTrue( isSignOutBtnDisplayed,"Sign Up failed!");
    }
    
    @And("^I enter an already registered (.*) for sign up and a strong (.*)$")
    public void iEnterExistingEmailSignUp(String emailId, String validPassword) {
    	email=emailId;
    	password=validPassword;
        boolean isEmailInvalid=commonAuthPage.enterEmail(emailId);
        Assert.assertFalse(isEmailInvalid, "Email is invalid");
        boolean isErrorDisplayed=commonAuthPage.enterPassword(password);
        Assert.assertFalse(isErrorDisplayed, "Password strength doesn't meet the criteria");
     }
    
    @Then("^I should see an (.*) error message$")
    public void iShouldSeeEmailAlreadyInUseError(String expectedEmailAlreadyInUseError) {
    	String errorAlertFound=commonMethods.getAlertText();
    	Assert.assertEquals(expectedEmailAlreadyInUseError, errorAlertFound, "Expected 'Provided E-Mail is already in use' "
    			+ "alert error message, but not found");
    }
    @And("^I enter an invalid (.*) or a weak (.*)$")
    public void iEnterInvalidEmailOrInvalidPasswd(String emailId, String passwd) {
    	password=passwd;
    	boolean isEmailInvalid=commonAuthPage.enterEmail(emailId);
    	boolean isPasswordInvalid=commonAuthPage.enterPassword(passwd);
    	Assert.assertTrue(isEmailInvalid || isPasswordInvalid, "Expected a invalid email or invalid password, but both are valid");
    	
    }
    @Then("the Sign Up button should remain disabled")
    public void iShouldSeeSignUpBtnDisabled() {
    	boolean isSignUpBtnDisabled=signUp.isSignUpBtnDisabled();
    	Assert.assertTrue(isSignUpBtnDisabled, "Expected SignUp button disabled, but found enabled");
    }
    
    @And("^I enter valid (.*) and (.*)$")
    public void iEnterValidEmailStrongPasssword(String email, String password) {
        boolean isEmailInvalid=commonAuthPage.enterEmail(email);
        Assert.assertFalse(isEmailInvalid, "Expected valid user email, but found invalid");
        boolean isPasswordInvalid= commonAuthPage.enterPassword(password);
        Assert.assertFalse(isPasswordInvalid, "Expected valid password but found invalid");
    }
    
    @And("^I enter a different (.*)$")
    public void iEnterDifferentConfirmPassword(String confirmPassword) {
        boolean isConfirmPasswdNotMatch=signUp.enterConfirmPassword(confirmPassword);
        Assert.assertTrue(isConfirmPasswdNotMatch, "Expected confirm password should not match" );
    	
    }
    
}
