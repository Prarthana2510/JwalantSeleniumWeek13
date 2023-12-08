package homework3.browserfactory.testsuit;

import homework1.homepage.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
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

    public void verifyThatSigningUpPageDisplay() {
        driver.findElement(By.cssSelector("#loginPanel > p:nth-child(3) > a")).click();
        String actualText = driver.findElement(By.cssSelector("#rightPanel > h1")).getText();
        String expectedText = "Signing up is easy!";
        Assert.assertEquals(actualText, expectedText);

    }

    @Test

    public void userSholdRegisterAccountSuccessfully() throws InterruptedException {
        driver.findElement(By.cssSelector("#loginPanel > p:nth-child(3) > a")).click();

        sendTextToElement(By.cssSelector("input[id = 'customer.firstName']"), "Jack");
        sendTextToElement(By.id("customer.lastName"), "Shukla");
        sendTextToElement(By.id("customer.address.street"), "abc");
        sendTextToElement(By.id("customer.address.city"), "abc");
        sendTextToElement(By.id("customer.address.state"), "abc");
        sendTextToElement(By.id("customer.address.zipCode"), "123");
        sendTextToElement(By.id("customer.ssn"), "abc");
        sendTextToElement(By.id("customer.username"), "Shukla");
        sendTextToElement(By.id("customer.password"), "Shukla");
        sendTextToElement(By.id("repeatedPassword"), "Shukla");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String actualText = driver.findElement(By.cssSelector("#rightPanel > p")).getText();
        String expectedText = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals(actualText, expectedText);

    }

    @After
    public void endTet() {
        closeBrowser();
    }


}

