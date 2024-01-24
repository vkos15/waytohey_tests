package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.MyProfilePage;
import cloud.autotests.pages.RegistrationPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.testdata.TestData.userSuccess;
import static cloud.autotests.testdata.TestData.userWrongLogin;

@Tag("general")
public class LoginTest extends TestBase {

    LoginWindow loginWindow = new LoginWindow();
    MyProfilePage profilePage = new MyProfilePage();
    RegistrationPage regPage = new RegistrationPage();

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
        loginWindow.checkErrorLoginMessage("User with this username doesn't exist");
    }

    @Test
    void emptyLoginTest() {
        loginWindow.openLoginWindow()
                .typePassword(userWrongLogin.getPass())
                .submitLoginForm();
        loginWindow.checkErrorLoginMessage("Please enter your login");
    }

    @Test
    void emptyPassTest() {
        loginWindow.openLoginWindow()
                .typeLogin(userWrongLogin.getLogin())
                .submitLoginForm();
        loginWindow.checkErrorPasswordMessage("Enter the password");
    }

    @Test
    void checkGDPRisNotVisibleAfterLogin() {
        //проверили что без авторизации плашка GDPR отображается
        regPage.openMainPage()
                        .checkGDPRisVisible();
        loginWindow.openLoginWindow()
                .typeLogin(userSuccess.getLogin())
                .typePassword(userSuccess.getPass())
                .submitLoginForm();
        //проверили что что после авторизации плашка GDPR не отображается
        regPage.checkGDPRisNotVisible();
    }
}
