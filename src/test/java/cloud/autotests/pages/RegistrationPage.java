package cloud.autotests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement textInformation = $("#staged_reg_partner");
    private SelenideElement imageLogo = $("#form_logo img");
    private final static String TEXT_ON_MAIN_PAGE_PRODW2H = "WayToHey — Social network for connecting singles";
    private final static String TEXT_ON_MAIN_PAGE_PRODLOVERU = "Dating on Love.ru";
    private final static String TEXT_ON_MAIN_PAGE_TEST = "Irish social network for connecting people";

    @Step("Открываем главную страницу")
    public RegistrationPage openMainPage() {
        open("");

        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie(configW2H.cookieName(), configW2H.cookieValue()));

        return this;
    }

    @Step("Проверяем текст на главной")
    public RegistrationPage checkTextonMainPage() {
        if (System.getProperty("environment").equals("prodw2h"))
            textInformation.shouldHave(Condition.text(TEXT_ON_MAIN_PAGE_PRODW2H));
        else if (System.getProperty("environment").equals("prodloveru"))
            textInformation.shouldHave(Condition.text(TEXT_ON_MAIN_PAGE_PRODLOVERU));
        else
            textInformation.shouldHave(Condition.text(TEXT_ON_MAIN_PAGE_TEST));
        return this;
    }

    @Step("Проверяем наличие логотипа ")
    public RegistrationPage checkLogoOnMainPage() {
        imageLogo.shouldBe(Condition.visible).shouldHave(Condition.attributeMatching("src", ".*.svg"));
        return this;
    }

    @Step("Указываем имя ")
    public RegistrationPage fillName(String name) {
        $("#input_name").setValue(name);
        return this;
    }

    @Step("Указываем email ")
    public RegistrationPage fillEmail(String email) {
        $("#input_email").setValue(email);
        return this;
    }

    @Step("Зарегистрироваться")
    public void clickSubmit() {
        $(byValue("Sign up")).click();
    }

    @Step("Проверяем ошибку в имени")
    public RegistrationPage checkErrorName(String error) {
        $("#input_name+i.error_message").shouldBe(visible).shouldHave(text(error));
        return this;
    }

    @Step("Проверяем ошибку в email")
    public RegistrationPage checkErrorEmail(String error) {
        $("#input_email+i.error_message").shouldBe(visible).shouldHave(text(error));
        return this;
    }

    @Step("Проверяем наличие ссылки на соглашение")
    public RegistrationPage checkAgreement() {
        $("#reg_regul").shouldHave(text("I agree with Terms of Service and Privacy Policy"));
        return this;
    }

    @Step("Проверяем, что появилась кнопка Желаете войти в эту анкету? при указании существующего емаил")
    public RegistrationPage checkButtonExistEmail() {
        $(".mail_dup_login").shouldHave(text("Log in to your profile"));
        return this;
    }

    @Step("Нажимаем Продолжить на 2м этапе регистрации")
    public ConfirmWindow clickContinue() {
        $(byValue("Continue")).click();
        return new ConfirmWindow();
    }


    @Step("Открываем пользовательское соглашение")
    public RegistrationPage openTermsService() {
        $(byText("Terms of Use")).click();
        return this;
    }

    public RegistrationPage checkTermOfService() {
        $("#window_title").shouldHave(text("Terms of Service"));
        $("#agreement_content").shouldHave(text("Edited by: 01/Aug/2022"))
                .shouldHave(text("General Terms"))
                .shouldHave(text("Registration. User's personal profile."))
                .shouldHave(text("Modification and termination of the Service"))
                .shouldHave(text("Rights and obligations"))
                .shouldHave(text("Purchases. Refunds"))
                .shouldHave(text("Responsibility"))
                .shouldHave(text("Personal data"))
                .shouldHave(text("Rights to the protected results of intellectual activity and instruments of individualization"))
                .shouldHave(text("Other conditions"));
        return this;
    }


    public RegistrationPage openPrivacyPolicy() {
        $(byText("Privacy Policy")).click();
        return this;
    }


    public RegistrationPage closePrivacyTerm() {
        $("a.close_window").click();
        return this;
    }

    public RegistrationPage checkPrivacyPolicy() {
        $("#window_title").shouldHave(text("Privacy policy"));
        $("#agreement_content").shouldHave(text("Edited by: 19/Aug/2022"))
                .shouldHave(text("GENERAL TERMS"))
                .shouldHave(text("Principles of personal data processing"))
                .shouldHave(text("Content of the Information that is collected and processed by the Operator"))
                .shouldHave(text("Purposes of collecting and processing Information"))
                .shouldHave(text("Processing Personal data"))
                .shouldHave(text("Confidentiality of personal data"))
                .shouldHave(text("User rights"))
                .shouldHave(text("Data protection measures"))
                .shouldHave(text("Concluding Provisions"));
        return this;
    }

    @Step("Проверяем, что плашка Принять Cookies не отображается на странице ")
    public void checkGDPRisNotVisible() {
        $("#gdpr_popup").shouldNotBe(visible);
    }

    @Step("Проверяем, что плашка Принять Cookies отображается на странице ")
    public void checkGDPRisVisible() {
        $("#gdpr_popup").shouldBe(visible);
    }

    @Step("Принять Cookies")
    public void acceptCookies() {
        $("#gdpr_popup [value='Accept']").click();
    }


    @Step("Войти через ВК ")
    public void authVK(String log, String pass) {

        $("#index_social_icons").$(byValue("VK")).click();
        $(byName("login")).setValue(log);
        $(byText("Continue")).click();
        $(byName("password")).setValue(pass);
        $(byText("Continue")).click();
        $("button[data-test-id=continue-as-button]").click();
    }

    @Step("Нажать Другие варианты входа ")
    public RegistrationPage clickOtherOptions() {
        $(".social_show_more").click();
        return this;
    }

    @Step("Войти через mail ")
    public void authMail(String log, String pass) {

        $("#index_social_icons").$(byValue("MR")).click();
        $("#login").setValue(log);
        $("#password").setValue(pass);
        $("[type='submit']").click();
    }

    @Step("Войти через OK ")
    public void authOK(String log, String pass) {

        $("#index_social_icons").$(byValue("OK")).click();
        $("#field_email").setValue(log);
        $("#field_password").setValue(pass);
        $("[type='submit']").click();
    }

    @Step("Нажать Продолжить на экране входа через соц сети, если анкет несколько ")
    public void chooseFirstProfileInList() {
        $(".accept_btn").click();
    }

    @Step("Войти через OK ")
    public void authYA(String log, String pass) {

        $("#index_social_icons").$(byValue("YA")).click();
        $(".LoginWithPhonePage-controls").click();
        $("#passp-field-login").setValue(log);
        $("[id='passp:sign-in']").click();
        $("#passp-field-passwd").setValue(pass);
        $("[id='passp:sign-in']").click();


    }


}
