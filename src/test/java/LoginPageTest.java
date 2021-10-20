import com.bridgelabz.testng.base.BaseClass;
import com.bridgelabz.testng.pages.LoginPage;
import com.bridgelabz.testng.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    LoginPage loginPage;
    ProfilePage profilePage;


    /*WelcomePage welcomePage;
    ForgottPasswordPage forgottPasswordPage;
    String sheetName = "loginTestData";*/

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String loginPageTitle = loginPage.verifyPageTitle();
        //System.out.println("Login Page Title is : "+loginPageTitle);
        Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up", loginPageTitle);
    }

    @Test(priority = 2)
    public void loginTest() {
        profilePage = loginPage.login();
    }
   /* @DataProvider
    public Object[][] getLoginTestdata() {
        return TestUtil.getTestData(sheetName);
    }
    @Test(priority = 2, dataProvider = "getLoginTestdata")
    public void loginTest(String username, String password) {
        welcomePage = loginPage.login(username, password);
    }
    @Test(priority = 3)
    public void forgottPasswordTest() {
        forgottPasswordPage = loginPage.forgottPassword();
    }*/

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
