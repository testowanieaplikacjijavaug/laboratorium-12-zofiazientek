package lab12zad1.Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zad1PageFactory {
    public WebDriver driver;
    private final Wait<WebDriver> wait;
    @FindBy(name = "search_query")
    private WebElement searchItem;
    private WebElement title;

    public Zad1PageFactory(WebDriver driver) {
        this.driver = driver;
        driver.get("http://automationpractice.com/index.php");
        wait = new WebDriverWait(driver,15);
    }

    public void search(String item) throws Exception {
        searchItem.sendKeys(item);
        searchItem.submit();
        Thread.sleep(1000);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void titleWait(String pageTitle){
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }


}
