import com.bridgelabz.testng.base.BaseClass;
import com.bridgelabz.testng.pages.LoginPage;
import com.bridgelabz.testng.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseClass {
    SignUpPage signUpPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        initialization();
        signUpPage = new SignUpPage();
    }

    @Test
    public void launchFB_SignUp() throws InterruptedException {
        driver.get("https://en-gb.facebook.com/signup");
        Thread.sleep(500);
        loginPage = signUpPage.validationFBSignUp();
        String actualTitle = "Sign up for Facebook | Facebook";
        String title = driver.getTitle();
        Assert.assertEquals(actualTitle, title);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
