package cloud.autotests.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static cloud.autotests.config.Project.isWebMobile;
import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MyFavoritesPage {

    SelenideElement favoritesInMenu = $(byText("Favorites"));

    @Step("Открыть раздел Мои избранные")
    public MyFavoritesPage openFavoritesPage() {
        if (isWebMobile()) {
            $("#menu_icon_title").click();
        }
        favoritesInMenu.scrollIntoView(true).click();
        $(byText("My Favorites")).click();
        $("#header .top_title").shouldHave(text("My Favorites"));
        return this;
    }

    @Step("Проверить, что юзер в списке избранных на первом месте")
    public void checkThatUserInFavorites(String userLogin) {
        $("#icontacts .td_info a").shouldHave(attributeMatching("href", ".*" + userLogin + ".*"));
    }

    @Step("Проверить, что юзера с заданным логином нет в списке избранных")
    public void checkThatUserISntInFavorites(String userLogin) {
        $$("#icontacts .td_info a[href*=" + userLogin + "]").shouldHave(CollectionCondition.size(0));
    }
}
