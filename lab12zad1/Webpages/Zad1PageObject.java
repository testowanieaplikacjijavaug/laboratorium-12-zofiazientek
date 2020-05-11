package lab12zad1.Webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zad1PageObject {

    public WebDriver driver;
    public final Wait<WebDriver> wait;

    public Zad1PageObject(WebDriver driver) {
        this.driver = driver;
        driver.get("http://automationpractice.com/index.php");
        wait = new WebDriverWait(driver, 10);
    }

    public void search(String item) throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search_query")));
        driver.findElement(By.name("search_query")).sendKeys(item);
        driver.findElement(By.name("search_query")).submit();
        Thread.sleep(1000);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
