package cloud.autotests.tests;

import cloud.autotests.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.waytohey.WaytoheyProject.configW2H;
import static cloud.autotests.testdata.TestData.emailRandom;
import static cloud.autotests.testdata.TestData.nameRandom;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


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
                .fillEmail(configW2H.exist_email())
                .clickSubmit();
        regPage.checkErrorEmail("This email is already in use");
        $("#mail_dup_login").shouldHave(text("Sign in to your profile?"));

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
