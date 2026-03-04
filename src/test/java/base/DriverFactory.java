package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {

        boolean isGrid = ConfigReader.getProperty("grid").equalsIgnoreCase("true");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

// 🔥 Force new clean profile every run
            options.addArguments("--incognito");

// Disable password manager
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);

            options.setExperimentalOption("prefs", prefs);

// Remove automation infobar
            options.setExperimentalOption("excludeSwitches",
                    Arrays.asList("enable-automation"));

            options.setExperimentalOption("useAutomationExtension", false);

            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--start-maximized");

            if (isGrid) {
                try {
                    driver.set(new RemoteWebDriver(
                            new URL(ConfigReader.getProperty("gridUrl")),
                            options
                    ));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(options));
            }

        }
        else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();

            if (isGrid) {
                try {
                    driver.set(new RemoteWebDriver(
                            new URL(ConfigReader.getProperty("gridUrl")),
                            options
                    ));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver(options));
            }
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}