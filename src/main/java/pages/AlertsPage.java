package pages;

import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Getter
public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver){
        super(driver);
    }

    public String expectedOption2Desc="On button click, alert will appear after 5 seconds";
    private String expectedOption2AlertText="This alert appeared after 5 seconds";

    @FindBy(xpath = "//*[@id=\"javascriptAlertsWrapper\"]/div[2]/div[1]")
    private WebElement option2Description;

    @FindBy(id="timerAlertButton")
    private WebElement option2Btn;

    public boolean isPageDisplayed(){
        return option2Description.isDisplayed();
    }
    public String getExpectedOption2Desc() {
        return expectedOption2Desc;
    }

    public WebElement getOption2Description() {
        return option2Description;
    }

    public WebElement getOption2Btn() {
        return option2Btn;
    }

    public boolean checkOption2(){
        option2Btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText().contentEquals(expectedOption2AlertText);
    }




}
