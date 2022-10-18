package pages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.HomeMenu;

import java.util.List;

@Getter
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy( xpath = "//div[@class=\"category-cards\"]/div")
    private List<WebElement> cards;

    @FindBy(className = "banner-image")
    private WebElement bannerImage;

    public boolean isPageDisplayed() {
        return bannerImage.isDisplayed();
    }

    public List<WebElement> getCards() {
        return cards;
    }

    public <T> T goTo(HomeMenu homeMenu) {
        T pageObject;
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        switch (homeMenu) {
           case ELEMENTS:
               cards.get(0).click();
                pageObject= (T) new ElementsPage(driver);
                break;
           case ALERTS_FRAME_WINDOWS:
               cards.get(2).click();
               pageObject= (T) new AlertsFrameWindowsPage(driver);
               break;
            case WIDGETS:
                cards.get(3).click();
                pageObject= (T) new WidgetsPage(driver);
                break;
           default:
               pageObject=null;
               System.out.println("Page not found");
       }
       return pageObject;
    }

}
