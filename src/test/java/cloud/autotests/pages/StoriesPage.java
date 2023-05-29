package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static cloud.autotests.config.Project.isWebMobile;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StoriesPage {

    SelenideElement storiesLike =  $("#stories-window-like");
    @Step("Открыть первую сториз")
    public StoriesPage openStories() {
        if (isWebMobile()) {
            $("#menu_icon_title").click();
            $(".close-bottom-plank-plank").click();
            $(".stories-plank").shouldHave(cssClass("active"));
            $(".plank-content").click();
        }
        else
        $(".stories-cont a").click();
        return this;
    }

    @Step("Проверить, что сториз открылась, есть кнопки Поделиться, Лайк и Колич просмотров")
    public StoriesPage checkOpenedStories() {

        $("#stories-window-view").shouldBe(visible);
        storiesLike.shouldBe(visible).click();
        storiesLike.shouldHave(cssClass("sel"));
        $("#stories-window-share").shouldBe(visible).click();
        return this;
    }
}
