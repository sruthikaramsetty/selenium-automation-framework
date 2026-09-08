package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login failed"
        );
    }

    @Test
    public void invalidUsernameTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrong_user", "secret_sauce");

        Assert.assertTrue(
                loginPage.getErrorMessage().contains(
                        "Username and password do not match"
                )
        );
    }

    @Test
    public void invalidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(
                loginPage.getErrorMessage().contains(
                        "Username and password do not match"
                )
        );
    }

    @Test
    public void emptyUsernameTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "secret_sauce");

        Assert.assertTrue(
                loginPage.getErrorMessage().contains(
                        "Username is required"
                )
        );
    }

    @Test
    public void emptyPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "");

        Assert.assertTrue(
                loginPage.getErrorMessage().contains(
                        "Password is required"
                )
        );
    }
}