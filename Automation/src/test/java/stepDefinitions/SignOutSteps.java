package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.xalts.DriverManager;
import com.xalts.pages.Homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignOutSteps {
    private WebDriver driver;
    private Homepage homepage;

    public SignOutSteps(){
        DriverManager driverManager=new DriverManager();
        this.driver=driverManager.getDriver();
        this.homepage=new Homepage(driver);
    }


    @When("I click on the 'Sign Out' button")
    public void signOut(){
        homepage.clickSignOutBtn();
    }

    @Then("^I should be redirected to (.*)$")
     public void redirectHomepage(String url){
        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals( url, currentUrl,"Sign Out Failed!");
    }

    @And("I should see the 'Sign In' button")
    public void iShouldSeeTheSignInButton() {
        boolean isSignInBtnVisible= homepage.isSignInBtnVisible();
        Assert.assertTrue(isSignInBtnVisible,"Sign Out failed!");

    }
}
