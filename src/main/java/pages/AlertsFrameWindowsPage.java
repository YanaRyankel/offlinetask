package pages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AlertsFrameWindowsMenuItems;
import utilities.ElementsMenuItems;

import java.util.List;

@Getter

public class AlertsFrameWindowsPage extends BasePage {
    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//div[3]/div/ul/li")
    List<WebElement> menuList;

    @FindBy(xpath = "//div[@class=\"main-header\"]")
    WebElement header;

    public boolean isPageDisplayed(){
        return header.getText().equals("Alerts, Frame & Windows");
    }

    public List<WebElement> getMenuList() {
        return menuList;
    }

    public <T> T selectMenuItem(AlertsFrameWindowsMenuItems menuItems){

        T pageObject;
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        switch (menuItems){
            case ALERTS:
                menuList.get(1).click();
                pageObject= (T) new AlertsPage(driver);
                break;
            default:
                pageObject=null;
                System.out.println("Page not found");
        }
        return  pageObject;
    }
}
