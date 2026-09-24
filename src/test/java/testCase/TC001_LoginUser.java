package testCase;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountsOverviewPage;
import pages.LoginPage;
import utils.Constants;

public class TC001_LoginUser extends TestBase {
    @Test(priority = 1, groups = {"smoke", "regression"}, description = "TC-LOGIN-001 - Login with valid credentials")
    public void verifyValidLogin() {
        AccountsOverviewPage accounts = new LoginPage(driver).loginAs(Constants.getUsername(), Constants.getPassword());
        Assert.assertTrue(accounts.isLoaded(), "Accounts Overview page should be displayed");
        Assert.assertTrue(accounts.getAccountCount() > 0, "At least one account should be displayed");
    }

    @Test(priority = 2, groups = {"regression"}, description = "TC-LOGIN-002 - Login with invalid password")
    public void verifyInvalidPasswordLogin() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername(Constants.getUsername()).enterPassword("invalid-password");
        driver.findElement(By.cssSelector("input.button[value='Log In']")).click();
        Assert.assertTrue(login.isLoginErrorDisplayed(), "Login error should be displayed");
    }

    @Test(priority = 3, groups = {"regression"}, description = "TC-LOGIN-003 - Login with invalid username")
    public void verifyInvalidUsernameLogin() {
        LoginPage login = new LoginPage(driver).loginAs("invalid-user-" + System.currentTimeMillis(), Constants.getPassword());
        Assert.assertTrue(new LoginPage(driver).isLoginErrorDisplayed(), "Invalid username error should be displayed");
    }

    @Test(priority = 4, groups = {"regression"}, description = "TC-LOGIN-004 - Login with blank credentials")
    public void verifyBlankLoginFields() {
        driver.findElement(By.cssSelector("input.button[value='Log In']")).click();
        Assert.assertTrue(new LoginPage(driver).isLoginErrorDisplayed(), "Blank login error should be displayed");
    }

    @Test(priority = 5, groups = {"smoke", "regression"}, description = "TC-LOGOUT-001 - Logout from customer account")
    public void verifySuccessfulLogout() {
        AccountsOverviewPage accounts = new LoginPage(driver).loginAs(Constants.getUsername(), Constants.getPassword());
        LoginPage login = accounts.logout();
        Assert.assertTrue(login.isLoginErrorDisplayed() || driver.getCurrentUrl().contains("index"), "User should return to login page");
    }
}
