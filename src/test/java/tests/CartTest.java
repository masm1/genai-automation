package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;
import utils.RetryAnalyzer;

public class CartTest {
    @Test
            (retryAnalyzer = RetryAnalyzer.class)
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
    }}
