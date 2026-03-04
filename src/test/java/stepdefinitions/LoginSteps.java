package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("User is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @When("User enters username {string} and password {string}")
    public void enter_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User should land on products page")
    public void verify_products_page() {
        Assert.assertTrue(new ProductsPage().isProductsPageDisplayed());
    }

    @Then("Error message should be displayed")
    public void verify_error_message() {
        Assert.assertTrue(
                DriverFactory.getDriver().getPageSource()
                        .contains("Username and password")
        );
    }
}