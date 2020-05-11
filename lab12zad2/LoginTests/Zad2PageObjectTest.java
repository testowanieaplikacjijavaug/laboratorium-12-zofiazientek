package lab12zad2.LoginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lab12zad2.Login.Zad2PageObject;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Zad2PageObjectTest {
    private static WebDriver driver;
    private String login = "lab12@gmail.com";

    @BeforeAll
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void guru99LoginTest() throws  Exception {
        String guruUrl = "http://demo.guru99.com/test/login.html";
        Zad2PageObject guruLogin = new Zad2PageObject(driver, guruUrl);
        guruLogin.login(login,"lab12");
        String expectedUrl = "http://demo.guru99.com/test/success.html";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

    }

    @Test
    public void apTest() throws  Exception {
        String apUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        Zad2PageObject apLogin = new Zad2PageObject(driver, apUrl);
        apLogin.login(login,"lab12");
        String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
