package org.anytest.pages;

import org.anytest.pages.menu_items.MenuComponents;
import org.anytest.pages.menu_items.enums.TopMenuListItem;

public class HomePage {
    MenuComponents menuComponents;

    public HomePage()
    {
        this.menuComponents = new MenuComponents();
    }

    public BooksPage navigateToBooksPage()
    {
        this.menuComponents.clickMenu(TopMenuListItem.BOOKS);
        return new BooksPage();
    }
}
