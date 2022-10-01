package org.anytest.test.pages;

import org.anytest.base.BaseTest;
import org.anytest.pages.LoginPage;
import org.anytest.utils.config.ConfigFactory;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {


    @Test
    public  void testLogin()
    {
        new LoginPage()
                .clickLoginLink()
                .setUsername(ConfigFactory.getConfig().username())
                .setPassword(ConfigFactory.getConfig().password())
                .clickLoginButton();
    }
}
