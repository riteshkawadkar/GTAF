package com.origamiitlab.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id="login-button")
    WebElement login_button;

    @FindBy(className="error-message-container")
    WebElement error_container;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentPageURL()
    {
        return driver.getCurrentUrl();
    }

    public LoginPage perform_login(String _username, String _password) {
        driver.get("https://www.saucedemo.com/");

        username.sendKeys(_username);
        password.sendKeys(_password);
        login_button.click();
        return this;
    }

}
