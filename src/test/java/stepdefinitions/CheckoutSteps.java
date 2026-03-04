package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutSteps {
    @Given("User has added product to cart")
    public void user_added_product() {
        new LoginPage().login("standard_user", "secret_sauce");
        new ProductsPage().addBackpackToCart();
        new ProductsPage().clickCart();
    }

    @When("User enters first name {string} last name {string} and postal code {string}")
    public void enter_checkout_info(String f, String l, String p) {
        new CartPage().clickCheckout();
        new CheckoutPage().enterCheckoutInfo(f, l, p);
    }

    @When("User completes checkout")
    public void complete_checkout() {
        new CheckoutPage().clickFinish();
    }

    @Then("Order confirmation message should be displayed")
    public void verify_success() {
        Assert.assertTrue(new CheckoutPage().isOrderSuccessful());
    }

    @Then("Error message should be shown")
    public void error_message_should_be_shown() {

        String errorMessage =
                DriverFactory.getDriver().findElement(By.cssSelector("[data-test='error']")).getText();

        Assert.assertTrue(errorMessage.contains("First Name is required"));
    }
}
