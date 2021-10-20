package com.bridgelabz.testng.pages;
import com.bridgelabz.testng.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage extends BaseClass {

    @FindBy(xpath = "//span[contains(text(),'Edit Profile')]")
    WebElement edit;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    WebElement editPicture;

    public EditProfilePage(){
        PageFactory.initElements(driver,this);
    }

    public void clickEditProfile(){
        edit.click();
        editPicture.click();

    }
}
