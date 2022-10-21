package org.anytest.pages;

import org.anytest.driver.DriverManager;
import org.anytest.logger.Framework_Logger;
import org.anytest.logger.enums.LogType;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class BooksPage {

    private static final By BOOKS_TITLE=By.xpath("//h2[@class='product-title']/a");


    public BooksPage getBooksTitle()
    {

       List<String> bookNames=new ArrayList<>();
       DriverManager
                .getDriver()
                .findElements(BOOKS_TITLE)
                .stream()
                .forEach(element->bookNames.add(element.getText()));

        Framework_Logger.log(LogType.INFO_EXTENT_AND_LOG,"Book Names :"+bookNames);
        return this;
    }
}
