package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;
import utils.RetryAnalyzer;

public class CartTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addToCartTest() {

        LoginPage login = new LoginPage();
        login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        ProductsPage products = new ProductsPage();

        Assert.assertTrue(products.isProductsPageDisplayed());

        products.addBackpackToCart();
        products.clickCart();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void removeFromCartTest() {

        LoginPage login = new LoginPage();
        login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        ProductsPage products = new ProductsPage();

        Assert.assertTrue(products.isProductsPageDisplayed(),
                "Products page not displayed after login");

        products.addBackpackToCart();

        // Ensure remove button is visible before removing
        Assert.assertTrue(products.isBackpackRemoveButtonDisplayed(),
                "Remove button not visible after adding product");

        products.removeBackpackFromCart();

        // Now verify remove button is gone
        Assert.assertFalse(products.isBackpackRemoveButtonPresent(),
                "Remove button still visible after removing product");
    }
}