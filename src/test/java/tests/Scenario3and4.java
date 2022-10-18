package tests;

import configuration.Config;
import configuration.DriverClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utilities.HomeMenu;
import utilities.Utils;
import utilities.WidgetsMenuItems;

public class Scenario3and4 {
    HomePage homePage;
    DatePickerPage datePickerPage;
    SelectMenuPage selectMenuPage;
    WidgetsPage widgetsPage;
    WebDriver driver = DriverClass.getInstance("chrome");
    Utils utils=new Utils(driver);

    @BeforeTest
    public void setUp() {
        driver.get(Config.URL);
    }

    @Test
    public void scenario3(){
        homePage=new HomePage(driver);
        driver.manage().window().maximize();
        Assert.assertTrue(homePage.isPageDisplayed());
        utils.movedToElement(homePage.getCards().get(3), driver);
        widgetsPage= homePage.goTo(HomeMenu.WIDGETS);
        utils.movedToElement(widgetsPage.getMenuList().get(1), driver);
        datePickerPage=widgetsPage.selectMenuItem(WidgetsMenuItems.DATE_PICKER);
        Assert.assertTrue(datePickerPage.isPageDisplayed());
        datePickerPage.setDateAndTime("2024", "May", "1", "11:00");
        Assert.assertEquals(datePickerPage.getDateAndTimePicker().getAttribute("value"), "May 1, 2024 11:00 AM");
    }

    @Test
    public void scenario4(){
        homePage=new HomePage(driver);
        driver.manage().window().maximize();
        Assert.assertTrue(homePage.isPageDisplayed());
        utils.movedToElement(homePage.getCards().get(3), driver);
        widgetsPage= homePage.goTo(HomeMenu.WIDGETS);
        utils.movedToElement(widgetsPage.getMenuList().get(widgetsPage.getMenuList().size()-1), driver);
        selectMenuPage=widgetsPage.selectMenuItem(WidgetsMenuItems.SELECT_MENU);
        Assert.assertTrue(selectMenuPage.isPageDisplayed());
        utils.movedToElement(selectMenuPage.getSelectMenuContainer(), driver);
        Assert.assertEquals(selectMenuPage.getExpectedOldSelectMenuOptions(),selectMenuPage.getOldMenuOptions());
        Assert.assertEquals(selectMenuPage.getExpectedMultiSelectMenuOptions(),selectMenuPage.getMultiSelectOptions());
        String carToSelect=selectMenuPage.getExpectedMultiSelectMenuOptions().get(0);
        selectMenuPage.selectMultiSelectedOption(carToSelect);
        Assert.assertEquals(carToSelect, selectMenuPage.getSelectedMultiSelectedOption());
    }

    @AfterClass
    public void endTest() {
        driver.quit();
    }
}
