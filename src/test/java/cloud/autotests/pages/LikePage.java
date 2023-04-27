package cloud.autotests.pages;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;

import static cloud.autotests.config.Project.isWebMobile;
import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LikePage {

    @Step("Открыть раздел Мне нравятся")
    public LikePage openSentLikesPage() {
        if (isWebMobile()) {
            $("#menu_icon_title").click();
        }

        $(byText("My likes")).click();
        $(byText("Sent likes")).click();
        $("#header .top_title").shouldHave(text("Sent likes"));
        return this;
    }

    @Step("Проверить, что юзер в списке отправленных лайков на первом месте")
    public void checkThatUserInSentLikesOnFisrtPlace(String userLogin) {
        $("#isympathy_list .td_info a").shouldHave(attributeMatching("href", ".*" + userLogin + ".*"));
    }

    @Step("Проверить, что юзера с заданным логином нет в списке отправленных лайков")
    public void checkThatUserISntInSentLikes(String userLogin) {
        $$("#isympathy_list .td_info a[href*=" + userLogin + "]").shouldHave(CollectionCondition.size(0));
    }
}


