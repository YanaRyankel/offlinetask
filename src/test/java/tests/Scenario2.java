package tests;

import configuration.Config;
import configuration.DriverClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPage;
import pages.AlertsPage;
import pages.ElementsPage;
import pages.HomePage;
import utilities.AlertsFrameWindowsMenuItems;
import utilities.ElementsMenuItems;
import utilities.HomeMenu;
import utilities.Utils;

public class Scenario2 {
    HomePage homePage;
    AlertsFrameWindowsPage alertsFrameWindowsPage;
    AlertsPage alertsPage;
    WebDriver driver = DriverClass.getInstance("chrome");
    Utils utils=new Utils(driver);

    @BeforeTest
    public void setUp() {
        driver.get(Config.URL);
    }

    @Test
    public void scenario2(){
        homePage=new HomePage(driver);
        driver.manage().window().maximize();
        Assert.assertTrue(homePage.isPageDisplayed());
        utils.movedToElement(homePage.getCards().get(0), driver);
        alertsFrameWindowsPage= homePage.goTo(HomeMenu.ALERTS_FRAME_WINDOWS);
        utils.movedToElement(alertsFrameWindowsPage.getMenuList().get(1), driver);
        alertsPage=alertsFrameWindowsPage.selectMenuItem(AlertsFrameWindowsMenuItems.ALERTS);
        Assert.assertTrue(alertsPage.isPageDisplayed());
        Assert.assertEquals(alertsPage.getOption2Description().getText(), alertsPage.getExpectedOption2Desc());
        Assert.assertTrue(alertsPage.getOption2Btn().isDisplayed());
        Assert.assertTrue(alertsPage.checkOption2());

    }

    @AfterClass
    public void endTest() {
        driver.quit();
    }
}
