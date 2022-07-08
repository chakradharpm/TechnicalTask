package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.AssetPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.PropertyLoader;
import utils.WebDriverHelper;

public class Steps {
    WebDriver driver = WebDriverHelper.getDriver();

    HomePage homePage;
    AssetPage assetPage;
    LoginPage loginPage;

    PageObjectManager pageObjectManager = new PageObjectManager(driver);

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        driver.manage().window().maximize();
        homePage = pageObjectManager.getHomePage();
        homePage.navigateToPexaparkAssetManagementApp();
        loginPage = pageObjectManager.getLoginPage();
        loginPage.goToLoginPage();

    }

    @When("the user enters username")
    public void the_user_enters_username() {
        loginPage.enterUsername(PropertyLoader.loadProperty("username"));
    }

    @And("the user enters password")
    public void the_user_enters_password() {
        loginPage.enterPassword(PropertyLoader.loadProperty("password"));
    }

    @And("click on the login page submit button")
    public void click_on_the_submit_button() {
        loginPage.clickSubmitButton();
    }

    @Then("the user should land on the asset page that shows the list of existing assets")
    public void the_user_should_land_on_the_asset_page_that_shows_the_list_of_existing_assets() {
        assetPage = pageObjectManager.getAssetPage();
        Assert.assertEquals("Assets", assetPage.getPageTitle(driver));
    }

    @Given("the user is on the assets page")
    public void the_user_is_on_the_assets_page(){
        Assert.assertEquals("Assets", assetPage.getPageTitle(driver));
    }

    @When("the user enters the asset name")
    public void the_user_enters_the_asset_name(){
        assetPage.enterAssetName(PropertyLoader.loadProperty("assetName"));

    }

    @And("the user enters the capacity factor")
    public void the_user_enters_the_capacity_factor(){
        assetPage.enterCapacity(PropertyLoader.loadProperty("capacityFactor"));
    }

    @And("the user clicks on the submit button")
    public void the_user_clicks_on_the_submit_button(){
        assetPage.clickSubmitButton();
    }

    @Then("a new asset is created with the given asset name and capacity factor")
    public void a_new_asset_is_created_with_the_given_asset_name_and_capacity_factor(){
        Assert.assertTrue(driver.getPageSource().contains(PropertyLoader.loadProperty("assetName")));
    }

    @When("the user click on edit button of an existing asset")
    public void the_user_click_on_edit_button(){
        assetPage.clickEditButton(PropertyLoader.loadProperty("assetName"));
    }

    @Then("the user is navigated to the Edit Asset page")
    public void the_user_is_navigated_to_edit_asset_page(){
        Assert.assertEquals("Edit Asset", assetPage.getAssetEditPageHeader(driver));
    }

    @And("the user enters the new asset name")
    public void the_user_enters_the_new_asset_name(){
        assetPage.enterAssetName(PropertyLoader.loadProperty("newAssetName"));
    }

    @And("the user enters the new capacity factor")
    public void the_user_enters_the_new_capacity_factor(){
        assetPage.enterCapacity(PropertyLoader.loadProperty("newCapacityFactor"));
    }

    @And("the user click on the submit button")
    public void the_user_click_on_the_submit_button(){
        assetPage.clickSubmitButton();
    }

    @When("the user enters the short asset name and valid capacity factor")
    public void the_user_enters_the_short_assetName(){
        assetPage.enterAssetName("1");
        assetPage.enterCapacity(PropertyLoader.loadProperty("capacityFactor"));
    }

    @Then("asset name too short error message should display")
    public void asset_name_too_short_error_message_shour_display(){
        Assert.assertEquals(assetPage.getErrorValidationMessage(),PropertyLoader.loadProperty("assetNameTooShortErrorMessage"));
    }

    @And("the user navigates back to the asset page")
    public void the_user_navigate_back_to_the_asset_page(){
        driver.navigate().back();
    }

    @When("the user enters the very long asset name and valid capacity factor")
    public void the_user_enters_the_very_long_assetname(){
        assetPage.enterAssetName("Thissentenceisthirtyfourcharacters");
        assetPage.enterCapacity(PropertyLoader.loadProperty("capacityFactor"));
    }

    @Then("asset name too long error message should display")
    public void asset_name_too_long_error_message_should_display(){
        Assert.assertEquals(assetPage.getErrorValidationMessage(),PropertyLoader.loadProperty("assetNameTooLongErrorMessage"));
    }

    @Then("the selected asset should be updated with the new asset name and the new capacity factor")
    public void the_selected_asset_should_be_updated_with_the_new_asset_name_and_the_new_capacity_factor(){
        Assert.assertTrue(driver.getPageSource().contains(PropertyLoader.loadProperty("newAssetName")));
        Assert.assertTrue(driver.getPageSource().contains(PropertyLoader.loadProperty("newCapacityFactor")));
    }

    @When("the user click on delete button of an existing asset")
    public void the_user_click_on_delete_button_of_an_existing_asset(){
        assetPage.clickDeleteButton(PropertyLoader.loadProperty("newAssetName"));
    }

    @Then("the asset should be deleted and should not display in the list of assets")
    public void the_asset_should_be_deleted_and_should_not_display_in_the_list_of_assets(){
        Assert.assertFalse(driver.getPageSource().contains(PropertyLoader.loadProperty("newAssetName")));
    }

    @After()
    public void teardown(){
        WebDriverHelper.killDriver(driver);

    }
}
