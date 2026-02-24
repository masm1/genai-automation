package pages;

import org.openqa.selenium.*;
import base.DriverFactory;

public class LoginPage {

    WebDriver driver = DriverFactory.getDriver();

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}