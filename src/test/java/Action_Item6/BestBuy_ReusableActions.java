package Action_Item6;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.WebDriver;

public class BestBuy_ReusableActions {
 public static void main(String[] args) throws InterruptedException {
  //declare the webdriver and define it from the reusable actions
  WebDriver driver = ReusableActions.setUpDriver();
  //navigate to bestbuy homepage
  driver.navigate().to("https://www.bestbuy.com/");
  //enter the keyword "Macbook" in search field
  ReusableActions.sendKeysAction(driver, "//*[@class='search-input']", "Macbook", "MacbookSearch");
  //Click on the search  button
  ReusableActions.clickAction(driver, "//*[@class='header-search-button']", "SearchButton");
  //Click on Best Selling by using select by text in drop down menu
  ReusableActions.selectByText(driver, "//*[@id='sort-by-select']", "Best Selling", "dropDown");
  //Click by index to click on the first macbook link
  ReusableActions.clickByIndex(driver, "//*[@class='product-image ']", 0, "First Macbook Link");
  //Scroll by Pixel
  ReusableActions.scrollByPixel(driver, 2200, "ScrollAction");
  //Click on Add to Cart Button
  ReusableActions.clickAction(driver, "//*[@data-button-state='ADD_TO_CART']", "AddtoCart");
  //Capture cart subtotal and print the amount
  String total = ReusableActions.getText(driver, "//*[@class='sub-total v-fw-medium']", "Subtotal");
  //Split total amount to print dollar amount only
  String[] Subtotal = total.split(" ");
  System.out.println(" The Cart subtotal is " + Subtotal[0]);
  //hover over continue shopping
  ReusableActions.mouseHover(driver, "//*[@class='c-button-link continue-shopping']", "mouseHover");
  //wait few seconds
  Thread.sleep(5000);
  //click on continue shopping
  ReusableActions.clickAction(driver, "//*[@class='c-button-link continue-shopping']", "ClickShopping");

 }//end of main
}//end of class
