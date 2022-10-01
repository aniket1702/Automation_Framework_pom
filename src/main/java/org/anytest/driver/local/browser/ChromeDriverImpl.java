package org.anytest.driver.local.browser;

import org.anytest.driver.local.IWebDriver;
import org.openqa.selenium.WebDriver;

public class ChromeDriverImpl implements IWebDriver {
    @Override
    public WebDriver getDriver() {
        return ChromeManager.getDriver();
    }
}
