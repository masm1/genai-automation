package base;

import org.testng.annotations.*;
import utils.ConfigReader;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}