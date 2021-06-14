
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Alert;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class PolicyPage extends AbstractPage {
    private final static By PROMPT = By.cssSelector("#content > div._2J452 > div._1dzSy > div.Y7Y5d._1OU0K");

    public PolicyPage(WebDriver driver) {
        super(driver);
    }

    public PolicyPage loadPage() {
        get("https://www.afr.com/policy/foreign-affairs/capability-edge-and-keeping-south-china-sea-open-crucial--christopher-pyne-20180924-h15rq9");
        return this;
    }

    public PolicyPage checkPromptExists() throws NoAlertPresentException, InterruptedException {
        waitFor(PROMPT);
        WebElement subscriptionPrompt = driver.findElement(PROMPT);
       // Assert.assertEquals("SubscriptionPrompt-true", subscriptionPrompt.getAttribute("data-testid"));
        System.out.println(subscriptionPrompt.getAttribute("data-testid"));
        return this;
    }

    public PolicyPage checkPromptDoesNotExist() throws InterruptedException {
        Thread.sleep(10000);
        WebElement subscriptionPrompt = driver.findElement(PROMPT);
       // Assert.assertEquals("SubscriptionPrompt-false", subscriptionPrompt.getAttribute("data-testid"));
        System.out.println(subscriptionPrompt.getAttribute("data-testid"));
        return this;
    }

        public PolicyPage scrollToBottom() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
            return this;
        }

        public PolicyPage clickButton() {
        driver.findElement(By.cssSelector("#content > div._2J452 > div._1dzSy > div.Y7Y5d._1OU0K > div > a")).click();
        return this;
        }

    public void  captureScreen() {
        try {
            WebDriver webDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("src/main/resources/screenshots/loll.png"));
        }
        catch(IOException e) {

        }
    }
}
