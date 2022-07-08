package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverHelper;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.LINK_TEXT, using="Login")
    private WebElement loginLink;

    @FindBy(how = How.ID, using = "username")
    private WebElement usernameField;

    @FindBy(how = How.XPATH, using = "//*[@id='pwd']")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submit;


    public void goToLoginPage(){
        loginLink.click();
    }

    public void enterUsername(String username1){
        usernameField.sendKeys(username1);
    }

    public void enterPassword(String password1){
        passwordField.sendKeys(password1);
    }

    public void clickSubmitButton(){
        submit.click();
    }

}
