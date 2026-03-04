package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductsPage;

public class CartSteps {
    @When("User clicks on cart icon")
    public void click_cart() {
        new ProductsPage().clickCart();
    }

    @Then("Product should be visible in cart")
    public void verify_cart_item() {
        Assert.assertTrue(new CartPage().isItemPresentInCart());
    }
}
