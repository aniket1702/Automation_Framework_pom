package org.anytest.driver;

import org.anytest.utils.config.ConfigFactory;

import java.util.Objects;

public final class Driver {

    private Driver()
    {

    }

    public static void intiDriver()  {
        if(Objects.isNull(DriverManager.getDriver()))
        {
            DriverManager.setDriver(DriverFactory.getDriver(ConfigFactory.getConfig().browser()));
            DriverManager.getDriver().manage().window().maximize();
            loadURL();
        }
    }

    private static void loadURL()
    {
        DriverManager.getDriver().get(ConfigFactory.getConfig().baseURL());
    }

    public static void quitBrowser()
    {
        if(Objects.nonNull(DriverManager.getDriver()))
        {
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().close();
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
