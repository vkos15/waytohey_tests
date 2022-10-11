package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

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

    @Step("Проверяем сообщение об ошибке")
    public LoginWindow checkErrorPasswordMessage(String error) {
        $("#input_pass+i.error_message").shouldBe(visible).shouldHave(text(error));
        return this;
    }

    @Step("Входим под пользователем {login} ")
    public void login(String login, String password) {
        open("#login");
        this.login.shouldBe(visible).setValue(login);
        this.password.setValue(password);
        submitLogin.click();
        $("#ivisitcard_info").shouldBe(visible);
        sleep(100);
    }

    @Step("Логин по authKey")
    public void loginByAuthKey(String authKey) {
        if (!System.getProperty("environment").contains("prod"))
            open(authKey, "", configW2H.authLogin(), configW2H.authPass());
        else open(authKey);
    }


}
