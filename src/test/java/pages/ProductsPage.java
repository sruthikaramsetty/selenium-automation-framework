package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class ProductsPage {

    private WebDriver driver;
    WaitUtility waitutility;

    // Locators
    private By productsTitle = By.className("title");
    private By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private By shoppingCart = By.className("shopping_cart_link");
    private By cartIcon = By.className("shopping_cart_link");

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        waitutility = new WaitUtility(driver);
    }

    // Verify Products page
    public boolean isProductsPageDisplayed() {
        return driver.findElement(productsTitle).isDisplayed();
    }

    // Add Backpack to cart
    public void addBackpackToCart() {
    	waitutility.waitForElementClickable(backpack);
        driver.findElement(backpack).click();
    }

    // Open shopping cart
    public void clickShoppingCart() {
        driver.findElement(shoppingCart).click();
    }
    
    public void clickCart() {
    	waitutility.waitForElementClickable(cartIcon);
        driver.findElement(cartIcon).click();
    }
}