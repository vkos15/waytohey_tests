package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Encounters {
    @Step("Открыть страницу симпатий")
    public Encounters openEncounters() {
        open("encounters/");
        return this;
    }

    @Step("Проверка контента на странице симпатий")
    public Encounters checkContent() {
        $("#sym_photo_cont").shouldBe(visible);
        $("#gallery_block").shouldBe(visible);
        return this;
    }


}
