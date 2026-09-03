package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class CheckoutPage {

    WebDriver driver;
    WaitUtility waitUtility;

    // Locators
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    // Constructor
    public CheckoutPage(WebDriver driver) {
    	waitUtility = new WaitUtility(driver);
        this.driver = driver;
    }

    // Actions
    public void enterFirstName(String name) {

        waitUtility.waitForElementVisible(firstName);

        driver.findElement(firstName).sendKeys(name);
    }

    public void enterLastName(String name) {

        waitUtility.waitForElementVisible(lastName);

        driver.findElement(lastName).sendKeys(name);
    }

    public void enterPostalCode(String code) {

        waitUtility.waitForElementVisible(postalCode);

        driver.findElement(postalCode).sendKeys(code);
    }

    public void clickContinue() {

        waitUtility.waitForElementClickable(continueButton);

        driver.findElement(continueButton).click();
    }
}