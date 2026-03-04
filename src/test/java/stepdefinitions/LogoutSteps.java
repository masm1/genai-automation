package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LogoutSteps {

    @When("User clicks logout")
    public void user_clicks_logout() {

        DriverFactory.getDriver().findElement(By.id("react-burger-menu-btn")).click();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
        //DriverFactory.getDriver().findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User should be redirected to login page")
    public void user_should_be_redirected_to_login_page() {

        Assert.assertTrue(
                DriverFactory.getDriver().getCurrentUrl().contains("saucedemo")
        );
    }
}