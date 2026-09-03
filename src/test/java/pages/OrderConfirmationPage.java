package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class OrderConfirmationPage {

    WebDriver driver;
    WaitUtility waitUtility;

    // Locator
    private By confirmationMessage =By.className("complete-header");
    private By goBackHome = By.id("back-to-products");

    // Constructor
    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        waitUtility=new WaitUtility(driver);
    }

    // Validation
    public String getConfirmationMessage() {

        waitUtility.waitForElementVisible(confirmationMessage);

        return driver.findElement(confirmationMessage).getText();
    }

    public void clickBackHome() {

        waitUtility.waitForElementClickable(goBackHome);

        driver.findElement(goBackHome).click();
    }
}