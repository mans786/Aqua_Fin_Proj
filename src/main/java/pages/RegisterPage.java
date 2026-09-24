package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends PageBase {
    private final By firstName = By.id("customer.firstName");
    private final By lastName = By.id("customer.lastName");
    private final By address = By.id("customer.address.street");
    private final By city = By.id("customer.address.city");
    private final By state = By.id("customer.address.state");
    private final By zipCode = By.id("customer.address.zipCode");
    private final By phone = By.id("customer.phoneNumber");
    private final By ssn = By.id("customer.ssn");
    private final By username = By.id("customer.username");
    private final By password = By.id("customer.password");
    private final By confirmPassword = By.id("repeatedPassword");
    private final By registerButton = By.cssSelector("input[value='Register']");
    public RegisterPage(WebDriver driver) { super(driver); }
    public RegisterPage enterCustomerDetails(String first, String last, String user, String pass) {
        type(firstName, first); type(lastName, last); type(address, "1 Banking Street"); type(city, "London");
        type(state, "LDN"); type(zipCode, "10001"); type(phone, "5551234567"); type(ssn, "123456789");
        type(username, user); type(password, pass); type(confirmPassword, pass); return this;
    }
    public void submitRegistration() { click(registerButton); }
}
