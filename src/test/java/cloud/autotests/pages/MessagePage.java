package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static cloud.autotests.config.Project.isWebMobile;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MessagePage {

    private SelenideElement mess_link = $("#mess_link");

    @Step("Открыть окно сообщений")
    public void openMessageWindow() {
        if (isWebMobile()) {
            $("#menu_icon_title").click();
            mess_link.scrollIntoView(true).click();
        } else
            mess_link.scrollIntoView(true).click();
        $("#messages_window").shouldBe(visible);
    }

    @Step("Поиск в списке контактов")
    public void searchContacts(String searchQuery) {
        $("#search_contacts input[name='search']").setValue(searchQuery)
                .pressEnter();
    }

    @Step("Проверить результат поиска в списке контактов")
    public void checkResultsOfSearch(String searchQuery) {
        $("#contact_list").shouldHave(text(searchQuery));
    }

    @Step("Проверить количество контактов в результатах поиска")
    public void checkCountOfUsers(int count) {
        $$("#contact_list div.contact_el").shouldHave(size(count));
    }

    @Step("Проверить, что открылся диалог с заданным пользователем")
    public MessagePage checkThatChanOpen(String userLogin) {
        //проверили что в заголовке ссылка на юзера, с которым открыт диалог
        $("#chat_top .top_title").shouldHave(attributeMatching("href", ".*" + userLogin + ".*"));
        $("#messages_window").shouldBe(visible);
        return this;
    }

    @Step("Открыть меню в диалоге")
    public MessagePage openChatSetting() {
        $("#chat_settings").click();
        return this;
    }

    @Step("Выбрать Сделать подарок в чате")
    public GiftPage chooseSendGiftInMEnu() {

        $(byText("Send Gift")).click();
        return new GiftPage();
    }
}
