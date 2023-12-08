package homework1.myaccounts;

import homework1.homepage.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountsTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";


    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    public void selectMyAccountOptions(String option) {

        WebElement menuItem = driver.findElement(By.linkText(option));
        menuItem.click();
    }

    public void sendTextToElement(By by, String text) {
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {


        WebElement myAccount = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[1]"));
        myAccount.click();
        selectMyAccountOptions("Register");


        WebElement registerText = driver.findElement(By.cssSelector("[id='content'] h1"));

        String actualRegisterText = registerText.getText();
        String expectedRegisterText = "Register Account";
        Assert.assertEquals(expectedRegisterText, actualRegisterText);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        WebElement myAccount = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[1]"));
        myAccount.click();
        selectMyAccountOptions("Login");
        WebElement returnCustomer = driver.findElement(By.xpath("(//div[@class='well'])[2]/h2"));
        String actualReturnCustomer = returnCustomer.getText();
        String expectedReturnCustomer = "Returning Customer";
        Assert.assertEquals(actualReturnCustomer, expectedReturnCustomer);


    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        WebElement myAccount = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[1]"));
        myAccount.click();
        selectMyAccountOptions("Register");
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Jack");
        sendTextToElement(By.id("input-lastname"), "Shukla");
        sendTextToElement(By.id("input-email"), "jack1@castle.com");
        sendTextToElement(By.id("input-telephone"), "52225222");
        sendTextToElement(By.id("input-password"), "52225222");
        sendTextToElement(By.id("input-confirm"), "52225222");
        WebElement tAndC = driver.findElement(By.name("agree"));
        tAndC.click();
        WebElement continuButton = driver.findElement(By.cssSelector("[type='submit']"));
        continuButton.click();
        WebElement logout = driver.findElement(By.linkText("Logout"));
        String actualLogoutText = logout.getText();
        String expectedLogoutText = "Logout";
        Assert.assertEquals(actualLogoutText, expectedLogoutText);
        WebElement contButton = driver.findElement(By.xpath("//div[@class='pull-right']"));
        contButton.click();

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {

        WebElement myAccount = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[1]"));
        myAccount.click();
        selectMyAccountOptions("Login");
        sendTextToElement(By.id("input-email"), "jack1@castle.com");
        sendTextToElement(By.id("input-password"), "52225222");
        WebElement login = driver.findElement(By.cssSelector("[value='Login']"));
        login.click();
        WebElement myAccount1 = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[1]"));
        myAccount1.click();
        selectMyAccountOptions("Logout");
        WebElement logoutText = driver.findElement(By.xpath("//h1[contains(text(), 'Account Logout')]"));
        String actualLogoutText = logoutText.getText();
        String expectedLogoutText = "Account Logout";
        Assert.assertEquals(actualLogoutText, expectedLogoutText);
        WebElement logoutButton = driver.findElement(By.cssSelector("[class='btn btn-primary']"));
        logoutButton.click();


    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
