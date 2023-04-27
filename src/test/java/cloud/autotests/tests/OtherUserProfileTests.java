package cloud.autotests.tests;

import cloud.autotests.pages.*;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

@Tag("general")
public class OtherUserProfileTests extends TestBase {

    SomeoneProfilePage userProfilePage = new SomeoneProfilePage();
    LoginWindow loginWindow = new LoginWindow();
    PhotoPage photoPage = new PhotoPage();
    MyFavoritesPage myFavoritesPage = new MyFavoritesPage();
    LikePage likePage = new LikePage();

    @Test
    void checkTimeInProfile() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        userProfilePage.getTimeWhenUserWasOnline(configW2H.userForeverOffline(),
                configW2H.userForeverOfflineTime());
    }

    @Test
    void viewPhotoInProfile() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        userProfilePage.openPhotoByClickOnAvatar(configW2H.userWithPhoto());
        photoPage.clickOnRightArrows();
        //TODO возможно стоит придумать что-то более универсальное
        //проверяем что переключились на нужную фотку
        webdriver().shouldHave(urlContaining("photo-78955672"));
        photoPage.clickOnLeftArrows();
        photoPage.clickOnLeftArrows();
        webdriver().shouldHave(urlContaining("photo-78955663"));
        $("#photo_img_prev .photo").shouldHave(Condition.attributeMatching("src", ".*BMlPV8c6Mg.jpg"));

    }

    @Test
    void addDellFavorites() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());

        userProfilePage.clickFavorites(configW2H.userWithPhoto());
        myFavoritesPage.openFavoritesPage()
                .checkThatUserInFavorites(configW2H.userWithPhoto());
        // удалили из избранных
        userProfilePage.clickFavorites(configW2H.userWithPhoto());

        myFavoritesPage.openFavoritesPage()
                .checkThatUserISntInFavorites(configW2H.userWithPhoto());
    }

    @Test
    void sendCancelLikeFromProfile() {
        loginWindow.loginByAuthKey(configW2H.userVipAuthKey());
        userProfilePage.clickLike(configW2H.userWithPhoto());
        likePage.openSentLikesPage()
                .checkThatUserInSentLikesOnFisrtPlace(configW2H.userWithPhoto());
        userProfilePage.clickLike(configW2H.userWithPhoto());
        likePage.openSentLikesPage()
                .checkThatUserISntInSentLikes(configW2H.userWithPhoto());
    }


}
