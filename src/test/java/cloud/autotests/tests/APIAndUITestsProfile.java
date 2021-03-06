package cloud.autotests.tests;

import cloud.autotests.enums.Orientations;
import cloud.autotests.enums.Religions;
import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.ProfilePage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.restassured.RestAssured.given;

public class APIAndUITestsProfile extends TestBase {

    ProfilePage profilePage = new ProfilePage();
    LoginWindow loginWindow = new LoginWindow();

    @Test
    void profileOrientation() {

        //авторизовались
        loginWindow.loginByAuthKey(configW2H.authKeyUser());

        //получили cookies
        String cookie_csrf = WebDriverRunner.getWebDriver().manage().getCookieNamed("csrf").getValue();
        String cookie_mlsid = WebDriverRunner.getWebDriver().manage().getCookieNamed("MLSID").getValue();

        //отправляем запрос на указание ориентации в анкете
        given()
                .contentType("application/x-www-form-urlencoded")
                //.accept("*/*")
                .cookie("csrf", cookie_csrf).and().cookie("MLSID", cookie_mlsid)
                // .formParams("orientation","b").relaxedHTTPSValidation()
                .queryParam("action", "save-profile")
                .body("csrf=" + cookie_csrf + "&orientation=u")
                .when()
                .post(url() + "/edit/aboutsex/")
                .then()
                .statusCode(200);

        //удаляем из профиля информацию
        profilePage.editOrientationInProfile(Orientations.NO_MATTER)
                .checkOrientationInProfile(Orientations.NO_MATTER);
    }

    @Test
    void profileDeleteReligion() {

        loginWindow.loginByAuthKey(configW2H.authKeyUser());

        //получили cookies
        String cookie_csrf = WebDriverRunner.getWebDriver().manage().getCookieNamed("csrf").getValue();
        String cookie_mlsid = WebDriverRunner.getWebDriver().manage().getCookieNamed("MLSID").getValue();

        //заполняем религию в анкете
        given()
                .contentType("application/x-www-form-urlencoded")
                //.accept("*/*")
                .cookie("csrf", cookie_csrf).and().cookie("MLSID", cookie_mlsid)
                // .formParams("orientation","b").relaxedHTTPSValidation()
                .queryParam("action", "save-profile")
                .body("csrf=" + cookie_csrf + "&religion=a")
                .when()
                .post(url() + "/edit/type/")
                .then()
                .statusCode(200);

        //удаляем из профиля информацию о религии
        profilePage.editReligionInProfile(Religions.NO_MATTER)
                .checkReligionInProfile(Religions.NO_MATTER);
    }
}
