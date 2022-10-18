package pages;

import javafx.scene.control.DatePicker;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Getter
public class DatePickerPage extends BasePage {

    public DatePickerPage(WebDriver driver){
        super(driver);
    }


    @FindBy(id="dateAndTimePickerInput")
    private WebElement dateAndTimePicker;

    @FindBy(xpath = "//span[@class=\"react-datepicker__month-read-view--down-arrow\"]")
    private WebElement selectMonthDownArrow;

    @FindBy(xpath = "//span[@class=\"react-datepicker__year-read-view--down-arrow\"]")
    private WebElement selectYearDownArrow;

    @FindBy(xpath = "//div[@class=\"react-datepicker__month-option\"]")
    private List<WebElement> monthList;

    @FindBy(xpath = "//li[@class=\"react-datepicker__time-list-item \"]")
    private List<WebElement> timeList;

    @FindBy(xpath = "//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div]")
    private List<WebElement> yearsList;

    @FindBy(xpath = "//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div")
    private List<WebElement> dateList;

    public boolean isPageDisplayed(){
        return dateAndTimePicker.isDisplayed();
    }

    public List<WebElement> getYearsList() {
        return yearsList;
    }

    public void setDateAndTime(String year, String month,  String date, String time) {
        dateAndTimePicker.click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        selectYearDownArrow.click();
        for (WebElement webElement : yearsList) {

            if (webElement.getText().equals(year)) {

                webElement.click();

            }
        }
        selectMonthDownArrow.click();
        for (WebElement webElement : monthList) {

            if (webElement.getText().equalsIgnoreCase(month)) {
                webElement.click();

            }
        }

        for (WebElement webElement : dateList) {

            if (webElement.getText().equalsIgnoreCase(date)) {

                webElement.click();

            }
        }
        for (WebElement webElement : timeList) {
            if (webElement.getText().equalsIgnoreCase(time)) {
                webElement.click();
            }
        }
        dateAndTimePicker.sendKeys(Keys.ENTER);
    }
}
