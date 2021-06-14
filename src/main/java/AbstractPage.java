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

    public void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void waitFor(By by) {
        wait.until(visibilityOfElementLocated(by));
    }

    public void clickOn(By by) {
        driver.findElement(by).click();
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public  boolean isClickable(WebElement webe)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(webe));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

}
