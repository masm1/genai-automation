package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CartPage {

    WebDriver driver = DriverFactory.getDriver();

    private By cartItem = By.className("inventory_item_name");
    private By checkoutBtn = By.id("checkout");

    public boolean isItemPresentInCart() {
        return WaitUtils.waitForElementVisible(cartItem).isDisplayed();
    }

    public void clickCheckout() {
        WaitUtils.waitForElementClickable(checkoutBtn).click();
    }
}