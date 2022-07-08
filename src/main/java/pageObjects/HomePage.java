package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyLoader;
import utils.WebDriverHelper;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/h1")
    private WebElement HomePageTitle;

    public String homePageUrl(){
        return WebDriverHelper.getCurrentPageUrl(driver);
    }

    public void navigateToPexaparkAssetManagementApp(){
        WebDriverHelper.navigateToURL(PropertyLoader.loadProperty("homepageUrl"), driver);
    }
}
