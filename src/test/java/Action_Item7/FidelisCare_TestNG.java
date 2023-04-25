package Action_Item7;

import Day12_04112023.TestParent;
import ReusableLibrary.ReusableActions;
import org.testng.annotations.Test;

public class FidelisCare_TestNG extends TestParent {

    @Test
public void testCase_01() throws InterruptedException {
    //navigate to fidelis homepage
    driver.navigate().to("https://www.fideliscare.org");
    // wait few seconds
    Thread.sleep(5000);
    // click on the search field
    ReusableActions.clickAction(driver, "//*[@class='tool dropdown search']", "SearchButton");
    // enter Get Dental Coverage on the search field
    ReusableActions.sendKeysAction(driver, "//*[@class='form-control search-input']", "Get Dental Coverage", "Dental Coverage");
    // click on search icon
    ReusableActions.clickAction(driver, "//*[@aria-label='Execute Search']", "SearchIcon");
    //Capture search result
    String searchResult = ReusableActions.getText(driver, "//*[@class='gsc-result-info']", "Search result");
    //Split the search result number
    String[] Result = searchResult.split(" ");
    System.out.println(" The Search Result Number " + Result[1]);
    //click on Get General Coverage link
    ReusableActions.clickAction(driver, "//*[text()='Get Dental Coverage']", "GeneralCoverageLink");

}// end of testCase_01

    @Test(dependsOnMethods = "testCase_01")

    public void testCase_02() throws InterruptedException {
        // switch to new tab
        ReusableActions.switchTabByIndex(driver, 1);
        // click on first name field
        ReusableActions.clickAction(driver, "//*[@id='firstName']", "F-Name");
        //enter first name
        ReusableActions.sendKeysAction(driver, "//*[@id='firstName']", "Jane", "FirstName");
        //Wait few seconds
        Thread.sleep(2000);
        // click on last name field
        ReusableActions.clickAction(driver, "//*[@id='lastName']", "L-Name");
        //enter last name
        ReusableActions.sendKeysAction(driver, "//*[@id='lastName']", "Doe", "LastName");
        //Wait few seconds
        Thread.sleep(2000);
        //click on zipcode field
        ReusableActions.clickAction(driver, "//*[@id='zipCode']", "Zip-Code");
        //enter zipcode
        ReusableActions.sendKeysAction(driver, "//*[@id='zipCode']", "11218", "ZipCode");
        //Wait few seconds
        Thread.sleep(2000);
        // select county
        ReusableActions.selectByText(driver, "//*[@id='county']", "New York", "CountyName");
        // click on phone number field
        ReusableActions.clickAction(driver, "//*[@id='phoneNumber']", "P-Number");
        //enter phone number
        ReusableActions.sendKeysAction(driver, "//*[@id='phoneNumber']", "5551234567", "PhoneNumber");
        //Wait few seconds
        Thread.sleep(2000);
        // click on email address field
        ReusableActions.clickAction(driver, "//*[@id='email']", "Email");
        //enter email address
        ReusableActions.sendKeysAction(driver, "//*[@id='email']", "hello123@yahoo.com", "EmailAddress");
        //Wait few seconds
        Thread.sleep(2000);
        // click on the contact me check box
        ReusableActions.clickAction(driver, "//*[@for='contactMe']", "CheckBox");
        //Wait few seconds
        Thread.sleep(2000);
        // click on the contact me button
        ReusableActions.clickAction(driver, "//*[@type='submit']", "ContactMe");
        //Wait few seconds
        Thread.sleep(2000);
        // capture the Thank Message
        String thankYouMessage = ReusableActions.getText(driver, "//*[@role='alert']", "ThankYou message");
        System.out.println(thankYouMessage);
        System.out.println();
        //close the tab
        driver.close();
    }// end of testCase02

    @Test(dependsOnMethods = {"testCase_01", "testCase_02"})

    public void testCase03() throws InterruptedException {
        // switch back to main tab
        ReusableActions.switchTabByIndex(driver,0);
        //Wait few seconds
        Thread.sleep(3000);
        // click on login
        ReusableActions.clickAction(driver, "//*[@class='tool dropdown login']", "Login");
        // click on Member online portal
        ReusableActions.clickAction(driver, "//*[@target='_blank']", "Member Portal");
        Thread.sleep(3000);
        //switch to new tab
        ReusableActions.switchTabByIndex(driver, 1);
        //Wait few seconds
        Thread.sleep(5000);
        String helpfullHints = ReusableActions.getText(driver, "//*[@class='tipsContentText']", "HelpfullHints");
        System.out.println(helpfullHints);
        //Wait few seconds
        Thread.sleep(2000);
        //close current tab
        driver.close();


    }//end of testCase03

}//end of class


