package cloud.autotests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement textInformation = $("#staged_reg_partner");
    private SelenideElement imageLogo = $("#form_logo img");
    private final static String TEXT_ON_MAIN_PAGE_PRODW2H = "WayToHey — Social network for connecting singles";
    private final static String TEXT_ON_MAIN_PAGE_PRODLOVERU = "Dating site Love.ru";
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
        $("#mail_dup_login").shouldHave(text("Sign in to your profile?"));
        return this;
    }

    @Step("Нажимаем Продолжить на 2м этапе регистрации")
    public ConfirmWindow clickContinue() {
        $(byValue("Continue")).click();
        return new ConfirmWindow();
    }


    @Step("Открываем пользовательское соглашение")
    public RegistrationPage openTermsService() {
        $(byText("Terms of Service")).click();
        return this;
    }

    public RegistrationPage openPrivacyPolicy() {
        $(byText("Privacy Policy")).click();
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


}
