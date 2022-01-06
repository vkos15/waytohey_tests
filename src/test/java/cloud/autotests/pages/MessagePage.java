package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MessagePage {

    @Step("Открываем окно сообщений")
    public void openMessageWindow() {
        $("#mess_link").scrollIntoView(true).click();
    }

    @Step("Поиск в списке контактов")
    public void searchContacts(String searchQuery) {
        $("#search_contacts input[name='search']").setValue(searchQuery)
                .pressEnter();
    }

    @Step("Проверяем результат поиска в списке контактов")
    public void checkResultsOfSearch(String searchQuery) {
        $("#contact_list").shouldHave(text(searchQuery));
    }

    @Step("Проверяем количество контактов в результатах поиска")
    public void checkCountOfUsers(int count) {
        $$("#contact_list div.contact_el").shouldHave(size(count));
    }

    @Step("Проверяем, что открылся диалог с заданным пользователем")
    public void checkThatChanOpen(String userLogin) {
        //проверили что в заголовке ссылка на юзера, с которым открыт диалог
        $("#chat_top .top_title").shouldHave(attributeMatching("href", ".*" + userLogin + ".*"));
    }
}
