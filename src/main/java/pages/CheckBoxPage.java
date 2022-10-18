package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckBoxPage extends BasePage {

    public CheckBoxPage(WebDriver driver){
        super(driver);
    }

    public String documentsExpectedText="You have selected : documents workspace react angular veu office public private classified general";

    @FindBy(id = "tree-node")
    private  WebElement checkBoxTree;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/div/button[1]")
    private WebElement expandAllBtn;

    @FindBy(xpath = "//label[@for='tree-node-documents']")
    private WebElement documentsCheckBox;

    @FindBy(id="result")
    private WebElement text;

    public void expandTreeNode(){
        expandAllBtn.click();
    }

    public void selectDocuments(){
        documentsCheckBox.click();
    }

    public String getDocumentsText(){
        return text.getText().replace("\n"," ");
    }

    public boolean isPageDisplayed(){
        return checkBoxTree.isDisplayed();
    }

    public String getDocumentsExpectedText() {
        return documentsExpectedText;
    }

}
