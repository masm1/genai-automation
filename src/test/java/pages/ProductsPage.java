package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class ProductsPage {

    WebDriver driver = DriverFactory.getDriver();

    private By productTitle = By.className("title");
    private By backpackAddBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By backpackRemoveBtn = By.id("remove-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");
    private By sortDropdown = By.className("product_sort_container");
    private By firstProductPrice = By.className("inventory_item_price");
    private By removeBackpackBtn = By.id("remove-sauce-labs-backpack");

    public boolean isProductsPageDisplayed() {
        return WaitUtils.waitForElementVisible(productTitle).isDisplayed();
    }

    public void addBackpackToCart() {
        WaitUtils.waitForElementClickable(backpackAddBtn).click();
    }

    public boolean isBackpackRemoveButtonDisplayed() {
        return WaitUtils.waitForElementVisible(backpackRemoveBtn).isDisplayed();
    }

    public void removeBackpackFromCart() {
        WaitUtils.waitForElementClickable(backpackRemoveBtn).click();
    }

    public void clickCart() {
        WaitUtils.waitForElementClickable(cartIcon).click();
    }

    public void sortByValue(String value) {
        driver.findElement(sortDropdown).sendKeys(value);
    }

    public String getFirstProductPrice() {
        return WaitUtils.waitForElementVisible(firstProductPrice).getText();
    }

    public boolean isBackpackRemoveButtonPresent() {
        return driver.findElements(removeBackpackBtn).size() > 0;
    }
}