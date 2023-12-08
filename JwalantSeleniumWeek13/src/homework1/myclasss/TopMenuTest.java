package homework1.myclasss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class TopMenuTest {
    private WebDriver driver;
    private Actions actions;

    public TopMenuTest() {

        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://tutorialsninja.com/demo/index.php");
    }

    public static void main(String[] args) {
        TopMenuTest test = new TopMenuTest();
        test.verifyUserShouldNavigateToDesktopsPageSuccessfully();
        test.verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully();
        test.verifyUserShouldNavigateToComponentsPageSuccessfully();
        test.closeBrowser();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void selectMenu(String menu) {
        WebElement menuItem = driver.findElement(By.linkText(menu));
        menuItem.click();
        //actions.moveToElement(menuItem).click().perform();
    }

    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        WebElement desktopsTab = driver.findElement(By.linkText("Desktops"));

        actions.moveToElement(desktopsTab).perform();
        selectMenu("Show AllDesktops");

        WebElement desktopsText = driver.findElement(By.xpath("//h2[contains(text(), 'Desktops')]"));
        assert desktopsText.getText().equals("Desktops") : "Navigation to Desktops page failed.";

        System.out.println("Successfully navigated to Desktops page.");
    }

    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        WebElement laptopsTab = driver.findElement(By.linkText("Laptops & Notebooks"));

        actions.moveToElement(laptopsTab).perform();
        selectMenu("Show AllLaptops & Notebooks");

        WebElement laptopsText = driver.findElement(By.xpath("//h2[contains(text(), 'Laptops & Notebooks')]"));
        assert laptopsText.getText().equals("Laptops & Notebooks") : "Navigation to Laptops & Notebooks page failed.";

        System.out.println("Successfully navigated to Laptops & Notebooks page.");
    }

    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        WebElement componentsTab = driver.findElement(By.linkText("Components"));

        actions.moveToElement(componentsTab).perform();
        selectMenu("Show AllComponents");

        WebElement componentsText = driver.findElement(By.xpath("//h2[contains(text(), 'Components')]"));
        assert componentsText.getText().equals("Components") : "Navigation to Components page failed.";

        System.out.println("Successfully navigated to Components page.");
    }


}