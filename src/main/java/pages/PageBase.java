package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

public abstract class PageBase {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
    }
    protected void type(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
        driver.findElement(locator).sendKeys(value);
    }
    protected void click(By locator) { wait.until(ExpectedConditions.elementToBeClickable(locator)).click(); }
    protected boolean isDisplayed(By locator) { return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed(); }
    protected String text(By locator) { return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText(); }
}
