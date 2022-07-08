package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.AssetPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AssetPage assetPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public AssetPage getAssetPage() {
        return (assetPage == null) ? assetPage = new AssetPage(driver) : assetPage;
    }
}
