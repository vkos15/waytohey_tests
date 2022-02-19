package cloud.autotests.pages;

import io.qameta.allure.Step;

import static cloud.autotests.config.Project.isWebMobile;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Encounters {

    BottomBar bottomBar = new BottomBar();


    @Step("Открыть страницу симпатий по ссылке")
    public Encounters openEncounters() {
        open("encounters/");
        return this;
    }

    @Step("Проверка контента на странице симпатий без авторизации")
    public Encounters checkContentUnAuthorized() {
        $("#gallery_block").shouldBe(visible);
        $("div.user-menu-header.no-auth").shouldBe(visible);
        return this;
    }

    @Step("Проверяем контент на страничке симпатий, когда результаты поиска есть")
    public Encounters checkContentAuthorized() {
        $("#gallery_block").shouldBe(visible);
        $("#sym_photo_cont").shouldBe(visible);
        $("#name").scrollIntoView(true).shouldBe(visible);
        $("#year").scrollIntoView(true).shouldBe(visible);
        $(byText("City:")).scrollIntoView(true).shouldBe(visible);
        $(byText("I'm interested in:")).scrollIntoView(true).shouldBe(visible);
        return this;
    }


    @Step("Проверяем заголовок в разделе симпатий (есть только на десктопе)")
    public Encounters checkHeader() {
        if (!isWebMobile())
            $(".top_title").shouldHave(text("Encounters"));
        return this;
    }

    @Step("Открываем настройки симпатий")
    public EncountersSettings openSettings() {
        $(".top_settings").click();
        $("#search_form").shouldBe(visible);
        return new EncountersSettings();
    }

    @Step("Открываем симпатии из главного меню")
    public Encounters openEncountersFromMenu() {
        if (isWebMobile())
            bottomBar.openMenu();
        $("#like_link").click();
        return this;
    }


}
