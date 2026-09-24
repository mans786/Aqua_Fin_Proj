package base;

import driver.DriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Constants;
import utils.ScreenshotUtil;

public abstract class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void launchApplication(@Optional("") String browser) {
        DriverManager.createDriver(browser);
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        driver.get(Constants.getApplicationUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void closeApplication(ITestResult result) {
        if (!result.isSuccess() && driver != null) ScreenshotUtil.capture(driver, result.getName());
        DriverManager.quitDriver();
    }
}
