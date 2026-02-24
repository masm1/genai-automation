package utils;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait getWait() {
        return new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(
                        Integer.parseInt(ConfigReader.getProperty("explicitWait"))
                )
        );
    }

    public static WebElement waitForElementVisible(By locator) {
        return getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public static WebElement waitForElementClickable(By locator) {
        return getWait().until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static void waitForUrlContains(String partialUrl) {
        getWait().until(
                ExpectedConditions.urlContains(partialUrl)
        );
    }

    public static void waitForTitleContains(String title) {
        getWait().until(
                ExpectedConditions.titleContains(title)
        );
    }
}