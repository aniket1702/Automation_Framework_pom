package org.anytest.driver;

import org.anytest.driver.local.browser.ChromeDriverImpl;
import org.anytest.driver.local.browser.FirefoxDriverImpl;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) {

        WebDriver driver = null;
        if (browser.equalsIgnoreCase("chrome"))
        {
            return new ChromeDriverImpl().getDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            return new FirefoxDriverImpl().getDriver();
        }

        return driver;
    }
}
