package org.anytest.test.pages;

import org.anytest.base.BaseTest;
import org.anytest.pages.HomePage;
import org.testng.annotations.Test;

public class BooksPageTest extends BaseTest {

    @Test(testName = "Book Page Test", description = "Verify Books Names are Listed")
    public void getBooksNames()
    {
        new HomePage()
                .navigateToBooksPage()
                .getBooksTitle();
    }
}
