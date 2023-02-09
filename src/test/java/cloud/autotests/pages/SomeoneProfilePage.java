package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SomeoneProfilePage {
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

        $("#pgift").click();
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

}
