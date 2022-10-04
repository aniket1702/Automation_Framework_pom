package org.anytest.pages.menu_items;

import org.anytest.driver.DriverManager;
import org.anytest.pages.menu_items.enums.TopMenuListItem;
import org.openqa.selenium.By;

public class MenuComponents {
    private static final String MENU="//ul[@class='top-menu']/li/a";

    public MenuComponents clickMenu(TopMenuListItem topMenuListItem)
    {
        String xpath=String.format(MENU,topMenuListItem.getName());
        DriverManager.getDriver().findElement(By.xpath(xpath)).click();

        return this;
    }
}
