package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.cssSelector("input.button[value='Log In']");
    private final By errorMessage = By.cssSelector("#rightPanel .error");
    private final By registerLink = By.linkText("Register");

    public LoginPage(WebDriver driver) { super(driver); }
    public LoginPage enterUsername(String value) { type(username, value); return this; }
    public LoginPage enterPassword(String value) { type(password, value); return this; }
    public AccountsOverviewPage clickLogin() { click(loginButton); return new AccountsOverviewPage(driver); }
    public AccountsOverviewPage loginAs(String user, String pass) { return enterUsername(user).enterPassword(pass).clickLogin(); }
    public RegisterPage openRegistration() { click(registerLink); return new RegisterPage(driver); }
    public boolean isLoginErrorDisplayed() { return isDisplayed(errorMessage); }
    public String getLoginError() { return text(errorMessage); }
}
