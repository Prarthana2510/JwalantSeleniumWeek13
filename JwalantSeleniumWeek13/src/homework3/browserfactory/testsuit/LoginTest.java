package homework3.browserfactory.testsuit;

import homework1.homepage.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void sendTextToElement(By by, String text) {
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
    }
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        sendTextToElement(By.name("username"), "Shukla");
        sendTextToElement(By.name("password"), "Shukla");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        String actualText = driver.findElement(By.cssSelector("#rightPanel > div > div > h1")).getText();
        String expectedText = "Accounts Overview";
    Assert.assertEquals(actualText, expectedText);
    driver.findElement(By.cssSelector("#leftPanel > ul > li:nth-child(8) > a")).click();
    String actualText2 = driver.findElement(By.cssSelector("#leftPanel > h2")).getText();
    String expectedText2 = "Customer Login";
    Assert.assertEquals(actualText2, expectedText2);



    }
    @Test

    public void verifyTheErrorMessage(){
        sendTextToElement(By.name("username"), "invalidprosp");
        sendTextToElement(By.name("password"), "inaldkjf");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        String actualError = driver.findElement(By.cssSelector("#rightPanel > p")).getText();
        String expectedError = "An internal error has occurred and has been logged.";



    }
    @After
    public void endTet() {
        closeBrowser();
    }

}
