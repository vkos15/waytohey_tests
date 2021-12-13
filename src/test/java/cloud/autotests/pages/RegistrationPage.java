package cloud.autotests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private SelenideElement textInformation = $("#staged_reg_partner");
    private SelenideElement imageLogo = $("#form_logo img");
    private final static String TEXT_ON_MAIN_PAGE = "Irish social network for connecting people Find new friends and relationship";

    @Step("Открываем главную страницу")
    public RegistrationPage openMainPage() {
        open("");
        return this;

    }

    @Step("Проверяем текст на главной")
    public RegistrationPage checkTextonMainPage() {
        textInformation.shouldHave(Condition.text(TEXT_ON_MAIN_PAGE));
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

    @Step("Открываем пользовательское соглашение")
    public RegistrationPage openTermsService() {
        $(byText("Terms of Service")).click();
        return this;
    }

    public RegistrationPage openPrivacyPolicy() {
        $(byText("Privacy Policy")).click();
        return this;
    }


}
