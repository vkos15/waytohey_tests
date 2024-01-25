package cloud.autotests.tests;

import cloud.autotests.enums.Purposes;
import cloud.autotests.pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;


public class EncountersTests extends TestBase {

    Encounters encountersPage = new Encounters();
    LikePage likePage = new LikePage();
    LoginWindow loginWindow = new LoginWindow();
    EncountersSettings encountersSettings = new EncountersSettings();
    BottomBar bottomBar = new BottomBar();

    @Tag("general")
    @Test
        //Проверяем, что открываются симпатии без авторизации
    void encountersPageUnauthorizedUser() {
        encountersPage.openEncounters()
                .checkContentUnAuthorized();
    }

    @Tag("general")
    @Test
        //Проверяем, что открываются симпатии для авторизованного
    void encountersPageAuthorizedUser() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        encountersPage.openEncountersFromMenu()
                .checkContentAuthorized();
    }

    @Tag("general")
    @Test
    @DisplayName("Проверка настроек симпатий")
    void encountersCheckSettings() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        encountersPage.openEncounters()
                .openSettings()
                .checkListLikeSettings();
    }


   // @Tag("w2h")// don't work with love.ru - because now we can't change target
    @Test
    @DisplayName("Изменение настроек симпатий")
    void encountersChangeSettings() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        encountersPage.openEncounters()
                .openSettings()
                .resetLikeSettings(); //сбросили настройки симпатий
        encountersPage.openSettings() //cнова открыли симпатии
                .changeLikeSettings("Women", "42", "47",
                        Purposes.FLIRTING, "Moscow", false);
        encountersPage.openSettings()
                .checkThatLikeSettingsSaved("Women", "42", "47",
                        Purposes.FLIRTING, "Moscow", false);//cнова открыли симпатии и проверили что настройки сохранились

        encountersSettings.resetLikeSettings();//после теста сбросили настройки симпатий
    }

    @Test
    @DisplayName("Дизлайк и отмена дизлайка в симпатиях")
    void encountersDislikeTest() {
        loginWindow.loginByAuthKey(configW2H.userVipAuthKey());

        String href = encountersPage.openEncounters()
                .clickSkip();
        encountersPage.openEncounters()
                .cancelSkip();
        encountersPage.checkCurrentUserInEncounters(href);

    }

    @Test
    @DisplayName("Лайк в симпатиях")
    void encountersLikeTest() {
        loginWindow.loginByAuthKey(configW2H.userVipAuthKey());

        String href = encountersPage.openEncounters()
                .clickLike();
        likePage.openSentLikesPage()
                .checkThatUserInSentLikesOnFisrtPlace(href);


    }


}
