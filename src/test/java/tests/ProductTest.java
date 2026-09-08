package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.ProductsPage;

public class ProductTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Create Products page object
        ProductsPage productsPage = new ProductsPage(driver);

        // Verify Products page
        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page is not displayed"
        );

        // Add Backpack to cart
        productsPage.addBackpackToCart();

        // Open cart
        productsPage.clickShoppingCart();
        
        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isBackpackDisplayed());

        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.enterFirstName("Sruthi");
        checkoutPage.enterLastName("Test");
        checkoutPage.enterPostalCode("500001");

        checkoutPage.clickContinue();
    
    
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);

        Assert.assertTrue(overviewPage.isBackpackDisplayed());

        String itemPrice = overviewPage.getItemPrice();

        System.out.println("Item Price: " + itemPrice);

        Assert.assertEquals(itemPrice, "$29.99");

        String totalPrice = overviewPage.getTotalPrice();

        System.out.println("Total Price: " + totalPrice);

        Assert.assertEquals(totalPrice, "Total: $32.39");

        overviewPage.clickFinish();

        OrderConfirmationPage confirmationPage = new OrderConfirmationPage(driver);

        Assert.assertTrue(
                confirmationPage.isOrderConfirmed(),
                "Order confirmation is not displayed"
        );
    }
}