package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

public class Utils extends BasePage {

    public Utils(WebDriver driver){
        super(driver);
    }
    WebDriver driver;

    public void movedToElement(WebElement webElement, WebDriver driver){
    Actions action=new Actions(driver);
    action.moveToElement(webElement);
    action.perform();
}}
