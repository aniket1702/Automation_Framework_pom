package org.anytest.test.pages;

import org.anytest.base.BaseTest;
import org.anytest.driver.DriverManager;
import org.anytest.logger.Framework_Logger;
import org.anytest.logger.enums.LogType;
import org.anytest.utils.config.ConfigFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    private static final By login_link=By.xpath("//a[@class='ico-login']");
    private static final By email=By.xpath("//input[@class='email']");
    private static final By password=By.xpath("//input[@class='password']");
    private static final By login_button=By.xpath("//input[@value='Log in']");

    @Test
    public  void testLogin()
    {
        DriverManager.getDriver().findElement(login_link).click();
        Framework_Logger.log(LogType.PASS,"Login Link is clicked");

        DriverManager.getDriver().findElement(email).sendKeys(ConfigFactory.getConfig().username());
        Framework_Logger.log(LogType.PASS,"Username : "+ConfigFactory.getConfig().username()+" is entered.");

        DriverManager.getDriver().findElement(password).sendKeys(ConfigFactory.getConfig().password());
        Framework_Logger.log(LogType.PASS,"Password: "+ConfigFactory.getConfig().password()+" is entered");

        DriverManager.getDriver().findElement(login_button).click();
        Framework_Logger.log(LogType.PASS,"Login Button is clicked");
    }



}
