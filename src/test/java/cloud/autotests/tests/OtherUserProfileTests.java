package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.PhotoPage;
import cloud.autotests.pages.SomeoneProfilePage;
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


}
