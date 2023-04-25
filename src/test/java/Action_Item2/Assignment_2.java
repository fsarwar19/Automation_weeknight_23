package Action_Item2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Assignment_2 {
    public static void main(String[] args) throws InterruptedException {
        //set your web driver manager to indicate what type of browser/driver you are using
        WebDriverManager.chromedriver().setup();

//define the Web Driver/Browser you want to use for your test
        WebDriver driver = new ChromeDriver();

//set up array list for cars
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Soccer");
        sports.add("Volleyball");
        sports.add("Football");
        sports.add("Basketball");

        for (int i = 0; i < sports.size(); i++) {
            //navigate to Bing Home Page
            driver.navigate().to("https://www.bing.com");

            //wait few seconds
            Thread.sleep(2000);

            //enter the keyword  to the search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));

            //hit submit on the Bing search button
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();

            //wait few seconds for page to load
            Thread.sleep(2000);

            //capture the search results

            String results = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //System.out.println("Result is " + results);
            //using split function we can extract out the search number from the entire text
            String[] arrayResult = results.split(" ");
            System.out.println("For " + sports.get(i) + " the search number is " + arrayResult[1]);
        }//end of loop

//finally, quit your browser to exit the driver
        driver.quit();
    }//end of main
}//end of assignment






