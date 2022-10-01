package org.anytest.base;

import org.anytest.driver.Driver;
import org.anytest.logger.Framework_Logger;
import org.anytest.logger.enums.LogType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BaseTest {
    protected BaseTest(){};


    @BeforeMethod
    public void setup()
    {
        Driver.intiDriver();
        Framework_Logger.log(LogType.PASS,"Driver Initialized");
    }

    @AfterMethod
    public void tearDown()
    {
        Driver.quitBrowser();
        Framework_Logger.log(LogType.PASS,"Driver Closed");
    }

}
