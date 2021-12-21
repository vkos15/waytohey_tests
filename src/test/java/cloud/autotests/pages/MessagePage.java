package cloud.autotests.pages;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MessagePage {
    public void openMessageWindow() {
        $("#mess_link").scrollIntoView(true).click();
    }


    public void searchContacts(String searchQuery) {
        $("#search_contacts input[name='search']").setValue(searchQuery)
                .pressEnter();
    }

    public void checkResultsOfSearch(String searchQuery) {
        $("#contact_list").shouldHave(text(searchQuery));
    }

    public void checkCountOfUsers(int count) {
        $$("#contact_list div.contact_el").shouldHave(size(count));
    }

    public void checkThatChanOpen(String userLogin) {
        //проверили что в заголовке ссылка на юзера, с которым открыт диалог
        $("#chat_top .top_title").shouldHave(attributeMatching("href",".*"+userLogin+".*"));
    }
}
