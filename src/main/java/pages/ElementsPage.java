package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ElementsMenuItems;

import java.util.List;

@Getter

public class ElementsPage extends BasePage {
    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[1]/div/ul/li")
    List<WebElement> menuList;

    @FindBy(xpath = "//div[@class=\"main-header\"]")
    WebElement header;

    public boolean isPageDisplayed(){
        return header.getText().equals("Elements");
    }

    public <T> T selectMenuItem(ElementsMenuItems menuItems){

        T pageObject;

        switch (menuItems){

            case CHECK_BOX:
                menuList.get(1).click();
                pageObject= (T) new CheckBoxPage(driver);
                break;
            default:
                pageObject=null;
                System.out.println("Page not found");
        }
    return  pageObject;
    }
}
