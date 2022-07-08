package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverHelper;

public class AssetPage {
    WebDriver driver;

    public AssetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "name")
    private WebElement assetNameField;

    @FindBy(how = How.ID, using = "cf")
    private WebElement assetCapacityFactor;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submit;

    @FindBy(how = How.XPATH, using = "/html/body/div/h1")
    private WebElement assetPageTitle;

    @FindBy(how = How.XPATH, using = "/html/body/div/h1")
    private WebElement assetEditPageTitle;

    @FindBy(how = How.XPATH, using = "/html/body/main/div/div/p")
    private WebElement errorValidationmessage;

    public void enterAssetName(String assetName) {
        assetNameField.sendKeys(assetName);
    }

    public void enterCapacity(String capacityFactor) {
        assetCapacityFactor.sendKeys(capacityFactor);
    }

    public void clickSubmitButton() {
        WebDriverHelper.scrollDown(driver);
        WebDriverHelper.clickButton(driver, "#submit");
    }

    public void clickEditButton(String locator) {
        WebDriverHelper.clickButton(driver, "#e-"+locator);
    }

    public void clickDeleteButton(String locator){
        WebDriverHelper.clickButton(driver, "#d-"+locator);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getAssetPageHeader(WebDriver driver) {
        return assetPageTitle.getText();
    }

    public String getAssetEditPageHeader(WebDriver driver) {
        return assetEditPageTitle.getText();
    }

    public String getErrorValidationMessage(){
        return errorValidationmessage.getText();
    }
}
