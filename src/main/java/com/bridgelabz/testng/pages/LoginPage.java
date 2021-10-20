package com.bridgelabz.testng.pages;

import com.bridgelabz.testng.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(id = "email")
    WebElement username;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    // initialization
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }


    public String verifyPageTitle() {
        return driver.getTitle();
    }

    public ProfilePage login() {
        username.sendKeys(properties.getProperty("username"));
        password.sendKeys(properties.getProperty("password"));
        loginButton.click();
        return new ProfilePage();
    }
}
