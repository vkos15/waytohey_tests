package cloud.autotests.tests;

import cloud.autotests.pages.ConfirmWindow;
import cloud.autotests.pages.RegistrationPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static cloud.autotests.testdata.TestData.emailRandom;
import static cloud.autotests.testdata.TestData.nameRandom;


public class MainPageTest extends TestBase {

    RegistrationPage regPage = new RegistrationPage();
    ConfirmWindow confirmWindow = new ConfirmWindow();


    @Test
    @Tag("general")
    void mainPageTestText() {
        regPage.openMainPage()
                .checkTextonMainPage();
    }

    @Test
    @Tag("general")
    void mainPageTestLogo() {
        regPage.openMainPage()
                .checkLogoOnMainPage();
    }

    @Test
    @Tag("reg by email")
    @Tag("w2h")
    void submitEmptyForm() {
        regPage.openMainPage()
                .clickSubmit();
        regPage.checkErrorName("Specify your name")
                .checkErrorEmail("Enter your email");
    }

    @Test
    @Tag("reg by email")
    @Tag("w2h")
    void regWithExistEmail() {
        regPage.openMainPage()
                .fillName("test")
                .fillEmail(configW2H.existEmail())
                .clickSubmit();
        regPage.checkErrorEmail("This email is already in use");
        regPage.checkButtonExistEmail();
    }

    @Test
    @Tag("reg by email")
    @Tag("w2h")
    void regWithCorrectData() {
        regPage.openMainPage()
                .fillName(nameRandom)
                .fillEmail(emailRandom)
                .clickSubmit();
        regPage.clickContinue();
        confirmWindow.checkTextAndPicture();

    }

}
