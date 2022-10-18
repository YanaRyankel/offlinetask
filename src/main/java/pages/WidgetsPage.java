package pages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AlertsFrameWindowsMenuItems;
import utilities.WidgetsMenuItems;

import java.util.List;

@Getter

public class WidgetsPage extends BasePage {
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//div[4]/div/ul/li")
    List<WebElement> menuList;

    @FindBy(xpath = "//div[@class=\"main-header\"]")
    WebElement header;

    public boolean isPageDisplayed(){
        return header.getText().equals("Widgets");
    }

    public List<WebElement> getMenuList() {
        return menuList;
    }

    public <T> T selectMenuItem(WidgetsMenuItems menuItems){

        T pageObject;
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        switch (menuItems){
            case DATE_PICKER:
                menuList.get(2).click();
                pageObject= (T) new DatePickerPage(driver);
                break;
            case SELECT_MENU:
                menuList.get(8).click();
                pageObject= (T) new SelectMenuPage(driver);
                break;
            default:
                pageObject=null;
                System.out.println("Page not found");
        }
        return  pageObject;
    }
}
