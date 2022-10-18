package pages;

import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver){
        super(driver);
    }


    @FindBy(id="selectMenuContainer")
    private WebElement selectMenuContainer;

    @FindBy(xpath="//div[@id=\"withOptGroup\"]")
    private WebElement optionsDropDown;


    public boolean isPageDisplayed(){
        return selectMenuContainer.isDisplayed();
    }


    public List<String> getExpectedOldSelectMenuOptions(){
        List<String> list=new ArrayList<String>();
        list.add("Red");
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");
        list.add("Purple");
        list.add("Black");
        list.add("White");
        list.add("Voilet");
        list.add("Indigo");
        list.add("Magenta");
        list.add("Aqua");
        return list;
    }

    public List<String> getExpectedMultiSelectMenuOptions(){
        List<String> list=new ArrayList<String>();
        list.add("Volvo");
        list.add("Saab");
        list.add("Opel");
        list.add("Audi");
        return list;
    }

    public List<String> getOldMenuOptions(){
        Select selectOldSelectMenu = new Select(driver.findElement(By.id("oldSelectMenu")));
        List<WebElement> selectOldSelectMenuList=selectOldSelectMenu.getOptions();
        List<String> selectOldSelectMenuText= new ArrayList<>();
        selectOldSelectMenuList.stream().map(WebElement::getText).forEach(selectOldSelectMenuText::add);
          return selectOldSelectMenuText;
    }
    Select multiSelect = new Select(driver.findElement(By.id("cars")));
    public List<String> getMultiSelectOptions(){
        List<WebElement> multiSelectList=multiSelect.getOptions();
        List<String> multiSelectText= new ArrayList<>();
        multiSelectList.stream().map(WebElement::getText).forEach(multiSelectText::add);
        return multiSelectText;
    }

    public void selectMultiSelectedOption(String visibleText){
            multiSelect.selectByVisibleText(visibleText);
    }

    public String getSelectedMultiSelectedOption(){
        List<WebElement> list=multiSelect.getAllSelectedOptions();
        List<String> list2= new ArrayList<>();
        list.stream().map(WebElement::getText).forEach(list2::add);
         return list2.get(0);
    }


}
