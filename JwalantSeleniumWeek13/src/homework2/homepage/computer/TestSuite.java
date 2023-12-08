package homework2.homepage.computer;

import homework1.homepage.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestSuite extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";




    @Before
    public void setUp() {
        openBrowser(baseUrl);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void sendTextToElement(By by, String text) {
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
    }

    @Test
    public void name() {


        WebElement computers = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]"));
        computers.click();
        WebElement desktops = driver.findElement(By.xpath("//a[contains(text(), ' Desktops ')]"));
        desktops.click();
        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByValue("6");
        WebElement lenovo = driver.findElement(By.xpath("//a[contains(text(), 'Lenovo IdeaCentre')]"));
        String actualLenovoText = lenovo.getText();
        String expectedLenovoText = "Lenovo IdeaCentre 600 All-in-One PC";
        Assert.assertEquals(expectedLenovoText, actualLenovoText);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement computers = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]"));
        computers.click();
        WebElement desktops = driver.findElement(By.xpath("//a[contains(text(), ' Desktops ')]"));
        desktops.click();
        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByValue("5");
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until((ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-productid='1']/div[2]/div[3]/div[2]/button[1]"))))).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOf(addToCart));
        //Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-productid='1']/div[2]/div[3]/div[2]/button[1]")));
        Thread.sleep(2000);
        WebElement addToCart = driver.findElement(By.xpath("//div[@data-productid='1']/div[2]/div[3]/div[2]/button[1]"));
        addToCart.click();
        Thread.sleep(2000);


        WebElement dropDown2 = driver.findElement(By.id("product_attribute_1"));
        Select select2 = new Select(dropDown2);
        select2.selectByIndex(1);
        //Thread.sleep(2000);
        WebElement dropDown3 = driver.findElement(By.id("product_attribute_2"));
        Select select3 = new Select(dropDown3);
        select3.selectByIndex(3);
        driver.findElement(By.cssSelector("#product_attribute_3_7")).click();
        driver.findElement(By.xpath("//*[@id='product_attribute_input_4']/ul/li[2]/label")).click();
        driver.findElement(By.xpath("//*[@id='product_attribute_input_5']/ul/li[1]/label")).click();
        driver.findElement(By.cssSelector("#product_attribute_input_5 > ul > li:nth-child(1) > label")).click();
        driver.findElement(By.cssSelector("#product_attribute_input_5 > ul > li:nth-child(3) > label")).click();
        driver.findElement(By.id("add-to-cart-button-1")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='topcartlink']/a/span[1]")).click();
        Thread.sleep(2000);

//Actions actions = new Actions(driver);
//        actions.doubleClick(quantity).sendKeys("2").build().perform();
        WebElement quantity5 = driver.findElement(By.xpath("//td[@class='quantity']"));
        Actions actions5 = new Actions(driver);
        actions5.doubleClick(quantity5).sendKeys("2").build().perform();
        driver.findElement(By.id("updatecart")).click();
        driver.findElement(By.cssSelector("#shopping-cart-form > div.cart-footer > div.totals > div.terms-of-service > label")).click();
        driver.findElement(By.cssSelector("#checkout")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Checkout as Guest')]")).click();
        Thread.sleep(5000);
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
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body.checkout-data > div > div.buttons > button")).click();


    }
    @After
    public void endTest(){
        closeBrowser();
    }
}

