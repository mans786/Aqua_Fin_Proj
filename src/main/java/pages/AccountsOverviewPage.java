package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage extends PageBase {
    private final By pageHeading = By.cssSelector("#showOverview h1");
    private final By accountRows = By.cssSelector("#accountTable tbody tr");
    private final By logoutLink = By.linkText("Log Out");
    public AccountsOverviewPage(WebDriver driver) { super(driver); }
    public boolean isLoaded() { return isDisplayed(pageHeading); }
    public String getHeading() { return text(pageHeading); }
    public int getAccountCount() { return driver.findElements(accountRows).size(); }
    public LoginPage logout() { click(logoutLink); return new LoginPage(driver); }
}
