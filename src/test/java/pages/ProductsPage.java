package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class ProductsPage {

    WebDriver driver = DriverFactory.getDriver();

    // Locators
    private By productTitle = By.className("title");
    private By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    // Validate Products Page Loaded
    public boolean isProductsPageDisplayed() {
        return WaitUtils.waitForElementVisible(productTitle).isDisplayed();
    }

    // Add Backpack to Cart
    public void addBackpackToCart() {
        WaitUtils.waitForElementClickable(addToCartBackpack).click();
    }

    // Click Cart Icon
    public void clickCart() {
        WaitUtils.waitForElementClickable(cartIcon).click();
    }

    // Logout
    public void logout() {
        WaitUtils.waitForElementClickable(menuButton).click();
        WaitUtils.waitForElementClickable(logoutLink).click();
    }
}