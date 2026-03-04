package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class ProductSteps {

    @Given("User is logged in")
    public void user_logged_in() {
        new LoginPage().login("standard_user", "secret_sauce");
    }

    @Then("Products page title should be displayed")
    public void verify_products_title() {
        Assert.assertTrue(new ProductsPage().isProductsPageDisplayed());
    }

    @When("User adds backpack to cart")
    public void add_backpack() {
        new ProductsPage().addBackpackToCart();
    }

    @When("User removes backpack from cart")
    public void remove_backpack() {
        new ProductsPage().removeBackpackFromCart();
    }

    @Then("Remove button should be displayed")
    public void verify_remove_button() {
        Assert.assertTrue(new ProductsPage().isBackpackRemoveButtonDisplayed());
    }

    @Then("Remove button should not be displayed")
    public void verify_remove_button_not_present() {
        Assert.assertFalse(new ProductsPage().isBackpackRemoveButtonDisplayed());
    }

    @When("User sorts products by {string}")
    public void sort_products(String value) {
        new ProductsPage().sortByValue(value);
    }

    @Then("First product price should be lowest")
    public void first_product_price_should_be_lowest() {

        List<WebElement> prices =
                DriverFactory.getDriver().findElements(By.className("inventory_item_price"));

        double firstPrice = Double.parseDouble(prices.get(0).getText().replace("$", ""));
        double secondPrice = Double.parseDouble(prices.get(1).getText().replace("$", ""));

        Assert.assertTrue(firstPrice <= secondPrice);
    }
}
