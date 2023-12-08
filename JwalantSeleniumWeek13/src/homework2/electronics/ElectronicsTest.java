package homework2.electronics;

import homework1.homepage.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElectronicsTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    public void sendTextToElement(By by, String text) {
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
    }

    @Test

    public void textVerified() {

        //Test name text verified()
        //1.1 Mouse Hover on “Electronics” Tab
        //1.2 Mouse Hover on “Cell phones” and click
        //1.3 Verify the text “Cell phones”
        Actions actions = new Actions(driver);
        WebElement elecronis = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(2) > a"));
        WebElement cellphones = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(2) > ul > li:nth-child(2) > a"));
        actions.moveToElement(elecronis).moveToElement(cellphones).click().build().perform();

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement elecronis = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(2) > a"));
        WebElement cellphones = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(2) > ul > li:nth-child(2) > a"));
        actions.moveToElement(elecronis).moveToElement(cellphones).click().build().perform();
        driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-body > div.product-selectors > div.product-viewmode > a.viewmode-icon.list")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-body > div.products-container > div.products-wrapper > div > div > div:nth-child(3) > div > div.details > h2 > a")).click();
        // WebElement quantity5 = driver.findElement(By.xpath("//td[@class='quantity']"));
        //        Actions actions5 = new Actions(driver);
        //        actions5.doubleClick(quantity5).sendKeys("2").build().perform();
        Thread.sleep(5000);

        WebElement quanitity = driver.findElement(By.cssSelector("#product_enteredQuantity_20"));
        Actions actions2 = new Actions(driver);
        actions2.doubleClick(quanitity).sendKeys("2").build().perform();
        driver.findElement(By.cssSelector("#add-to-cart-button-20")).click();

        Thread.sleep(5000);


        //#topcartlink > a > span.cart-label
        //actions.moveToElement(elecronis).moveToElement(cellphones).click().build().perform();

        WebElement shoppingCart = driver.findElement(By.cssSelector("#topcartlink > a > span.cart-label"));

        WebElement goToCart = driver.findElement(By.cssSelector("#flyout-cart > div > div.buttons > button"));
        actions.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
        driver.findElement(By.cssSelector("#shopping-cart-form > div.cart-footer > div.totals > div.terms-of-service > label")).click();
        driver.findElement(By.cssSelector("#checkout")).click();

        driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body > div.customer-blocks > div.new-wrapper.checkout-as-guest-or-register-block > div.buttons > button.button-1.checkout-as-guest-button")).click();

        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Jack");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Shukla");
        sendTextToElement(By.id("BillingNewAddress_Email"), "jack@gmail.com");
        //WebElement dropDown2 = driver.findElement(By.id("product_attribute_1"));
        //        Select select2 = new Select(dropDown2);
        //        select2.selectByIndex(1);
        WebElement dropdown4 = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select4 = new Select(dropdown4);
        select4.selectByIndex(1);
        Thread.sleep(5000);
        WebElement dropdown5 = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        Select select5 = new Select(dropdown5);
        select5.selectByVisibleText("Alaska");
        sendTextToElement(By.id("BillingNewAddress_City"), "abc");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "abc");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "abc");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "123");
        driver.findElement(By.cssSelector("#billing-buttons-container > button.button-1.new-address-next-step-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#shipping-methods-form > ul > li:nth-child(2) > div.method-name")).click();
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#payment-method-block > li:nth-child(2) > div > div.payment-logo > label > img")).click();
        driver.findElement(By.cssSelector("#payment-method-buttons-container > button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("CardholderName")).sendKeys("Jack");
        driver.findElement(By.id("CardNumber")).sendKeys("1111222233334444");
        WebElement id = driver.findElement(By.id("ExpireYear"));
        Select select6 = new Select(id);
        select6.selectByIndex(2);
        driver.findElement(By.id("CardCode")).sendKeys("123");
        driver.findElement(By.cssSelector("#payment-info-buttons-container > button")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#confirm-order-buttons-container > button")).click();


    }
    @After
    public void endTest(){
        closeBrowser();
    }

}
