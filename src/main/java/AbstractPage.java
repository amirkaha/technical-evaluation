import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AbstractPage {
    private final static int TIMEOUT = 10;
    protected final WebDriver driver;
    private final WebDriverWait wait;

    public AbstractPage(WebDriver driver)  {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    public void get(String url) {
        driver.get(url);
    }

    public void waitFor(By by) {
        wait.until(visibilityOfElementLocated(by));
    }

    public void waitForPromptToDisappear(WebElement element) {
        wait.until(ExpectedConditions.attributeToBe(element, "data-testid", "SubscriptionPrompt-false"));
    }
}
