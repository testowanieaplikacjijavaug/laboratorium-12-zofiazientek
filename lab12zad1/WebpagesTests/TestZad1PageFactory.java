package lab12zad1.WebpagesTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lab12zad1.Webpages.Zad1PageFactory;
import lab12zad1.Webpages.Zad1PageObject;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class TestZad1PageFactory {
    public static WebDriver driver;
    //private Zad1PageFactory zad1;

    @BeforeAll
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        driver = new ChromeDriver();
    }

    @Test
    public void searchForShoes() throws Exception {
        Zad1PageFactory zad1 = PageFactory.initElements(driver, Zad1PageFactory.class);
        zad1.titleWait("My Store");
        zad1.search("shoes");
        String expectedTitle = "Search - My Store";
        Assert.assertTrue(zad1.getTitle().contains(expectedTitle));
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
