package cloud.autotests.tests;

import cloud.autotests.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static cloud.autotests.testdata.TestData.emailRandom;
import static cloud.autotests.testdata.TestData.nameRandom;


public class MainPageTest extends TestBase {

    RegistrationPage regPage = new RegistrationPage();

    @Test
    void mainPageTestText() {
        regPage.openMainPage()
                .checkTextonMainPage();
    }

    @Test
    void mainPageTestLogo() {
        regPage.openMainPage()
                .checkLogoOnMainPage();
    }

    @Test
    void submitEmptyForm() {
        regPage.openMainPage()
                .clickSubmit();
        regPage.checkErrorName("Specify your name")
                .checkErrorEmail("Enter your email");
    }

    @Test
    void regWithExistEmail() {
        regPage.openMainPage()
                .fillName("test")
                .fillEmail(configW2H.existEmail())
                .clickSubmit();
        regPage.checkErrorEmail("This email is already in use");
        regPage.checkButtonExistEmail();
    }

    @Test
    void regWithCorrectData() {
        regPage.openMainPage()
                .fillName(nameRandom)
                .fillEmail(emailRandom)
                .clickSubmit();
        // Решить насчет капчи
    }

}
