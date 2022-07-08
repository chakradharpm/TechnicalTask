package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class WebDriverHelper {

    public static void navigateToURL(String url, WebDriver driver) {
        driver.navigate().to(url);
        waitForNewPageToLoad(driver);
    }

    public static void waitForNewPageToLoad(WebDriver driver) {
        for (int i = 0; i < 10; i++) {
            //To check page ready state.
            if (javaScriptExecutor("return document.readyState", driver).toString()
                    .equals("complete")) {
                break;
            }
        }
    }

    public static String javaScriptExecutor(String javaScriptString, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        return (String) jse.executeScript(javaScriptString);
    }

    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", PropertyLoader.loadProperty("driverPath"));
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-extensions");
        option.addArguments("no-sandbox");
        option.addArguments("disable-infobars");
        option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        option.setCapability(ChromeOptions.CAPABILITY, option);
        return new ChromeDriver(option);
    }
    public static String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static void killDriver(WebDriver driver){
        //driver.close();
        driver.quit();
    }

    public static void scrollDown(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
    }

    public static void waitFor(long timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread sleep exception occurred...", e);
        }
    }

    public static WebElement waitUntilElementIsClickable(WebDriver driver, int timeOut, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickButton(WebDriver driver, String locator){
        String query = "document.querySelector('" + locator + "').click()";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(query);
    }


}
