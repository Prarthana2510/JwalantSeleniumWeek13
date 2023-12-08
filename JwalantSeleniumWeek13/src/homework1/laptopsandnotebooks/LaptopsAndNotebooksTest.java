package homework1.laptopsandnotebooks;

import homework1.homepage.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LaptopsAndNotebooksTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        WebElement laptop = driver.findElement(By.cssSelector("#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(2) > a"));
//    Actions actions = new Actions(driver);
//    actions.moveToElement(laptop).build().perform();
        laptop.click();
        WebElement showAll = driver.findElement(By.cssSelector("#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(2) > div > a"));
        showAll.click();

        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(4);

        WebElement text = driver.findElement(By.xpath("//a[contains(text(), 'MacBook Pro')]"));
        String actualText = text.getText();
        String expectedText = "MacBook Pro";
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Method 1 test passed");


    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {

        WebElement laptop = driver.findElement(By.cssSelector("#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(2) > a"));
        laptop.click();
        WebElement showAll = driver.findElement(By.cssSelector("#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(2) > div > a"));
        showAll.click();
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(4);
        WebElement macBook = driver.findElement(By.xpath("//a[contains(text(), 'MacBook Pro')]"));
        macBook.click();
        WebElement macbooktext = driver.findElement(By.xpath("//h1[contains(text(), 'MacBook Pro')]"));
        String actualText = macbooktext.getText();
        String expectedText = "MacBook Pro";
        Assert.assertEquals(actualText, expectedText);
        WebElement addToCartButton = driver.findElement(By.id("button-cart"));
        addToCartButton.click();
        WebElement shoppingCart = driver.findElement(By.xpath("//div[@id='product-product']/div[1]/a[2]"));
        shoppingCart.click();
        WebElement quantity = driver.findElement(By.xpath("//input[@class='form-control']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(quantity).sendKeys("2").build().perform();
        WebElement update = driver.findElement(By.xpath("//button[@data-original-title='Update']"));
        update.click();
        WebElement message = driver.findElement(By.cssSelector(".alert"));
        String actualMessage = message.getText();
        String expectedMessage = "Success: You have modified your shopping cart!\n" + "×";
        Assert.assertEquals(expectedMessage, actualMessage);
        WebElement checkout = driver.findElement(By.cssSelector("div[class='pull-right'] a"));
        checkout.click();
        WebElement guestRadioButton = driver.findElement(By.cssSelector("[value='guest']"));
        guestRadioButton.click();
        WebElement continueButton = driver.findElement(By.cssSelector("[id='button-account']"));
        continueButton.click();
        WebElement name = driver.findElement(By.cssSelector("[name='firstname']"));
        name.sendKeys("Jay");
        WebElement surname = driver.findElement(By.cssSelector("[name='lastname']"));
        surname.sendKeys("Shuk");
        WebElement email = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        email.sendKeys("Jay@gmail.com");
        WebElement phone = driver.findElement(By.cssSelector("[name='telephone']"));
        phone.sendKeys("333999");
        WebElement address1 = driver.findElement(By.cssSelector("[name='address_1']"));
        address1.sendKeys("q128");
        WebElement city = driver.findElement(By.cssSelector("[name = 'city']"));
        city.sendKeys("Dharavi");
        WebElement postcode = driver.findElement(By.cssSelector("[name = 'postcode']"));
        postcode.sendKeys("ec1 4jw");
        WebElement country = driver.findElement(By.cssSelector("[name = 'country_id']"));
        //country.click();
        Select select2 = new Select(country);
        select2.selectByVisibleText("Israel");

        WebElement state = driver.findElement(By.cssSelector("[name = 'zone_id']"));
        //state.click();
        Select select3 = new Select(state);
        select3.selectByVisibleText("Haifa");
        WebElement guesstContinueButton = driver.findElement(By.cssSelector("input[id='button-guest']"));
        guesstContinueButton.click();

        WebElement comment = driver.findElement(By.cssSelector("[name='comment']"));
        comment.sendKeys("Please deliver between 1 and 5");
        WebElement contButton = driver.findElement(By.xpath("(//input[@value='Continue'])[4]"));
        contButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement termsCheckbox = driver.findElement(By.cssSelector("[name='agree']"));
        termsCheckbox.click();

        WebElement afterContButton = driver.findElement(By.xpath("(//input[@value='Continue'])[5]"));
        afterContButton.click();
        System.out.println("Method 2 test passed");


    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
