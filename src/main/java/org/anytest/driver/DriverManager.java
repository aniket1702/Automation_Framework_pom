package org.anytest.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager
{
    private DriverManager()
    {

    }

    private static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER=new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        return THREAD_LOCAL_DRIVER.get();
    }

    public static void setDriver(WebDriver driver)
    {
        THREAD_LOCAL_DRIVER.set(driver);
    }

    public static void unload()
    {
        THREAD_LOCAL_DRIVER.remove();
    }

}
