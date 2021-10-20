import com.bridgelabz.testng.base.BaseClass;
import com.bridgelabz.testng.pages.EditProfilePage;
import com.bridgelabz.testng.pages.LoginPage;
import com.bridgelabz.testng.pages.ProfilePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProfilePageTest extends BaseClass {
    LoginPage loginPage;
    ProfilePage profilePage;
    EditProfilePage editProfilePage;
    EditProfilePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        profilePage = loginPage.login();
        editProfilePage = profilePage.viewProfile();
    }

    @Test
    public void launchFB_EditProfilePage() throws InterruptedException {
        editProfilePage = new EditProfilePage();
        editProfilePage.clickEditProfile();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
