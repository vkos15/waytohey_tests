package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginWindow {

    private SelenideElement login = $("#input_login");
    private SelenideElement password = $("#input_pass");
    private SelenideElement submitLogin = $("#form_login [type='submit'].accept_btn");

    @Step("Открываем окно логина")
    public LoginWindow openLoginWindow() {
        open("#login");
        return this;
    }

    @Step("Указываем логин")
    public LoginWindow typeLogin(String login) {
        this.login.setValue(login);
        return this;
    }

    @Step("Указываем пароль")
    public LoginWindow typePassword(String password) {
        this.password.setValue(password);
        return this;
    }

    @Step("Войти")
    public void submitLoginForm() {
        submitLogin.click();
    }

    @Step("Проверяем сообщение об ошибке")
    public LoginWindow checkErrorLoginMessage(String error) {
        $("#input_login+i.error_message").shouldBe(visible).shouldHave(text(error));
        return this;
    }

    @Step("Входим по логину {login} и паролю {password}")
    public void login(String login, String password) {
        open("https://waytohey.com/#login");
        this.login.setValue(login);
        this.password.setValue(password);
        submitLogin.click();
        acceptCookies();
    }

    @Step("Принять Cookies")
    void acceptCookies() {
        $("#gdpr_popup [value='Accept']").click();
    }

    public void loginByAuthKey(String authKey) {
        open(authKey);
        acceptCookies();
    }


}
