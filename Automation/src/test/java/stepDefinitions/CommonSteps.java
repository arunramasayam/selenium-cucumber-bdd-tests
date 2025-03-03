package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.xalts.DriverManager;
import com.xalts.pages.Homepage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps {
    private WebDriver driver;

    private Homepage homepage;

    public CommonSteps(){
        DriverManager driverManager=new DriverManager();
        this.driver=driverManager.getDriver();
        this.homepage=new Homepage(driver);
    }

    @Given("I navigate to the {string}")
    public void iNavigateToThe(String url) {
        driver.get(url);
        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals(url, currentUrl, "Expected navigation to url");
    }

    @When("I click on the 'Sign In' button")
    public void iClickSignInButton() {
        Homepage homepage=new Homepage(driver);
        homepage.clickSignInBtn();
    }


    @When("I click on the 'Get Started' button")
    public void iClickGetStarrtedButton() {
        Homepage homepage=new Homepage(driver);
        homepage.clickGetStartedBtn();
    }

    @Then("I should be on the Sign In page")
    public void verifySignInPage(){
        String currentUrl=driver.getCurrentUrl();
        String signInUrl="https://xaltsocnportal.web.app/signin";
        Assert.assertEquals(signInUrl, currentUrl,"User is not in the Sign In page");

    }
}
