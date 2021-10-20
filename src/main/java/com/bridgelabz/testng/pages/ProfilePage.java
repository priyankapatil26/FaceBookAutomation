package com.bridgelabz.testng.pages;

import com.bridgelabz.testng.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage extends BaseClass {

    @FindBy(xpath = "//span[contains(text(),'John Smith')]")
    WebElement element;

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public EditProfilePage viewProfile() {

        element.click();
        return new EditProfilePage();
    }
}



