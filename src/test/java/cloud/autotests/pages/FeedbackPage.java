package cloud.autotests.pages;

import io.qameta.allure.Step;

import static cloud.autotests.config.Project.isWebMobile;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FeedbackPage {

    @Step("Открыть раздел Помощь")
    public FeedbackPage openHelp() {
        if (isWebMobile()) {
            $("#menu_icon_title").click();
        }
        $(byText("Help")).click();
        return this;
    }

    @Step("Выбрать категорию")
    public FeedbackPage chooseCategory(String textCategory) {
        $(byText(textCategory)).scrollTo().click();
        $("#feedback h2").shouldHave(text(textCategory));
        return this;
    }

    @Step("Ввести текст")
    public FeedbackPage textMessage(String textMessage) {
        $(byName("message")).setValue(textMessage);
        return this;
    }

    @Step("Нажать Отправить")
    public void sendMessage() {
        $("#feedback .block_save").shouldHave(value("Send")).click();
    }

    @Step("Прикрепить файл")
    public FeedbackPage addImage(String fileName) {
        $("input[type='file']").uploadFromClasspath(fileName);
        return this;
    }

    @Step("Удалить вопрос")
    public void deleteQuestion() {
        $("#feedback input[value='Delete']").click();
    }


}
