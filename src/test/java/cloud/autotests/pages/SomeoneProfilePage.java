package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SomeoneProfilePage {

    private SelenideElement iconFav = $("#pfav");
    private SelenideElement profileLikeBtn = $(".profile-like-button");
    private SelenideElement message = $("#show_info");

    @Step("Открываем фото юзера кликом на аватарку")
    public PhotoPage openPhotoByClickOnAvatar(String userLogin) {
        open(userLogin);
        $("#visitcard_avatar").click();
        $("#photo_win .iphoto_img").shouldBe(visible);
        return new PhotoPage();
    }


    @Step("Проверка времени, когда юзер был онлайн последний раз")
    public SomeoneProfilePage getTimeWhenUserWasOnline(String userLogin, String expectedTime) {
        open(userLogin);
        $("#visitcard_info .user_onoff_status").click();
        //только таким способом удается уловить всплывающее на 2 сек сообщение, получаем из него
        //текст, затем проверяем с ожидаемым
        String visibleTime = $("#show_info").shouldBe(visible).getOwnText();
        assertThat(visibleTime).contains(expectedTime);
        // isEqualTo(expectedTime);
        return this;
    }

    @Step("Открываем окно дарения гифта в чужой анкете")
    public GiftPage openGiftWindow(String userLogin) {
        System.out.println(userLogin);
        open(userLogin);

        $("#gift_list_container .send_gift").click();
        $("#pay_surprise_window").shouldBe(visible);
        return new GiftPage();
    }

    @Step("Написать в чужой анкете")
    public MessagePage openMessageFromProfile(String userLogin) {
        System.out.println(userLogin);
        open(userLogin);
        $("#pmess").click();
        return new MessagePage();
    }

    @Step("Нажать на иконку избранные в чужой анкете")
    public SomeoneProfilePage clickFavorites(String userLogin) {
        open(userLogin);
        String isFav = iconFav.attr("data-isfav"); //атрибут показывающий в избранных ли юзер
        iconFav.click();
        String infoMessage = message.shouldBe(visible).getOwnText();
        //всплывающее сообщение в зависимости от того добавили или удалили юзера из избранных
        if (isFav == "false") {
            assertThat(infoMessage).isEqualTo("User added to Favorites");
        } else if (isFav == "true") {
            assertThat(infoMessage).isEqualTo("User removes from Favorites");
        }
        return this;
    }

    @Step("Нажать на иконку симпатии в чужой анкете")
    public SomeoneProfilePage clickLike(String userLogin) {
        open(userLogin);
        String isLikeSent = profileLikeBtn.attr("class");
        profileLikeBtn.click();
        String infoMessage = message.shouldBe(visible).getOwnText();
        if (isLikeSent.contains("symp_sent")) {
            assertThat(infoMessage).contains("You don't like");
        } else assertThat(infoMessage).contains("You liked");
        return this;
    }

    @Step("Открыть первый гифт в анкете")
    public GiftPage openFirstGift() {
        $(".gift_list a").click();
        return new GiftPage();
    }

}
