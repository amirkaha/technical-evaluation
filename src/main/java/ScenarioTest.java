import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ScenarioTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void subscriptionPromptIsDisplayed() {
        new PolicyPage(driver)
                .loadPage().checkPromptExists().captureScreen("popupPresent");
    }

    @Test
    public void subscriptionPromptIsNotDisplayed() {
        new PolicyPage(driver)
                .scrollToBottom().checkPromptDoesNotExist().captureScreen("popupNotPresent");
    }

    @AfterTest
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
