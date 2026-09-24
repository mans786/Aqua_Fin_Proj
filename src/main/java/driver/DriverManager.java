package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.Constants;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private DriverManager() { }
    public static void createDriver(String browser) {
        String selected = browser == null || browser.isBlank() ? Constants.getBrowser() : browser.toUpperCase();
        WebDriver driver;
        if (selected.equals("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            if (Boolean.parseBoolean(Constants.getProperty("Headless"))) options.addArguments("-headless");
            driver = new FirefoxDriver(options);
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(Constants.getProperty("Headless"))) options.addArguments("--headless=new");
            options.addArguments("--window-size=1440,1000", "--disable-dev-shm-usage", "--no-sandbox");
            driver = new ChromeDriver(options);
        }
        DRIVER.set(driver);
    }
    public static WebDriver getDriver() { return DRIVER.get(); }
    public static void quitDriver() { if (DRIVER.get() != null) { DRIVER.get().quit(); DRIVER.remove(); } }
}
