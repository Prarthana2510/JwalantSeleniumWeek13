package homework1.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;


    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

    }

    public void selectMenu(String menu) {

        WebElement menuItem = driver.findElement(By.linkText(menu));
        menuItem.click();
        //actions.moveToElement(menuItem).click().perform();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
