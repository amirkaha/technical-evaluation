import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;

public class PolicyPage extends AbstractPage {
    private final static By PROMPT = By.xpath("//*[@id=\"content\"]/div[4]/div[2]/div[1]");

    public PolicyPage(WebDriver driver) {
        super(driver);
    }

    public PolicyPage loadPage() {
        get("https://www.afr.com/policy/foreign-affairs/capability-edge-and-keeping-south-china-sea-open-crucial--christopher-pyne-20180924-h15rq9");
        return this;
    }

    public PolicyPage checkPromptExists() {
        waitFor(PROMPT);
        WebElement subscriptionPrompt = driver.findElement(PROMPT);
        Assert.assertEquals("SubscriptionPrompt-true", subscriptionPrompt.getAttribute("data-testid"));
        return this;
    }

    public PolicyPage checkPromptDoesNotExist() {
        WebElement subscriptionPrompt = driver.findElement(PROMPT);
        waitForPromptToDisappear(subscriptionPrompt);
        Assert.assertEquals("SubscriptionPrompt-false", subscriptionPrompt.getAttribute("data-testid"));
        return this;
    }

    public PolicyPage scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        return this;
    }

    public void captureScreen(String fileName) {
        try {
            WebDriver webDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("src/main/resources/screenshots/" + fileName + ".png"));
        }
        catch(IOException e) {
        }
    }
}
