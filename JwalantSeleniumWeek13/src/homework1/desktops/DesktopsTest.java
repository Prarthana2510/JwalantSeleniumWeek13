package homework1.desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DesktopsTest {
    private WebDriver driver;
    private Actions actions;


    public DesktopsTest() {

        driver = new ChromeDriver();
        actions = new Actions(driver);

        driver.get("http://tutorialsninja.com/demo/index.php");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        Thread.sleep(2000);
        WebElement desktopsTab = driver.findElement(By.linkText("Desktops"));
        actions.moveToElement(desktopsTab).perform();
        WebElement showAllDesktops = driver.findElement(By.linkText("Show AllDesktops"));
        showAllDesktops.click();
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(2);
        WebElement sonyText = driver.findElement(By.xpath("//a[contains(text(), 'Sony VAIO')]"));
        String actualSonyText = sonyText.getText();
        String expectedSontyText = "Sony VAIO";
        Assert.assertEquals(expectedSontyText, actualSonyText);
        System.out.println("Descending order verified, test passed");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
Thread.sleep(2000);
        WebElement desktopsTab = driver.findElement(By.linkText("Desktops"));
                actions.moveToElement(desktopsTab).perform();
                WebElement showAllDesktops = driver.findElement(By.linkText("Show AllDesktops"));
                showAllDesktops.click();
//        WebElement desktopsTab2 = driver.findElement(By.linkText("Desktops"));
//        actions.moveToElement(desktopsTab2).perform();
//        WebElement showAllDesktops2 = driver.findElement(By.linkText("Show AllDesktops"));
//        showAllDesktops2.click();
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        WebElement hp = driver.findElement(By.xpath("//a[contains(text(), 'HP LP3065')]"));
        hp.click();

        String expectedMonthAndYear = "July 2011";
        String expectedDate = "1";

        WebElement datePicker = driver.findElement(By.xpath("//*[@id='product']/div[1]/div/span/button"));
        datePicker.click();
        while (true) {
            String actualMonthAndYear = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/table/thead/tr[1]/th[2]")).getText();
            if (actualMonthAndYear.equalsIgnoreCase(expectedMonthAndYear)) {
                break;
            } else {
                WebElement next = driver.findElement(By.xpath("//th[@class='next']"));
                next.click();
            }
        }
        List<WebElement> listOfDates = driver.findElements(By.xpath("//div/div[1]/table/tbody"));
        for (WebElement date : listOfDates) {
            if (date.getText().equalsIgnoreCase(expectedDate)) {
                date.click();
                break;
            }

        }
        WebElement addToCart = driver.findElement(By.xpath("//button[@id='button-cart']"));
        addToCart.click();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.xpath("//*[@id='product-product']/div[1]"));
        String actualSuccessMessage = message.getText();
        String expectedSuccessMessage = "Success: You have added HP LP3065 to your shopping cart!\n×";
        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
        WebElement shoppingCartLink = driver.findElement(By.linkText("shopping cart"));
        shoppingCartLink.click();

        WebElement shoppingCart = driver.findElement(By.linkText("Shopping Cart"));
        WebElement productName = driver.findElement(By.linkText("HP LP3065"));
        WebElement modelName = driver.findElement(By.xpath("//td[contains(text(), 'Product 21')]"));
        WebElement total = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[6]"));

        String actualShoppingText = shoppingCart.getText();
        String actualProductText = productName.getText();
        String actualModelText = modelName.getText();
        String actualTotalText = total.getText();

        String expectedShoppingText = "Shopping Cart";
        String expectedProductText = "HP LP3065";
        String expectedModelText = "Product 21";
        String expectedTotalText = "$122.00";

        Assert.assertEquals(actualShoppingText, expectedShoppingText);
        Assert.assertEquals(actualProductText, expectedProductText);
        Assert.assertEquals(actualModelText, expectedModelText);
        Assert.assertEquals(actualTotalText, expectedTotalText);
        System.out.println("All texts verified");
    }
    @After
    public void endTest(){
        driver.quit();
    }

}
