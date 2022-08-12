package com.origamiitlab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.aventstack.extentreports.Status;
import com.origamiitlab.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * TODO: Run on Local, Remote (Selenium Grid, BrowserStack, Sauce Lab, Selenoid)
     * TODO: Browsers Chrome, Firefox, Opera
     */

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage  = new LoginPage(driver);
    }

    @Test
    public void test_perform_login_with_all_user_type(@Optional("standard_user") String username, @Optional("secret_sauce")String password) {
        String title = loginPage
                .perform_login(username, password)
                .getCurrentPageURL();

        assertEquals("Swag Labs", driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
