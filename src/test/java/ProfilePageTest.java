import com.bridgelabz.testng.base.BaseClass;
import com.bridgelabz.testng.pages.EditProfilePage;
import com.bridgelabz.testng.pages.LoginPage;
import com.bridgelabz.testng.pages.ProfilePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseClass {
    LoginPage loginPage;
    ProfilePage profilePage;
    EditProfilePage editProfilePage;

    public  ProfilePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        profilePage = loginPage.login();
    }

    @Test
    public void launchFB_profilePage() throws InterruptedException {
        profilePage = new ProfilePage();
        editProfilePage = profilePage.viewProfile();
         }

    @AfterMethod
    public void tearDown() {

        //driver.quit();
    }
}


