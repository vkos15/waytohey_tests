package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;


public class PhotoPage {


    @Step("Нажать на стрелку вправо")
    public void clickOnRightArrows() {
        $("#winPhotoScrollR").click();

    }

    @Step("Нажать на стрелку влево")
    public void clickOnLeftArrows() {
        $("#winPhotoScrollL").click();
    }

    @Step("Загрузить фото в профиль, в котором уже есть фото")
    public String uploadMyPhoto(String fileName) {
        $("#addPh").uploadFromClasspath(fileName);
        $("#page_upload .block_save").click();
        sleep(10000);
        String photo_id = $("#visitcard_avatar_block .secondary-photo").getAttribute("data-photoid");
        return photo_id;
    }

    @Step("Проверка количества отображаемых миниатюр фото в профиле")
    public void checkCountPhotoInProfile(int count) {
        $$("#visitcard_avatar_block .secondary-photo").shouldHave(size(count));
    }

    @Step("Удалить фото из профиля на десктопе нажатием на иконку настроек на миниатюре фото")
    public void delMyPhotoFromProfile(String photoID) {
        SelenideElement photo = $("div[data-photoid=" + "'" + photoID + "'] ");
        photo.scrollIntoView("{block: \"center\"}");
        actions().moveToElement(photo).click($("div[data-photoid=" + "'" + photoID + "'] a svg")).perform();
        $("a.photo-win-delete").shouldHave(text("Delete")).click();
        $("#photoDeletionForm a.block_save").shouldHave(text("Delete")).click();
    }

    @Step("Нажать на крестик в окне загрузки фото")
    public void tapOnX() {
        $("[id*='photos_add']").$(".close_window").click();
    }

    @Step ("Нажать Пропустить в окне с предложением загрузить фото")
    public void skipAddPhoto(){
        $("#skipWin .block_desave").click();
    }

    @Step("Закрыть окно с предложением загрузить фото")
    public void closeSuggestPhotoWindowIfItOpened() {
        if ($("#photos_add_window_suggest").isDisplayed()) {
            tapOnX();
            skipAddPhoto();
        }
    }

    @Step("Добавить видео-аватарку")
    public void uploadMyVideo(String fileName) {

        $(byText("Video")).click();
        $("#video_upload_form input#profile_upload_video").uploadFromClasspath(fileName);
        $(" .video-preview").shouldBe(visible);
        $(".video-timeline .slider").shouldBe(visible);
        $(byText("Cancel")).shouldBe(visible);
        $(byText("Add")).click();
        sleep(10000);
        // WebDriverRunner.getWebDriver().findElement(byId("profile_upload_video")).sendKeys(fileName);

        // File cv = new File(fileName);
        //  $("#profile_upload_video").uploadFile(cv);
        String video_id = $("#visitcard_avatar_block .secondary-photo").getAttribute("data-photoid");
    }

    @Step("Удалить видео-аватарку")
    public void deleteMyVideo() {
        $(byText("Video")).click();
        $(byText("Delete video")).click();
        $(byValue("Delete")).click();
    }

    @Step("Проверка, что на месте аватарки - видео")
    public void checkVideoOnAva() {
        $(" .video-avatar-block video").shouldBe(visible).shouldHave(attribute("autoplay", "true"));
    }

    @Step("Проверить, что в анкете нет видео-аватарки")
    public void checkThatNoVideoInProfile() {

        $(" .video-avatar-block video").shouldNotBe(visible);
    }

    @Step("Проверка правил загрузки фото")
    public void checkRulesOfPhotos() {
        $("#visualRules").shouldHave(text("No fake photos"))
                .shouldHave(text("otherwise they will be deleted"))
                .shouldBe(visible);
        //свайп влево
        $(byText("Choose your best photos")).parent().preceding(0).parent().shouldHave(cssClass("current"));
        actions().dragAndDropBy($(byText("Choose your best photos")), -30, 0).build().perform();
        sleep(1000);


/*
        actions().moveToElement($(byText("otherwise they will be deleted"))).clickAndHold()

                .moveToElement($("#labelImg"))
                .perform();
        //.moveByOffset(600,0).


*/

    }


}
