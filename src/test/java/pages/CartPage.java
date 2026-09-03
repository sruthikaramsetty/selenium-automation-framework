package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class CartPage {

    WebDriver driver;
    WaitUtility waitutility;

    private By backpackItem =
            By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']");

    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
    	waitutility=new WaitUtility(driver);
        this.driver = driver;
    }

    public boolean isBackpackDisplayed() {
    	waitutility.waitForElementClickable(backpackItem);
        return driver.findElement(backpackItem).isDisplayed();
    }

    public void clickCheckout() {
    	waitutility.waitForElementClickable(checkoutButton);
        driver.findElement(checkoutButton).click();
    }
}