package ReusableLibrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableActions_Loggers {
    public static WebDriver setUpDriver() {
        //set up your chromedriver with WebDriverManager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of web driver method

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click action


    public static String getText(WebDriver driver, String xpath,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String returnText = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            returnText = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text: " + elementName + " reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
        return returnText;
    }//end of getText method

    public static void sendKeysAction(WebDriver driver, String xpath,ExtentTest logger, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to send keys to: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of send keys action


    //click by selectByText
    public static void selectByText(WebDriver driver, String xpath,ExtentTest logger, String dropdownSelection, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(dropdownSelection);
        } catch (Exception e) {
            System.out.println("Unable to select by  Text keys to: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of select by text action


    public static void clickByIndex(WebDriver driver, String xpath, ExtentTest logger, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click:" + elementName + "the reason is " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of ClickByIndex method


    //scrollByPixel Method
    public static void scrollByPixel(WebDriver driver, int pixels, String elementName) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0," + pixels + ")");
    }//End of scrollByPixel Method


    //mouseHover Method
    public static void mouseHover(WebDriver driver, String xpath,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Actions mouseActions = new Actions(driver);
            mouseActions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover by mouse action " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//End of mouseHover

    //submitAction Method
    public static void submitAction(WebDriver driver, String xpath,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of submit action

    //switch tabs by Index
    public static void switchTabByIndex(WebDriver driver, int indexNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(indexNumber));
    }//end of switch tabs by Index

    public static void isConditionTrue(boolean bool, ExtentTest logger){
        if (bool == true) {
            logger.log(LogStatus.PASS, "Boolean condition is : " + bool);
        } else {
            logger.log(LogStatus.FAIL, "Boolean condition is : " + bool);
        }
    }//end of isConditionTrue method


    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method


}//end of reusable action logger class




