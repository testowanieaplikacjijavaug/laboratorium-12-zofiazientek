package lab12zad1.WebpagesTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lab12zad1.Webpages.Zad1PageObject;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestZad1PageObject {
    public static WebDriver driver;
    private Zad1PageObject zad1;

    @BeforeAll
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void searchForShoes() throws Exception {
        zad1 = new Zad1PageObject(driver);
        zad1.search("shoes");
        String expectedUrl = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=shoes";
        Assert.assertEquals(expectedUrl,zad1.getUrl());
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }


}
