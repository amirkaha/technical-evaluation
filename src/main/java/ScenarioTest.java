import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

public class ScenarioTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();

    }

    @Test
    public void subscriptionPromptIsDisplayed() throws InterruptedException {
        new PolicyPage(driver)
                .loadPage().checkPromptExists().captureScreen();
    }

    @Test
    public void subscriptionPromptIsNotDisplayed() throws InterruptedException {
        new PolicyPage(driver)
                .scrollToBottom().clickButton().checkPromptDoesNotExist();
    }

    @AfterTest
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
