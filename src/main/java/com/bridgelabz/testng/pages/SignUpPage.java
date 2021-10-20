package com.bridgelabz.testng.pages;

import com.bridgelabz.testng.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpPage extends BaseClass {
    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(name = "reg_email__")
    WebElement phoneNumber;

    @FindBy(name = "reg_passwd__")
    WebElement password;

    @FindBy(id = "day")
    WebElement birthDate;

    @FindBy(id = "month")
    WebElement birthMonth;

    @FindBy(id = "year")
    WebElement birthYear;

    @FindBys(@FindBy(name = "sex"))
    List<WebElement> selectGender;

    @FindBy(name = "websubmit")
    WebElement submit;

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage validationFBSignUp() {
        firstName.sendKeys("Priyanka");
        lastName.sendKeys("patil");
        phoneNumber.sendKeys("8897541262");
        password.sendKeys("Password865454");

        Select selectDay = new Select(birthDate);
        selectDay.selectByIndex(5);
        Select selectMonth = new Select(birthMonth);
        selectMonth.selectByValue("1");
        Select selectYear = new Select(birthYear);
        selectYear.selectByVisibleText("2000");

        List<WebElement> gender = selectGender;
        gender.get(0).click();

        submit.click();
        return new LoginPage();
    }
}
