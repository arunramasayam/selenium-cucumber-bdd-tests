package stepDefinitions;

import com.xalts.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;
    private static DriverManager driverManager;

    @Before
    public void setUp() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        driver = driverManager.getDriver();  // Shared WebDriver instance
    }

    @After
    public void tearDown() {
        driverManager.quitDriver();  // Quit driver only once after all tests
    }
}
