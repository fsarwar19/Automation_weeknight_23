package Action_Item3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class A1_chromeOptions {
    public static void main(String[] args) throws InterruptedException {
        // set up chromedriver as webdriver manager
        WebDriverManager.chromedriver().setup();
        //declare chromeoptions
        ChromeOptions options = new ChromeOptions();
        // start maximized for MAC
        options.addArguments("--kiosk");
        // start incognito
        options.addArguments("incognito");
        //define the webdriver and pass the options
        WebDriver driver = new ChromeDriver(options);


        //Create an ArrayList of Sports
        ArrayList<String> sports = new ArrayList<>();
        //add values for sports
        sports.add("Basketball");
        sports.add("Soccer");
        sports.add("Volleyball");
        sports.add("Baseball");

        //set up for loop
        //go to yahoo.com
        for (int i = 0; i < sports.size(); i++) {
            driver.navigate().to("https://www.yahoo.com");
            //wait a few seconds
            Thread.sleep(2000);


            //enter the keyword in search field by xpath
            driver.findElement(By.xpath("//*[@name='p']")).sendKeys(sports.get(i));

            //hit search  button by xpath
            driver.findElement(By.xpath("//*[@id='ybar-search']")).submit();

            //wait few seconds for page to load
            Thread.sleep(2000);

//capture the search results

            String results = driver.findElement(By.xpath("//*[@class=' fz-14 lh-22']")).getText();

            //using split function we can extract out the search number from the entire text]

            String[] arrayResult = results.split(" ");
            System.out.println("For " + sports.get(i) + " the search number is " + arrayResult[1]);


            //define javascript executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll down 800 pixels (based on your need adjust it by + or - 200)
            jse.executeScript("scroll(0,5000)");
            //wait few seconds for page to load
            Thread.sleep(3000);

            //click on about this  page link
            driver.findElement(By.xpath("//*[text() = 'About this page']")).click();

            //print yahoo 24/7 message
            // driver.findElement(By.xpath("//*[@class='msg success']")).getText();

            WebElement aboutThisPageMessage = driver.findElement(By.xpath("//*[@class='msg success']"));
            String aboutThisPageText = aboutThisPageMessage.getText();
            System.out.println(aboutThisPageText);


        }//end of loop

        //quit the browser
        driver.quit();


    } // end of main
} // end of class
