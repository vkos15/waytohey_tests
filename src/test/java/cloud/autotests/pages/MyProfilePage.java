package cloud.autotests.pages;


import cloud.autotests.enums.Interests;
import cloud.autotests.enums.Orientations;
import cloud.autotests.enums.Religions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class MyProfilePage {

    SelenideElement saveButton = $(".top_confirm");

    @Step("Указываем статус в анкете")
    public MyProfilePage changeStatus(String status) {
        $("#mood a").scrollIntoView("{block: \"center\"}").click();
        $(".mood_cont").$(withText(status)).click();
        $("mood_cont").shouldNotBe(visible);
        return this;
    }

    @Step("Проверка статуса в анкете")
    public void checkStatus(String status) {
        $("#profile_view_mood").scrollIntoView("{block: \"center\"}").shouldHave(text(status)).shouldBe(visible);
    }

    @Step("Заполняем раздел Обо мне")
    public MyProfilePage changeAboutMe(String aboutMe) {
        $("#aboutme a").scrollIntoView("{block: \"center\"}").shouldBe(visible).click();
        $("textarea[name='about']").scrollIntoView("{block: \"center\"}").shouldBe(visible).setValue(aboutMe);
        saveButton.click();
        return this;
    }

    @Step("Проверяем текст в разделе Обо мне")
    public void checkAboutMe(String aboutMe) {
        $("#profile_view_aboutme").scrollIntoView("{block: \"center\"}")
                .shouldHave(text(aboutMe)).shouldBe(visible);
    }

    @Step("Выбираем интерес в анкете")
    public MyProfilePage selectInterest(Interests interest) {
        $("#interest").scrollIntoView("{block: \"center\"}").shouldHave(text("Interests"));
        $("#interest a img").shouldBe(visible).click();
        $("#allowed_interests").shouldBe(visible).$(byText(interest.getDescription())).click();
        saveButton.click();
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
    public MyProfilePage editOrientationInProfile(Orientations orientation) {
        $("#aboutsex a").scrollIntoView("{block: \"center\"}").click();
        $("#redit_orientation_options").$(byText(orientation.getDescription())).click();
        //  $("#ieditsubmit").click();
        saveButton.click();
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
    public MyProfilePage editReligionInProfile(Religions religion) {
        $("#type a").scrollIntoView("{block: \"center\"}").click();
        $("#redit_religion_options").$(byText(religion.getDescription())).click();
        saveButton.click();
        return this;
    }

    @Step("Проверка религии, указанной в анкете")
    public MyProfilePage checkReligionInProfile(Religions religion) {
        if (!(religion == Religions.NO_MATTER))
            $("#profile_view_type").shouldHave(text("religion"))
                    .shouldHave(text(religion.getDescription()))
                    .shouldBe(visible);
        else if ($("#profile_view_type").isDisplayed()) {
            $("#profile_view_type").shouldNotHave(text("religion"));
        }
        return this;
    }

    @Step("Открыть анкету нажатием на аватарку")
    public void openProfileByClickOnAva() {
        $(".user-menu-ava").click();

    }

    @Step("Открыть окно загрузки фото из своего профиля ")
    public PhotoPage openPhotoAddWindow() {
        if ($(".visitcard_nophoto").isDisplayed()) {
            $(".visitcard_nophoto").click();
        } else {
            $("#visitcard_avatar_block .add-photo").click();
        }
        $("#photos_add_window").shouldBe(visible);
        return new PhotoPage();
    }

    @Step("Нажать на карандашик для редактирования рядом с именем")
    public SettingsPage openSettingsByClickOnPencil() {
        $("a.profile_edit").click();
        $("#window_title").shouldHave(text("Profile settings"));
        return new SettingsPage();
    }


    @Step("Нажать на карандашик для редактирования рядом с именем")
    public MyProfilePage checkNameInProfile(String name) {

        $("#ivisitcard_info .user_name").shouldHave(text(name));
        return this;
    }

    @Step("Проверить что отображается логин")
    public MyProfilePage checkLoginInProfile(String login) {

        $("#ivisitcard_info .vc-user-name").shouldHave(text(login)).shouldBe(visible);
        return this;
    }

    @Step("Проверить, что включена ночная тема ")
    public void checkDarkTheme() {

        //   $("link[id='dark_theme_css']").isEnabled();
        $("link#dark_theme_css").isEnabled();

    }


}
