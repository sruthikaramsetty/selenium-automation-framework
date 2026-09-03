package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void addBackpackToCart() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addBackpackToCart();

        productsPage.clickCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isBackpackDisplayed());
    }
}