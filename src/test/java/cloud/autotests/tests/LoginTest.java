package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.ProfilePage;
import org.junit.jupiter.api.Test;

import static cloud.autotests.testdata.TestData.userSuccess;
import static cloud.autotests.testdata.TestData.userWrongLogin;


public class LoginTest extends TestBase {

    LoginWindow loginWindow = new LoginWindow();
    ProfilePage profilePage = new ProfilePage();

    @Test
    void successLogin() {
        loginWindow.openLoginWindow()
                .typeLogin(userSuccess.getLogin())
                .typePassword(userSuccess.getPass())
                .submitLoginForm();
        profilePage.checkLoginIsVisibleInProfile(userSuccess.getLogin());

    }

    @Test
    void wrongLoginTest() {
        loginWindow.openLoginWindow()
                .typeLogin(userWrongLogin.getLogin())
                .typePassword(userWrongLogin.getPass())
                .submitLoginForm();
        loginWindow.checkErrorLoginMessage("User with that username doesn't exist");
    }

    @Test
    void emptyLoginTest() {
        loginWindow.openLoginWindow()
                .typeLogin("")
                .typePassword(userWrongLogin.getPass())
                .submitLoginForm();
        loginWindow.checkErrorLoginMessage("Please enter your login");
    }

    @Test
    void emptyPassTest() {
        loginWindow.openLoginWindow()
                .typeLogin(userWrongLogin.getLogin())
                .typePassword(userWrongLogin.getPass())
                .submitLoginForm();
        loginWindow.checkErrorLoginMessage("Please enter your login");
    }

}
