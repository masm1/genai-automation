package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutPage {

    WebDriver driver = DriverFactory.getDriver();

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By successMsg = By.className("complete-header");

    public void enterCheckoutInfo(String fName, String lName, String zip) {
        WaitUtils.waitForElementVisible(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }

    public void clickFinish() {
        WaitUtils.waitForElementClickable(finishBtn).click();
    }

    public boolean isOrderSuccessful() {
        return WaitUtils.waitForElementVisible(successMsg).isDisplayed();
    }
}