package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        if(ConfigReader.getProperty("grid").equals("true")) {

            try {
                driver.set(new RemoteWebDriver(
                        new URL(ConfigReader.getProperty("gridUrl")),
                        new ChromeOptions()
                ));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else {

            if(browser.equalsIgnoreCase("chrome")) {
                driver.set(new ChromeDriver());
            }
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}