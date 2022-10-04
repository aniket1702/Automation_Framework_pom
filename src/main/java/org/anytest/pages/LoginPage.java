package org.anytest.pages;

import org.anytest.driver.DriverManager;
import org.anytest.logger.Framework_Logger;
import org.anytest.logger.enums.LogType;
import org.anytest.utils.config.ConfigFactory;
import org.openqa.selenium.By;

public class LoginPage {
    private static final By login_link=By.xpath("//a[@class='ico-login']");
    private static final By email=By.xpath("//input[@class='email']");
    private static final By password=By.xpath("//input[@class='password']");
    private static final By login_button=By.xpath("//input[@value='Log in']");

    public LoginPage clickLoginLink()
    {
         DriverManager.getDriver().findElement(login_link).click();
        Framework_Logger.log(LogType.INFO_EXTENT_AND_LOG,"Login Link is clicked");
        return this;
    }
    public LoginPage setUsername(String username)
    {
        DriverManager.getDriver().findElement(email).sendKeys(username);
        Framework_Logger.log(LogType.INFO_EXTENT_AND_LOG,"Username : "+ConfigFactory.getConfig().username()+" is entered.");
        return this;
    }
    public LoginPage setPassword(String pswd)
    {
        DriverManager.getDriver().findElement(password).sendKeys(pswd);
        Framework_Logger.log(LogType.INFO_EXTENT_AND_LOG,"Password: "+ConfigFactory.getConfig().password()+" is entered");
        return this;
    }
    public HomePage clickLoginButton()
    {
        DriverManager.getDriver().findElement(login_button).click();
        Framework_Logger.log(LogType.INFO_EXTENT_AND_LOG,"Login Button is clicked");
        return new HomePage();
    }
}
