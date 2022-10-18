package tests;

import configuration.Config;
import configuration.DriverClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.HomePage;
import utilities.ElementsMenuItems;
import utilities.HomeMenu;
import utilities.Utils;

public class Scenario1 {
    HomePage homePage;
    ElementsPage elementsPage;
    CheckBoxPage checkBoxPage;
    WebDriver driver = DriverClass.getInstance("chrome");
    Utils utils=new Utils(driver);

    @BeforeTest
    public void setUp() {
        driver.get(Config.URL);
    }

    @Test
    public void scenario1(){
        homePage=new HomePage(driver);
        Assert.assertTrue(homePage.isPageDisplayed());
        elementsPage= homePage.goTo(HomeMenu.ELEMENTS);
        //Assert.assertTrue(elementsPage.isPageDisplayed());
        checkBoxPage=elementsPage.selectMenuItem(ElementsMenuItems.CHECK_BOX);
        Assert.assertTrue(checkBoxPage.isPageDisplayed());
        checkBoxPage.expandTreeNode();
        checkBoxPage.selectDocuments();
        Assert.assertEquals(checkBoxPage.getDocumentsText(), checkBoxPage.getDocumentsExpectedText());
    }

    @AfterClass
    public void endTest() {
        driver.quit();
    }
}
