package org.anytest.pages.menu_items.enums;

public enum TopMenuListItem {
    BOOKS("Books"),
    COMPUTERS("Computers"),
    ELECTRONICS("Electronics"),
    APPAREL_AND_SHOES("Apparel & Shoes"),
    DIGITAL_DOWNLOADS("Digital downloads"),
    JEWELRY("Jewelry"),
    GIFT_CARDS("Gift Cards");


    private final String topMenuItemName;

    public String getName()
    {
        return topMenuItemName.trim();
    }

    TopMenuListItem(String topMenuItemName)
    {
        this.topMenuItemName=topMenuItemName;
    }
}
