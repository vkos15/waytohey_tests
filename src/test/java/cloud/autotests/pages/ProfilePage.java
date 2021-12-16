package cloud.autotests.pages;


import cloud.autotests.enums.Interests;
import cloud.autotests.enums.Orientations;
import cloud.autotests.enums.Religions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    @Step("Указываем статус в анкете")
    public ProfilePage changeStatus(String status) {
        $("#mood a").click();
        $("#mood_cont").$(withText(status)).click();
        return this;
    }

    @Step("Проверка статуса в анкете")
    public void checkStatus(String status) {
        $("#profile_view_mood").shouldHave(text(status)).shouldBe(visible);
    }

    @Step("Заполняем раздел Обо мне")
    public ProfilePage changeAboutMe(String aboutMe) {
        $("#aboutme a").scrollIntoView(true).click();
        $("textarea[name='about']").shouldBe(visible).setValue(aboutMe);
        $("#ieditsubmit").click();

        return this;
    }

    @Step("Проверяем текст в разделе Обо мне")
    public void checkAboutMe(String aboutMe) {
        $("#profile_view_aboutme").shouldHave(text(aboutMe)).shouldBe(visible);

    }

    @Step("Выбираем интерес в анкете")
    public ProfilePage selectInterest(Interests interest) {
        $("#interest a").scrollIntoView(true).click();
        $("#allowed_interests").shouldBe(visible).$(byText(interest.getDescription())).click();
        $(".interest_confirm").click();
        return this;
    }

    @Step("Проверяем, что интерес добавлен в анкету")
    public void checkThatInterestAdd(Interests interest) {
        $("#profile_view_interest").shouldHave(text(interest.getDescription())).shouldBe(visible);
    }

    @Step("Проверяем, что в профиле отображается логин")
    public void checkLoginIsVisibleInProfile(String login) {
        $("#ivisitcard_info").shouldHave(text(login)).shouldBe(visible);
    }

    @Step("Заполняем ориентацию в анкете")
    public ProfilePage editOrientationInProfile(Orientations orientation) {
        $("#aboutsex a").scrollIntoView(true).click();
        $("#redit_orientation_options").$(byText(orientation.getDescription())).click();
        $("#ieditsubmit").click();
        return this;
    }

    @Step("Проверка ориентации, указанной в анкете")
    public void checkOrientationInProfile(Orientations orientation) {
        if (!(orientation == Orientations.NO_MATTER))
        $("#profile_view_aboutsex").shouldHave(text(orientation.getDescription())).shouldBe(visible);
        else {
            $("#profile_view_aboutsex").shouldNotBe(visible);
        }
    }

    @Step("Указываем религию в анкете")
    public ProfilePage editReligionInProfile(Religions religion) {
        $("#type a").scrollIntoView(true).click();
        $("#redit_religion_options").$(byText(religion.getDescription())).click();
        $("#ieditsubmit").click();
        return this;
    }

    @Step("Указываем религию в анкете")
    public ProfilePage checkReligionInProfile(Religions religion) {
        if (!(religion == Religions.NO_MATTER))
            $("#profile_view_type").shouldHave(text("religion"))
                    .shouldHave(text(religion.getDescription()))
                    .shouldBe(visible);
         else if  ($("#profile_view_type").isDisplayed()) {
             $("#profile_view_type").shouldNotHave(text("religion"));
        }
        return this;
    }




}
