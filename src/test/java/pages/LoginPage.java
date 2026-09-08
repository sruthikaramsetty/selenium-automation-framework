package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class LoginPage {

    private WebDriver driver;
    private WaitUtility waitUtility;

    // Locators
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitUtility = new WaitUtility(driver);
    }

    // Enter username
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    // Enter password
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    // Click login
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Complete login
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    // Get error message
    public String getErrorMessage() {

        waitUtility.waitForElementVisible(errorMessage);

        return driver.findElement(errorMessage).getText();
    }
} 