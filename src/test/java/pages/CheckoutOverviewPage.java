package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class CheckoutOverviewPage {

    WebDriver driver;
    WaitUtility waitUtility;

    // Locators
    private By backpackItem =
            By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']");

    private By itemPrice =
            By.className("inventory_item_price");

    private By totalPrice =
            By.className("summary_total_label");

    private By finishButton =
            By.id("finish");

    // Constructor
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        waitUtility=new WaitUtility(driver);
    }

    // Validations
    public boolean isBackpackDisplayed() {

        waitUtility.waitForElementVisible(backpackItem);

        return driver.findElement(backpackItem).isDisplayed();
    }

    public String getItemPrice() {

        waitUtility.waitForElementVisible(itemPrice);

        return driver.findElement(itemPrice).getText();
    }

    public String getTotalPrice() {

        waitUtility.waitForElementVisible(totalPrice);

        return driver.findElement(totalPrice).getText();
    }

    public void clickFinish() {

        waitUtility.waitForElementClickable(finishButton);

        driver.findElement(finishButton).click();
    }
}