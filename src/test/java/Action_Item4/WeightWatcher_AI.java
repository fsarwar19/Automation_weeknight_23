package Action_Item4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class WeightWatcher_AI {
    public static void main(String[] args) throws InterruptedException {

        //set up your chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();

        //define the Web Driver/Browser you want to use for your test
        WebDriver driver = new ChromeDriver();

        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //use chrome options to start chrome driver with maximize and incognito
        options.addArguments("incognito");
        options.addArguments("--kiosk");

        //Create an array list of 3 zipcode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("11435");
        zipCode.add("07013");

        //use a for loop to search zipcode from array list
        for (int i = 0; i < zipCode.size(); i++) {

            //navigate to weightwatchers find a workshop
            driver.navigate().to("https://www.weightwatchers.com/");

            //wait few seconds
            Thread.sleep(2000);

            //Click on Find a Workshop by xpath
            try {
                driver.findElement(By.xpath("//*[text() = 'Find a Workshop']")).click();
            } catch (Exception e) {
                System.out.println("Unable to Find a Workshop" + e);
            }

            //Click on in person link
            try {
                driver.findElement(By.xpath("//*[@class='buttonText-3DCCO']")).click();
            } catch (Exception e) {
                System.out.println("Click on in person link" + e);
            }

            //wait few seconds
            Thread.sleep(4000);


            //enter the zipcode  in search field by xpath
            try {
                driver.findElement(By.xpath("//*[@class='input input-3TfT5']")).sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("Unable to enter the zipcode " + e);
            }

            // click on search button
            try {
                driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on the search button" + e);
            }

            //wait few seconds
            Thread.sleep(4000);

            //define javascript executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll down 800 pixels
            jse.executeScript("scroll(0,800)");

            //wait few seconds
            Thread.sleep(4000);

            //Click on the specific studio link
            try {
                ArrayList<WebElement> studioLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")));
                if (i == 0) {
                    studioLinks.get(1).click();
                } else if (i == 1) {
                    studioLinks.get(2).click();
                } else if (i == 2) {
                    studioLinks.get(0).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to click on the studio link" + e);
            }

            //wait few seconds
            Thread.sleep(4000);

            //Print the address
            try {
                String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();

                String[] splitAddress = address.split("In-Person");

                System.out.println("The Address is " + splitAddress[0]);
            } catch (Exception e) {
                System.out.println("Unable to print address" + e);
            }

            //scroll to upcoming in person view
            jse.executeScript("scroll(0,800)");

            //wait few seconds
            Thread.sleep(4000);

            //Capture table of in-person schedule and print result

            try {
                String schedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                System.out.println(schedule);
            } catch (Exception e) {
                System.out.println("Unable to print schedule" + e);
            }

        }//end of loop

        //quit driver
        driver.quit();


    }//end of main

}//end of class
