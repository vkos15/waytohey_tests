package cloud.autotests.pages;


import cloud.autotests.enums.Interests;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    public ProfilePage changeStatus(String status) {
        $("#mood a").click();
        $("#mood_cont").$(withText(status)).click();
        return this;
    }

    public void checkStatus(String status) {
        $("#profile_view_mood").shouldHave(text(status)).shouldBe(visible);
    }

    public ProfilePage changeAboutMe(String aboutMe) {
        $("#aboutme a").scrollIntoView(true).click();
        $("textarea[name='about']").shouldBe(visible).setValue(aboutMe);
        $("#ieditsubmit").click();

        return this;
    }

    public void checkAboutMe(String aboutMe) {
        $("#profile_view_aboutme").shouldHave(text(aboutMe)).shouldBe(visible);

    }

    public ProfilePage selectInterest(Interests interest) {
        $("#interest a").scrollIntoView(true).click();
        $("#allowed_interests").shouldBe(visible).$(byText(interest.getDescription())).click();
        $(".interest_confirm").click();
        return this;
    }

    public void checkThatInterestAdd(Interests interest) {
        $("#profile_view_interest").shouldHave(text(interest.getDescription())).shouldBe(visible);
    }

    @Step("Проверяем, что в профиле отображается логин")
    public void checkLoginIsVisibleInProfile(String login) {
        $("#ivisitcard_info").shouldHave(text(login)).shouldBe(visible);
    }


}
