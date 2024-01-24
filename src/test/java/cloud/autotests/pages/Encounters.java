package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static cloud.autotests.config.Project.isWebMobile;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class Encounters {

    BottomBar bottomBar = new BottomBar();
    SelenideElement linkUser = $("#name span");

    @Step("Открыть страницу симпатий по ссылке")
    public Encounters openEncounters() {
        open("encounters/");
        return this;
    }

    @Step("Проверка контента на странице симпатий без авторизации")
    public Encounters checkContentUnAuthorized() {
        $("#gallery_block").shouldBe(visible);
        $("#isympathy_photo").shouldBe(visible);
        $("#sympathy_guide").shouldBe(visible);
        return this;
    }

    @Step("Проверяем контент на страничке симпатий, когда результаты поиска есть")
    public Encounters checkContentAuthorized() {
        $("#gallery_block").shouldBe(visible);
        $("#sym_photo_cont").shouldBe(visible);
        $("#name").scrollIntoView(true).shouldBe(visible);
        $("#year").scrollIntoView(true).shouldBe(visible);
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
        $(".user-menu-settings").click();
        $("#search_form").shouldBe(visible, Duration.ofSeconds(5));
        return new EncountersSettings();
    }

    @Step("Открываем симпатии из главного меню")
    public Encounters openEncountersFromMenu() {
        if (isWebMobile())
            bottomBar.openMenu();
        $("#like_link").click();
        return this;
    }

    @Step("Нажать Пропустить в симпатиях")
    //возвращает ссылку на пропущенного пользователя
    public String clickSkip() {
        //  String href = $("#name span").getAttribute("data-href");
        $("#sympathy_btn_reject").click();
        return linkUser.getAttribute("data-href");
    }

    @Step("Отмена дизлайка в симпатиях")
    public String cancelSkip() {
        $("#sym_prev_next a").click();
        $(byValue("Yes")).click();
        //  String href = $("#name span").getAttribute("data-href");
        return linkUser.getAttribute("data-href");
    }

    @Step("Проверить, что в симпатиях отображается заданный пользователь - логин")
    public void checkCurrentUserInEncounters(String href) {
        //  String href = $("#name span").getAttribute("data-href");
        assertThat(href).isEqualTo(linkUser.getAttribute("data-href"));
    }


}
