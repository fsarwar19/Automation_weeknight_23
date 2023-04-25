package Action_Item8;

import Day12_04112023.TestParent;
import ReusableLibrary.ReusableActions;
import ReusableLibrary.ReusableActions_Loggers;
import org.testng.annotations.Test;

public class Citibank_testcase extends TestParent {

    @Test
    public void tc001() {
        //As a customer I should be able to see the steps in buying a home so I understand the procedure for buying a home
        //navigate to citibank webpage
        driver.navigate().to("https://www.citi.com/");
        //next hover on lending
        ReusableActions_Loggers.mouseHover(driver, "//*[@id='navlendingmainAnchor2']", logger, "clickonLending");
        //click on buying a home
        ReusableActions_Loggers.clickAction(driver,"//*[@id='navBuyaHomeBuy a Homeundefined3']",logger,"BuyingaHome");
        //scroll to steps to buying a house
        ReusableActions_Loggers.scrollByPixel(driver,500,"Scrolltosteps");
        //click on link to citi home buyers guide
        ReusableActions_Loggers.clickAction(driver,"//*[@href='/mortgage/first-time-buyer']",logger,"Buyersguidelink");


    }//end of testcase 1

    @Test
    public void tc002() {
        //As an employee I want customers to see benefits of getting pre approved so they see can apply through citibank
        //navigate to citibank webpage
        driver.navigate().to("https://www.citi.com/");
        //next hover on lending
        ReusableActions_Loggers.mouseHover(driver, "//*[@id='navlendingmainAnchor2']", logger, "clickonLending");
        //click on buying a home
        ReusableActions_Loggers.clickAction(driver,"//*[@id='navBuyaHomeBuy a Homeundefined3']",logger,"BuyingaHome");
        //Click on Pre-approval link
        ReusableActions_Loggers.clickAction(driver,"//*[@href='/mortgage/surestart-preapproval']",logger,"PreapprovalLink");

    }//end of test case 2

    @Test
    //As a customer I would like to see the promotional offers for Citi Mortgage so that I can know if i should apply for Citi loan
    public void tc003() {
        //navigate to citibank webpage
        driver.navigate().to("https://www.citi.com/");
        //next hover on lending
        ReusableActions_Loggers.mouseHover(driver, "//*[@id='navlendingmainAnchor2']", logger, "clickonLending");
        //click on buying a home
        ReusableActions_Loggers.clickAction(driver, "//*[@id='navBuyaHomeBuy a Homeundefined3']", logger, "BuyingaHome");
        //Capture the promotional offer
        String promotion = ReusableActions.getText(driver, " //*[@class='copy ng-star-inserted']", "Promotion Offer");
        System.out.println(promotion);

    }//end of tc003

    @Test
    //As a customer I would like to have access to a mortgage calculator so that i can see how much my monthly mortgage would be
    public void tc004() {
        //navigate to citibank webpage
        driver.navigate().to("https://www.citi.com/");
        //next hover on lending
        ReusableActions_Loggers.mouseHover(driver, "//*[@id='navlendingmainAnchor2']", logger, "clickonLending");
        //next click on Mortgage Calcl
        ReusableActions_Loggers.clickAction(driver, "//*[@id='mortCalc']", logger, "Mortgage Calc Link");
        //next click on monthly mortgage payment calculator
        ReusableActions_Loggers.clickAction(driver, "//*[@href='/mortgage/monthly-payment-calculator']", logger, "Monthly Calculator");

    }//end of tc004


 @Test
 //As an administrator there should be an option to view the webpage in Spanish if Spanish speaking customers need help understanding
  public void tc005() throws InterruptedException {
     //navigate to citibank webpage
     driver.navigate().to("https://www.citi.com/");
     //click on spanish icon
     ReusableActions_Loggers.clickAction(driver,"//*[@id='lang']",logger,"Espanol icon");
     //wait few seconds
     Thread.sleep(5000);


 }//end of test case 005

    @Test
    //As a customer i would like to view today's rates so I would know the intrest rate
    public void tc006() throws InterruptedException {

        //navigate to citibank webpage
        driver.navigate().to("https://www.citi.com/");
        //next hover on lending
        ReusableActions_Loggers.mouseHover(driver, "//*[@id='navlendingmainAnchor2']", logger, "clickonLending");
        //wait few seconds
        Thread.sleep(2000);
        //click on todays rate
        ReusableActions_Loggers.clickAction(driver, "//*[@href='/mortgage/purchase-rates']", logger, "Rates");
        //wait few seconds
        Thread.sleep(5000);
    }//end of tc006

}//end of main