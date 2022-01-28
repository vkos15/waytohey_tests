package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmWindow {

    private static final String TEXT_IN_CONFIRM_WINDOW = "Please check your inbox. Do not forget to check Spam folder.";

    @Step("Проверить картинку и текст в окне")
    public ConfirmWindow checkTextAndPicture() {
        $("#confirm #confirm_pic img").shouldBe(visible);
        $("#confirm").shouldHave(text(TEXT_IN_CONFIRM_WINDOW));
        return this;
    }
}
