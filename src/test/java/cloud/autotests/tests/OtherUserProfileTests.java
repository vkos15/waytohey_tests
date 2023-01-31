package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.ProfilePage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

@Tag("general")
public class OtherUserProfileTests extends TestBase {

    ProfilePage userProfilePage = new ProfilePage();
    LoginWindow loginWindow = new LoginWindow();

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
        userProfilePage.clickOnRightArrows();
        //TODO возможно стоит придумать что-то более универсальное
        //проверяем что переключились на нужную фотку
        webdriver().shouldHave(urlContaining("photo-78955672"));
        userProfilePage.clickOnLeftArrows();
        userProfilePage.clickOnLeftArrows();
        webdriver().shouldHave(urlContaining("photo-78955663"));
        $("#photo_img_prev .photo").shouldHave(Condition.attributeMatching("src", ".*BMlPV8c6Mg.jpg"));

    }


}
